package com.example.spring_learning;
import jakarta.validation.constraints.Positive;


public class Course {
    @Positive(message="Enter a proper Id")
    private int id;

    @Positive(message="Enter a proper Course Name")
    private String courseName;

    @Positive(message="Enter a proper Title Duration")
    private String titleDuration;

    public Course(){}

    public  Course(int id, String courseName , String titleDuration){
        this.id = id;
        this.courseName = courseName;
        this.titleDuration = titleDuration; 
    }

    //getters
    public int getId(){
        return id;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getTitleDuration(){
        return titleDuration;
    }

    //setters
    public void setId(int id){
        this.id=id;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setTitleDuration(String titleDuration){
        this.titleDuration = titleDuration;
    }
}
