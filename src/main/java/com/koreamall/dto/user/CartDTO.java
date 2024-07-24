package com.koreamall.dto.user;

import com.koreamall.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {
    private Integer no;
    private UserDTO user; // 회원
    private ProductDTO product; // 장바구니의 상품
    private Integer amount; // 상품 수량
    private String color;
    private String size;
}
