package com.studentmanagement.controller.dto;

public class AddUpdateStudentResponse {

  private Long studentId;

  private Status enrollmentStatus;

  public AddUpdateStudentResponse() {
  }

  public AddUpdateStudentResponse(Long studentId, Status enrollmentStatus) {
    this.studentId = studentId;
    this.enrollmentStatus = enrollmentStatus;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Status getEnrollmentStatus() {
    return enrollmentStatus;
  }

  public void setEnrollmentStatus(Status enrollmentStatus) {
    this.enrollmentStatus = enrollmentStatus;
  }
}