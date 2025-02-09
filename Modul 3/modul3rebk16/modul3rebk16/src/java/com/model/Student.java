/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.NamedQueries; 
import javax.persistence.NamedQuery; 
import javax.persistence.Table; 
import javax.persistence.Column;

/**
 *
 * @author USER
 */
@Entity
@Table 
@NamedQueries({@NamedQuery(name="Student.getAll",query="SELECT e FROM Student e order by e.studentId")})

public class Student implements Serializable {

    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private int studentId; 
    @Column 
    private String firstName; 
    @Column 
    private String lastName; 
    public Student(int studentId, String firstName, String lastName) { 
    this.studentId = studentId; 
    this.firstName = firstName; 
    this.lastName = lastName; 
    } 
    public Student() { 
    } 
    public void setStudentId(int studentId) { 
    this.studentId = studentId; 
    } 
    public int getStudentId() { 
    return studentId; 
    } 
    public void setFirstName(String firstName) { 
    this.firstName = firstName; 
    } 
    public String getFirstName() { 
    return firstName; 
    } 
    public void setLastName(String lastName) { 
    this.lastName = lastName; 
    } 
    public String getLastName() { 
    return lastName; 
    } 
}
