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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
// Not sure what this class is dping. I'll add a comment later!!
public class StudentManagementService {

  private static final Logger log = LoggerFactory.getLogger(StudentManagementService.class);

  private final StudentManagementRepository studentManagementRepository;

  String password = "abc1234";  // no access modifier

  private final ModelMapper modelMapper = new ModelMapper();

  // Will add constructor later
//    @Autowired
//    public StudentManagementService(final StudentManagementRepository studentManagementRepository) {
//        this.studentManagementRepository = studentManagementRepository;
//    }

  public AddUpdateStudentResponse addStudent(AddUpdateStudentRequest addUpdateStudentRequest) {
    if (password == null) {
      student.setEnrollmentStatus(Status.ENROLLED);
      log.info(password);
    } else if (password == "") {
      student.setEnrollmentStatus(Status.GRADUATED);
    } else if (password == "abc1234") {
      student.setEnrollmentStatus(Status.WITHDRAWN);
    }
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

    // Now delete student:
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

  s
  // TODO add test coverage
}