package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
//@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")  // It has the same function with @RequestMapping above
    public String register(Model model){
    model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
        //It means return view to html file. whenever I call this end point
        //which is localhost 8080/student/register, this method will be executed and this method returning view
        //that view? it is inside the student folder there is register html. It will be in static folder if it
        // does not carry any data. But if you need to bind some data then you need to use template engine
        // which is thymeleaf

    }
   // @RequestMapping("/welcome")
    @GetMapping("/welcome") // It has the same function with @RequestMapping above
    public String info(){

    return "student/welcome";
    }

}
