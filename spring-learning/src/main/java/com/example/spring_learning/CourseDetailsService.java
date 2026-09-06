package com.example.spring_learning;
import java.util.*;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class CourseDetailsService {
    private CourseRepository courseRepository;

    public CourseDetailsService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    //get all the courses
    public List<Course> getCourseDetails(){
        return courseRepository.findAll();
    }

    //get the course by particular ID
    public Course getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }
    
    //add the course into db
    public String addCourse(Course course){
        if(course != null){
            courseRepository.save(course);
            return "Added Succesfully!";
        }
        return "Nothing is there to be added ";
    }


    //updating/modifying the course using particular ID
    @Transactional
    public Course updateCourse(int id , Course updateCourse ){
        Course course = courseRepository.findById(id).orElse(null);
        if(course !=null){
            course.setCourseName(updateCourse.getCourseName());
            course.setTitleDuration(updateCourse.getTitleDuration());
            course.setPrice(updateCourse.getPrice());
            System.out.println("Updated Successfully!");
            return course;
        }
        return null;
    }

    //Delete the course from db;
    @Transactional
    public String deleteCourse(int id){
        Course course = courseRepository.findById(id).orElse(null);
        if(course != null){
            courseRepository.delete(course);
            return "Deleted Successfully!";
        }
        return "Data NOt Found";
    }
}