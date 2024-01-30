package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // this annotation is @Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id")Long courseId){
        return courseService.getCourseById(courseId);
    }
    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){
        List<CourseDTO> list = courseService.getCoursesByCategory(category);
        return list;
    }
    //We will use Post methods for creating a course and use general endpoint "courses"
    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }
    //Update method, I need two things; which object I need to update and what you need to update
    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }
    //Delete Method
    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable("id")Long id){
        courseService.deleteCourseById(id);
    }
    // Delete all courses
    @DeleteMapping
    public void deleteAllCourses(){
        courseService.deleteCourses();
    }



}







































