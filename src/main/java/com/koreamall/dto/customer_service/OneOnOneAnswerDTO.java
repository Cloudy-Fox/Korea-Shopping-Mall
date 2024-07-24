package com.koreamall.dto.customer_service;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OneOnOneAnswerDTO {
    private Integer no; // PK. 번호
    private String userId; // 답변자
    private Integer oneOnOneNo; // 게시물번호
    private String answer; // 답변내용
    private LocalDateTime writeDatetime; // 답변날짜
}
