package com.studentmanagement.controller.dto;

public class DeleteStudentResponse {

  private Long studentId;

  private Status deletionStatus;

  public DeleteStudentResponse() {
  }

  public DeleteStudentResponse(Long studentId, Status deletionStatus) {
    this.studentId = studentId;
    this.deletionStatus = deletionStatus;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Status getDeletionStatus() {
    return deletionStatus;
  }

  public void setDeletionStatus(Status deletionStatus) {
    this.deletionStatus = deletionStatus;
  }
}