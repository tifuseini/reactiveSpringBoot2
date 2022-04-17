package com.springboot.reactiveSpringBoot2.controller;

import com.springboot.reactiveSpringBoot2.model.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

@RestController
public class ApiController {

    public static final Logger log = LoggerFactory.getLogger(ApiController.class);

    public static final String API_BASE_PATH = "/api/v1";

    @GetMapping(API_BASE_PATH + "/images")
    Flux<Image> images(){
        Hooks.onOperatorDebug();

        return Flux.just(
                new Image("1","Image 1"),
                new Image("2","Image 2"),
                new Image("3","Image 4")
        );
    }

    @PostMapping(API_BASE_PATH + "/images")
    Mono<Void> create(@RequestBody Flux<Image> images) {
        Hooks.onOperatorDebug();

        return images
                .map(image -> {
                    log.info("We will save " + image + " to a Reactive database soon!");
                    return image;
                })
                .then();
    }

}
