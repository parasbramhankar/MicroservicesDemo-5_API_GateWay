package com.example.WelcomeAPI.controller;

import com.example.WelcomeAPI.repo.GreetApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    GreetApiClient greetApiClient;

    @GetMapping("/welcome")
    public String welcome(){
        String str=greetApiClient.invokeGreetApi();

        return str+ "paras";
    }

}
