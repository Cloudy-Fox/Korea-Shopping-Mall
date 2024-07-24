package com.koreamall.service.user;

import com.koreamall.dto.user.SocialUserDTO;
import com.koreamall.dto.user.UserDTO;
import com.koreamall.mapper.UserMapper;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Log4j2
@Service
public class CustomOAuth2DetailsService extends DefaultOAuth2UserService {
    @Autowired private UserMapper userMapper;

    // 모든 유저에 공통적으로 적용할 CI값. 테스트용... 실 운용에서는 실제값 사용해야 함
    private final String CI = "";

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();
        log.info("[" + clientName + "] (으)로 로그인 중입니다....");
        // 실제 로그인 진행.
        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 로그인된 유저의 동의항목을 포함하여 유저 정보를 받아온다 (user-info)
        Map<String, Object> userProperties = oAuth2User.getAttributes();

        SocialUserDTO socialUserDTO = switch (clientName.toUpperCase()){
            case "GOOGLE" -> google_login(userProperties);
            case "KAKAO" -> kakao_login(userProperties);
            case "NAVER" -> naver_login(userProperties);
            default -> throw new OAuth2AuthenticationException("허용되지 않는 유형의 소셜 인증: " + clientName.toUpperCase());
        };
        // 해당 SNS 유저로 기존 유저를 찾는다 (CI 값으로 찾는다)
        UserDTO findUser = userMapper.selectUserByCi(socialUserDTO.getCi());
        // 해당 소셜 정보로 가입된 유저를 찾는다
        SocialUserDTO findSocialUser = userMapper.selectSocialUserById(socialUserDTO.getId());
        // 해당 유저가 존재함
        if(Objects.nonNull(findUser)){
            // 해당 유저가 이 소셜 로그인으로 로그인한 기록이 없는가? =>
            // 기존 유저와 소셜 유저를 연결 시키면 된다! (Insert)
            if(Objects.isNull(findSocialUser)){
                userMapper.insert_socialUser(socialUserDTO);
            }
            // 찾은 유저로 로그인 시키기
            return findUser;
        }

        // 해당 유저가 존재하지 않음 => 먼저 회원부터 회원가입을 시켜야 함 ....
        return oAuth2User;
    }

    private SocialUserDTO naver_login(Map<String, Object> userProperties) {
        String message = userProperties.get("message").toString();
        Map<String, String> response = (Map<String, String>) userProperties.get("response");
        String id = response.get("id");
        String profileImageURL = response.get("profile_image");
        String email = response.get("email");
        String name = response.get("name");
        return SocialUserDTO.builder()
                .id(id).ci(CI)
                .profileImageUrl(profileImageURL)
                .email(email)
                .name(name)
                .build();
    }

    private SocialUserDTO kakao_login(Map<String, Object> userProperties) {
        String id = userProperties.get("id").toString();
        Map<String, String> properties = (Map<String, String>) userProperties.get("properties");
        String nickName = properties.get("nickname");
        String profileImageURL = properties.get("profile_image");
        return SocialUserDTO.builder()
                .id(id).ci(CI)
                .profileImageUrl(profileImageURL)
                .nickName(nickName)
                .build();
    }

    private SocialUserDTO google_login(Map<String, Object> userProperties) {
        String id = userProperties.get("sub").toString();
        String name = userProperties.get("name").toString();
        String profileImageURL = userProperties.get("picture").toString();
        String email = userProperties.get("email").toString();
        return SocialUserDTO.builder()
                .id(id).ci(CI)
                .name(name)
                .profileImageUrl(profileImageURL)
                .email(email)
                .build();
    }








}
