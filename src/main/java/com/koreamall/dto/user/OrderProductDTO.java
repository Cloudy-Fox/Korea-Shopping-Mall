package com.koreamall.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProductDTO {
    private Integer no;
    private String color;
    private String size;
    private Integer amount;
    private Integer price;
}
