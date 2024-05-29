package com.cydeo.controller;

import com.cydeo.model.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PeopleController {
    @RequestMapping("/list")
    public String listStudent(Model model){
        List<String> list=new ArrayList<>();
        list.add("angle");
        list.add("mary");
        list.add("eva");

        model.addAttribute("list",list);

        People people=new People(1,"ozan","yorulmaz");
        model.addAttribute("people",people);


        return "people/list";
    }
}
