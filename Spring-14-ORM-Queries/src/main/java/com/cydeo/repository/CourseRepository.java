package com.cydeo.repository;


import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {
    //find all courses by category
    //I don't have any method to find courses based on category so we need to write by ourselves.
    List<Course> findByCategory(String category);
    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String pattern);
    //check if a course with the provided name exists. return true or false
    boolean existsByName(String name);
    //return the count of courses for the provided category
    Integer countByCategory(String category);
    //find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String name);
    //find all courses by category and returns a stream
    Stream<Course>streamByCategory(String name);
    //jpql with param
    @Query("SELECT c FROM Course c WHERE c.category=:category AND c.rating > :rating ")
    List<Course>findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);








}
