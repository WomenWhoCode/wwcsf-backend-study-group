package com.studentmanagement.data.model;

import com.studentmanagement.controller.dto.Degree;
import com.studentmanagement.controller.dto.Status;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long studentId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "year_of_enrollment")
  private String yearOfEnrollment;

  @Enumerated(EnumType.STRING)
  @Column(name = "degree")
  private Degree degree;

  @Column(name = "advisor")
  private String advisor;

  @Enumerated(EnumType.STRING)
  @Column(name = "enrollment_status")
  private Status enrollmentStatus;

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getYearOfEnrollment() {
    return yearOfEnrollment;
  }

  public void setYearOfEnrollment(String yearOfEnrollment) {
    this.yearOfEnrollment = yearOfEnrollment;
  }

  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }

  public String getAdvisor() {
    return advisor;
  }

  public void setAdvisor(String advisor) {
    this.advisor = advisor;
  }

  public Status getEnrollmentStatus() {
    return enrollmentStatus;
  }

  public void setEnrollmentStatus(Status enrollmentStatus) {
    this.enrollmentStatus = enrollmentStatus;
  }
}
