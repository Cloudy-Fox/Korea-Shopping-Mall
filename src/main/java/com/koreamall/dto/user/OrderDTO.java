package com.koreamall.dto.user;

import com.koreamall.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderDTO {
    private String id; // merchant_uid 와 같은 주문번호
    private UserDTO user; // 주문자 ( == 결제자)
    private List<OrderProductDTO> products; // 주문한 상품들
    private String title; // 주문명
    private String receiverName; // 받는사람 (== 주문자명)
    private String receiverPhone; // 받는사람 휴대폰 (== 주문자 휴대폰)
    private String receiverPostcode; // 받는사람 주소 (== 주문자 주소)
    private String receiverAddress; // 받는사람 주소 (== 주문자 주소)
    private String memo; // 메모
    private String impUid; // 포트원 결제번호
    private String payMethod; // 결제 수단 (신용카드, 카카오페이 등..)
    private Integer paidAmount; // 결제 총 가격
    private Long paidAt; // 결제 시각
}
