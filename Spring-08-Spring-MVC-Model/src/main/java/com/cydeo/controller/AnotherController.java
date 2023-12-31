package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/another")
public class AnotherController {
    @RequestMapping("list")  //localhost:8080/another/list
    public String showTable(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("ALi", "Yildiz",34, Gender.MALE));
        mentorList.add(new Mentor("Sezen","Unal",22,Gender.FEMALE));
        mentorList.add(new Mentor("Ammy","Winehouse",21,Gender.FEMALE));

        model.addAttribute("mentors",mentorList);

        return "mentor/mentor-list";

    }


}

