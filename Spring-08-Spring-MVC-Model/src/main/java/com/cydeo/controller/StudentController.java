package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class StudentController {
    @RequestMapping("/welcome")

    public String homePage(Model model){
        //this is model interface from spring
        model.addAttribute("name","cydeo");
        model.addAttribute("course","MVC");
        String subject="Collections";
        model.addAttribute("subject",subject);

        // create some random student id(0-1000) and show it in your UI

        int studentId=new Random().nextInt(0,1000);
        model.addAttribute("id", studentId);
        List numbers=new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        model.addAttribute("numbers", numbers);

        Student student =new Student(1,"Mike", "Smith");
        model.addAttribute("student",student);

        return "/student/welcome";
    }

}
