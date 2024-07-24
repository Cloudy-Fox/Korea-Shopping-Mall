package com.koreamall.contoller;

import com.koreamall.dto.FileDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/image/{uuid}")
    public ResponseEntity<byte[]> get_image_file(
            @PathVariable("uuid") String uuid
    ){
//        if(Objects.isNull(fileDTO)){
//            System.out.println("ERROR: file not founded!");
//            return ResponseEntity.notFound().build();
//        }
//        System.out.println("file founded!: " + fileDTO);
//        byte[] data = fileDTO.getData();
//        String originalFileNameEncoded = URLEncoder.encode(fileDTO.getOriginalFileName(), StandardCharsets.UTF_8);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/octet-stream");
//        headers.add("Content-Disposition", "attachment; filename=" + originalFileNameEncoded);
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(data);
        return null;
    }


}
