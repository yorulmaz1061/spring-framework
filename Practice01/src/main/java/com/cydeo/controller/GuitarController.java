package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guitar")
public class GuitarController {
    @RequestMapping("/info") //localhost8080/guitar/info?model=electro. I want to print into browser
    public String guitarInfo(@RequestParam String models, Model model){
       // System.out.println(model);
        model.addAttribute("models",models);


        return "guitar/guitar-info";
    }
    @RequestMapping("/info2/{make}")
    public String getInfo(@PathVariable String make, Model model){
        model.addAttribute("make",make);
        return "guitar/guitar-info";
    }

}
