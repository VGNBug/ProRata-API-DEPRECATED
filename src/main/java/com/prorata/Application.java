package com.prorata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Application {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Welcome to the ProRata-API!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}