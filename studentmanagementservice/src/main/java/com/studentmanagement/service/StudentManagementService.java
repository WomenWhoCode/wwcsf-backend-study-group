package com.studentmanagement.service;

import com.studentmanagement.controller.dto.AddUpdateStudentRequest;
import com.studentmanagement.controller.dto.AddUpdateStudentResponse;
import com.studentmanagement.controller.dto.DeleteStudentResponse;
import com.studentmanagement.controller.dto.GetStudentResponse;
import com.studentmanagement.controller.dto.Status;
import com.studentmanagement.data.model.Student;
import com.studentmanagement.data.repository.StudentManagementRepository;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentManagementService {

  private final StudentManagementRepository studentManagementRepository;

  private final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  public StudentManagementService(final StudentManagementRepository studentManagementRepository) {
    this.studentManagementRepository = studentManagementRepository;
  }

  public AddUpdateStudentResponse addStudent(AddUpdateStudentRequest addUpdateStudentRequest) {
    Student student = modelMapper.map(addUpdateStudentRequest, Student.class);
    student.setEnrollmentStatus(Status.ENROLLED);
    try {
      studentManagementRepository.save(student);
    } catch (Exception e) {
      return null;
    }
    return new AddUpdateStudentResponse(student.getStudentId(), student.getEnrollmentStatus());
  }

  public GetStudentResponse getStudentById(Long studentId) {
    Optional<Student> student = studentManagementRepository.findById(studentId);
    return student.map(value -> modelMapper.map(value, GetStudentResponse.class)).orElse(null);
  }

  public AddUpdateStudentResponse updateStudentById(
      AddUpdateStudentRequest addUpdateStudentRequest,
      Long studentId
  ) {
    Optional<Student> savedStudent;
    try {
      savedStudent = studentManagementRepository.findById(studentId);
      if (!savedStudent.isPresent()) {
        return null;
      }
      mapStudentRequestToSavedStudent(addUpdateStudentRequest, savedStudent.get());
      studentManagementRepository.save(savedStudent.get());
    } catch (Exception e) {
      return null;
    }
    return new AddUpdateStudentResponse(savedStudent.get().getStudentId(),
        savedStudent.get().getEnrollmentStatus());
  }

  private void mapStudentRequestToSavedStudent(
      AddUpdateStudentRequest addUpdateStudentRequest,
      Student savedStudent
  ) {
    savedStudent.setFirstName(addUpdateStudentRequest.getFirstName());
    savedStudent.setLastName(addUpdateStudentRequest.getLastName());
    savedStudent.setDateOfBirth(addUpdateStudentRequest.getDateOfBirth());
    savedStudent.setYearOfEnrollment(addUpdateStudentRequest.getYearOfEnrollment());
    savedStudent.setDegree(addUpdateStudentRequest.getDegree());
    savedStudent.setAdvisor(addUpdateStudentRequest.getAdvisor());
    if (addUpdateStudentRequest.getEnrollmentStatus() != null) {
      savedStudent.setEnrollmentStatus(addUpdateStudentRequest.getEnrollmentStatus());
    } // Do not update unless the status changes
  }

  public DeleteStudentResponse deleteStudentById(Long studentId) {
    Optional<Student> savedStudent;
    try {
      savedStudent = studentManagementRepository.findById(studentId);
      if (!savedStudent.isPresent()) {
        return null;
      }
      studentManagementRepository.delete(savedStudent.get());
    } catch (Exception e) {
      return null;
    }
    return new DeleteStudentResponse(studentId, Status.DELETED);
  }
}