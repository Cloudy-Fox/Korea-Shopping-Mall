package com.koreamall.service.customer_service;

import com.koreamall.dto.FileDTO;
import com.koreamall.dto.customer_service.OneOnOneAnswerDTO;
import com.koreamall.dto.customer_service.OneOnOneDTO;
import com.koreamall.mapper.CustomerServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {
    @Autowired private CustomerServiceMapper customerServiceMapper;
    // 문의 게시물 가져오기
    public List<OneOnOneDTO> get_posts(String query, String keyword){
        return customerServiceMapper.selectOneOnOnes(query, keyword);
    }

    // 해당 번호의 문의 게시물 하나를 가져오기
    public OneOnOneDTO get_post(Integer postNo){
        return customerServiceMapper.selectOneOnOneByNo(postNo);
    }
    
    // 문의 게시물 작성
    public void create_post(OneOnOneDTO oneOnOneDTO){
        // 게시물 insert(작성)한다
        customerServiceMapper.insertOneOnOnePost(oneOnOneDTO);
        System.out.println(oneOnOneDTO);

        // 게시물의 파일들을 insert 한다
        if(!Objects.isNull(oneOnOneDTO.getFiles())){
            customerServiceMapper.insertOneOnOneFiles(oneOnOneDTO);
        }
    }

    // 문의 게시물 조회수 1증가
    public void increase_post_view_count(Integer postNo){
        customerServiceMapper.updateOneOnOnePostViewCount(postNo);
    }

    /**************************** 답변 *************************/
    public void create_answer(OneOnOneAnswerDTO oneOnOneAnswerDTO){
        customerServiceMapper.insertOneOnOneAnswerOfOneOnOneNo(oneOnOneAnswerDTO);
    }
    
    
    /**************************** 파일 *****************************/
    // one_on_one 게시판의 파일 가져오기
    public FileDTO get_file_of_one_on_one(String UUID){
        return customerServiceMapper.selectOneOnOneFileByUUID(UUID);
    }
    

    /********************************** REST ***************************************/
    // 게시물이 공개 상태인가 비공개 상태인가를 반환
    public Boolean get_post_isOpened(Integer no){
        return customerServiceMapper.selectOneOnOneIsOpened(no);
    }
    // 해당 게시물의 패스워드가 일치하는가?
    public Boolean get_post_password_isCorrect(Integer postNo, String password){
        return customerServiceMapper.selectOneOnOnePasswordIsCorrect(postNo, password);
    }








}
