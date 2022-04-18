package com.springboot.reactiveSpringBoot2.controller;

import com.springboot.reactiveSpringBoot2.service.ImageService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    private static final String BASE_PATH = "/images";

    private static final String FILENAME = "{filename:.+}";

    private final ImageService imageService;

    public HomeController(ImageService imageService){
        this.imageService = imageService;
    }
}
