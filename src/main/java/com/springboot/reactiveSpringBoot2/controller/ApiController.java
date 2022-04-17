package com.springboot.reactiveSpringBoot2.controller;

import com.springboot.reactiveSpringBoot2.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private static final String API_BASE_PATH = "/api/v1";

    @GetMapping(API_BASE_PATH + "/images")
    Flux<Image> images(){
        Hooks.onOperatorDebug();

        return Flux.just(
                new Image(1,"Image 1"),
                new Image(2,"Image 2"),
                new Image(3,"Image 4")
        );
    }

}
