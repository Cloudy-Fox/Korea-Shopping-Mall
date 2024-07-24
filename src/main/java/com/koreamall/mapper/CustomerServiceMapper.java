package com.koreamall.mapper;

import com.koreamall.dto.FileDTO;
import com.koreamall.dto.customer_service.OneOnOneAnswerDTO;
import com.koreamall.dto.customer_service.OneOnOneDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerServiceMapper {
    /******************* one on one board *****************/
    List<OneOnOneDTO> selectOneOnOnes(
            @Param("query") String query,
            @Param("keyword") String keyword
    );
    OneOnOneDTO selectOneOnOneByNo(Integer no);
    void insertOneOnOnePost(OneOnOneDTO oneOnOneDTO);
    void insertOneOnOneFiles(OneOnOneDTO oneOnOneDTO);
    void updateOneOnOnePostViewCount(Integer no);
    /******************* answer *****************/
    void insertOneOnOneAnswerOfOneOnOneNo(OneOnOneAnswerDTO oneOnOneAnswerDTO);
    /******************* files *****************/
    FileDTO selectOneOnOneFileByUUID(String UUID);

    /******************************* REST ************************/
    Boolean selectOneOnOneIsOpened(Integer no);
    Boolean selectOneOnOnePasswordIsCorrect(
            @Param("no") Integer no,
            @Param("password") String password
    );

}
