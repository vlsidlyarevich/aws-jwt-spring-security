package com.github.vlsidlyarevich.application.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Secured Hello controller.
 */
@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    /**
     * Say hello response entity.
     *
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity sayHello() {
        return ResponseEntity.ok().body("secured hello");
    }
}
