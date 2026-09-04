package com.example.spring_learning;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseDetailsService {
    private List<Course> courseDetails = new ArrayList<>(Arrays.asList(
                    new Course(1, "Java Spring Boot", "10 Weeks", 200),
                    new Course(2, "React Basics", "6 Weeks", 150.55),
                    new Course(3, "Node.js Fundamentals", "5 Weeks", 100.55),
                    new Course(4, "JavaScript Essentials", "4 Weeks", 80.55),
                    new Course(5, "Data Structures in Java", "8 Weeks", 130.55),
                    new Course(6, "REST API Design", "3 Weeks", 110.55),
                    new Course(7, "Full-Stack Web Dev", "12 Weeks", 300.55),
                    new Course(8, "SQL & Database Design", "4 Weeks", 90.55),
                    new Course(9, "Git & GitHub Mastery", "2 Weeks", 50.55),
                    new Course(10, "Python for Beginners", "6 Weeks", 85.55)
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

    public void addCourse(Course course1){
       courseDetails.add(course1);
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
