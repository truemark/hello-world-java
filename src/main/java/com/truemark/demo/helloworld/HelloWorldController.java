package com.truemark.demo.helloworld;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${message}")
    private String message;

    public static class Hello {
        private String message;

        public Hello setMessage(String message) {
            this.message = message;
            return this; // For chaining
        }

        public String getMessage() {
            return message;
        }
    }

    @RequestMapping(value = "**")
    public ResponseEntity<Hello> hello(HttpServletRequest req) {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.noStore())
                .body(new Hello().setMessage(message));
    }
}
