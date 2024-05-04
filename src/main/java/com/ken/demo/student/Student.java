package com.ken.demo.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ken.demo.school.School;
import com.ken.demo.studentProfile.StudentProfile;
import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Column(
            name = "c_fname"
    )
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;

    @OneToOne(
            mappedBy = "student", // student's name should be the same when creating student var
            cascade = CascadeType.ALL // this means if deleting student, the studentProfile will also be deleted.
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;


    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
