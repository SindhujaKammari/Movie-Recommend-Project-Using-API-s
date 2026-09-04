package com.example.spring_learning;

import jakarta.validation.constraints.*;

public class Course {
    @Positive(message="Enter a proper Id")
    private int id;

    @NotBlank(message="Enter a proper Course Name") 
    private String courseName;

    @NotBlank(message="Enter a proper Title Duration")
    private String titleDuration;

    @DecimalMin(value = "0.0", inclusive = true, message = "Price cannot be negative")
    private double price;

    public Course(){}

    public Course(int id, String courseName, String titleDuration, double price){
        this.id = id;
        this.courseName = courseName;
        this.titleDuration = titleDuration;
        this.price = price;
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
    public double getPrice(){
        return price;
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
    public void setPrice(double price){
        this.price = price;
    }
}
