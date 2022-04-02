package com.studentmanagement.controller.dto;

import java.sql.Date;

public class AddUpdateStudentRequest {

  private String firstName;

  private String lastName;

  private Date dateOfBirth;

  private String yearOfEnrollment;

  private Degree degree;

  private String advisor;

  private Status enrollmentStatus;

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
