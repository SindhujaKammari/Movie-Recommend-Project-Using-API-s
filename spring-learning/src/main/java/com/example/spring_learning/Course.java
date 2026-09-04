package com.example.spring_learning;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity 
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Positive(message="Enter a proper Id")
    private int id;

    @Column(name="courseName")
    @NotBlank(message="Enter a proper Course Name") 
    private String courseName;

    @Column(name="titleDuration")
    @NotBlank(message="Enter a proper Title Duration")
    private String titleDuration;

    @Column(name="price")
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
