package ru.usatu.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/")
public class ViewController {
    @GetMapping
    public String getView(){
        return "Vue/index.html";
    }
}
