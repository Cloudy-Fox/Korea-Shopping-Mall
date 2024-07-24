package com.koreamall.mapper;

import com.koreamall.dto.CategoryDTO;
import com.koreamall.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO> selectProductsByCategoryNo(Integer categoryNo);
    ProductDTO selectProductByNo(Integer no);
    
    /***************** 카테고리 관련 ************/
    // 존재하는 모든 카테고리의 조회
    List<CategoryDTO> selectCategories();
    // 해당 카테고리 번호의 최상위 카테고리의 조회
    CategoryDTO selectCategory(Integer categoryNo);
}
