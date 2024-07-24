package com.koreamall.service;

import com.koreamall.dto.FileDTO;
import com.koreamall.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {

    @Autowired private ProductMapper productMapper;

    private String path = "C:\\Users\\Administrator\\Desktop\\KSW\\images";
//    public FileDTO get_product_file(String uuid){
//        File file = new File(path, uuid);
//
//    }
}
