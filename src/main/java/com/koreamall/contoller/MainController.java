package com.koreamall.contoller;

import com.koreamall.dto.CategoryDTO;
import com.koreamall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/main")
    public void get_main(){}
}
