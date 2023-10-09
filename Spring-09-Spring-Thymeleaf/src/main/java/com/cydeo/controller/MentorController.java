package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
 @RequestMapping("/mentor")
public class MentorController {
    //Whenever I type localhost:8080/mentor/register I wanna get a form
    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("mentor", new Mentor());
        //one empty object  I passed.
        List<String> batchList= Arrays.asList("JD1","JD2","EU1","EU2","B18","B20");
        model.addAttribute("batchList", batchList);

        return "mentor/mentor-register";
    }
    @PostMapping ("/confirm")
    public String showForm2(@ModelAttribute("mentor") Mentor mentor){
    //it means that above local variable "mentor" can be  used by @ModelAttribute and passing to mentor object below
        //We don't create new mentor object, we use above created and filled mentor object.
       // System.out.println(mentor.toString());


     //   return "mentor/mentor-confirmation";
        return "redirect:/mentor/register";

    }



}
