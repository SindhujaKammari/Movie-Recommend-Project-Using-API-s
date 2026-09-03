package com.example.spring_learning;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CourseDetailsService {
    private List<Course> courseDetails = new ArrayList<>(Arrays.asList(
        new Course(1, "Java Programming Fundamentals", "6-months"),
        new Course(2, "MERN Stack Web Development", "4-months"),
        new Course(3, "Spring Boot & REST Application Development", "3-months"),
        new Course(4, "Data Structures & Dynamic Programming", "5-months"),
        new Course(5, "Frontend Development with React", "3-months"),
        new Course(6, "Object-Oriented Programming Principles", "2-months"),
        new Course(7, "Computer Vision with OpenCV & Python", "4-months"),
        new Course(8, "WordPress & E-Commerce Site Management", "2-months"),
        new Course(9, "Computer Networking & Security Fundamentals", "3-months"),
        new Course(10, "Backend Development with Node.js & Express", "4-months")
    ));

    public List<Course> getCourseDetails(){
        return courseDetails ;
    }

    public Course getCourseById(int id){
        for(Course course : courseDetails){
            if(id == course.getId()){
                return course;
            }
        }
        return null;
    }

    public void addCourse(List<Course> course1){
        for(Course course: course1){
            courseDetails.add(course);
        }
    }

    //update the existing course
    public Course updateCourse(int id , Course updateCourse){
        for(Course course: courseDetails){
            if(id == course.getId()){
                course.setCourseName(updateCourse.getCourseName());
                course.setTitleDuration(updateCourse.getTitleDuration());
                return course;
            }
        }
        return null;
    }

    //delete the existing course
    public List<Course> deleteCourse(int id){
        boolean removeCourse = courseDetails.removeIf(course -> id == course.getId());
        if(removeCourse){
            return courseDetails;
        }
        return null;
    }

}
