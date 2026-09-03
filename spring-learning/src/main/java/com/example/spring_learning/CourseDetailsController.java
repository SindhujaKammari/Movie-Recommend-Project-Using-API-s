package com.example.spring_learning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseDetailsController {

    @Autowired 
    private CourseDetailsService courseDetailsService;

    // Get all courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseDetailsService.getCourseDetails());
    }

    // Get a single course by ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = courseDetailsService.getCourseById(id);
        if(course != null){
            return ResponseEntity.ok(courseDetailsService.getCourseById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/courses")
    public ResponseEntity<String> addCourse(@RequestBody List<Course> course) {
        if(course != null){
            courseDetailsService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Bad Data");
    }

    //modify existing data using id
    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id , @RequestBody Course updateCourse){
        return courseDetailsService.updateCourse(id,updateCourse);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        Course course = courseDetailsService.getCourseById(id);
        if(course!=null){
            return ResponseEntity.ok(courseDetailsService.deleteCourse(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data of particular Id is NOT_FOUND");
    }
}