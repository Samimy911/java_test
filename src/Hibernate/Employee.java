/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hibernate;

/**
 *
 * 
 */

import javax.persistence.*;
/**
 * ?
 * Entity class
 */

@Entity
@Table(name = "employs")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "location")
    private String location;

    // Constructors
    public Employee() {}
    public Employee(String firstname, String location) {
        this.firstname = firstname;
        this.location  = location;
    }

    // Getters & Setters
    public int    getId()        { return id; }
    public String getFirstname() { return firstname; }
    public String getLocation()  { return location; }
    public void   setFirstname(String firstname) { this.firstname = firstname; }
    public void   setLocation(String location)   { this.location  = location;  }
}