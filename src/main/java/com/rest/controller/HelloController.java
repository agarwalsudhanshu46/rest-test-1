package com.rest.controller;

import com.rest.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {


    @RequestMapping(method = RequestMethod.GET)
    public String sayHello() {
        return "hello!";
    }

}
