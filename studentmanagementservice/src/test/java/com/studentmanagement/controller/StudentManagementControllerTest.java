package com.studentmanagement.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.studentmanagement.controller.StudentManagementController;
import com.studentmanagement.controller.dto.AddUpdateStudentRequest;
import com.studentmanagement.controller.dto.AddUpdateStudentResponse;
import com.studentmanagement.controller.dto.Degree;
import com.studentmanagement.controller.dto.DeleteStudentResponse;
import com.studentmanagement.controller.dto.GetStudentResponse;
import com.studentmanagement.controller.dto.Status;
import com.studentmanagement.controller.error.Error;
import com.studentmanagement.data.model.Student;
import com.studentmanagement.data.repository.StudentManagementRepository;
import com.studentmanagement.service.StudentManagementService;
import java.sql.Date;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentManagementControllerTest {

  private static final Long STUDENT_ID = 1L;
  private final ModelMapper modelMapper = new ModelMapper();

  private final StudentManagementRepository studentManagementRepository = Mockito
      .mock(StudentManagementRepository.class);

  private final StudentManagementService studentManagementService = Mockito
      .mock(StudentManagementService.class);

  private final StudentManagementController studentManagementController = new StudentManagementController(
      this.studentManagementService);

  @Test
  public void testAddStudent() {
    AddUpdateStudentRequest expectedAddStudentRequest = buildAddUpdateStudentRequest();
    Student expectedStudent = modelMapper.map(expectedAddStudentRequest, Student.class);
    AddUpdateStudentResponse expectedAddStudentResponse = new AddUpdateStudentResponse(
        STUDENT_ID, Status.ENROLLED);
    when(studentManagementRepository.save(expectedStudent)).thenReturn(expectedStudent);
    when(studentManagementService.addStudent(expectedAddStudentRequest))
        .thenReturn(expectedAddStudentResponse);

    ResponseEntity actualAddStudentResponse = studentManagementController
        .addStudent(expectedAddStudentRequest);

    verify(studentManagementService).addStudent(any());
    assertThat(actualAddStudentResponse.getStatusCode(), equalTo(HttpStatus.CREATED));
    assertEquals(expectedAddStudentResponse, actualAddStudentResponse.getBody());
  }

  @Test
  public void testAddStudentError() {
    ResponseEntity actualAddStudentResponse = studentManagementController
        .addStudent(new AddUpdateStudentRequest());

    verify(studentManagementService).addStudent(any());
    Error actualResponseError = (Error) actualAddStudentResponse.getBody();
    assertNotNull(actualResponseError);
    assertThat(actualAddStudentResponse.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getHttpStatus(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getErrorMessage(), equalTo("Error adding a new student"));
  }

  @Test
  public void testGetStudent() {
    final GetStudentResponse expectedGetStudentResponse = buildGetStudentResponse();
    Student expectedStudent = modelMapper.map(expectedGetStudentResponse, Student.class);
    when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));
    when(studentManagementService.getStudentById(STUDENT_ID))
        .thenReturn(expectedGetStudentResponse);

    ResponseEntity actualGetStudentResponse = studentManagementController
        .getStudentById(STUDENT_ID);

    verify(studentManagementService).getStudentById(any());
    assertThat(actualGetStudentResponse.getStatusCode(), equalTo(HttpStatus.OK));
    assertEquals(expectedGetStudentResponse, actualGetStudentResponse.getBody());
  }

  @Test
  public void testGetStudentError() {
    ResponseEntity actualGetStudentResponse = studentManagementController
        .getStudentById(STUDENT_ID);

    verify(studentManagementService).getStudentById(any());
    Error actualResponseError = (Error) actualGetStudentResponse.getBody();
    assertNotNull(actualResponseError);
    assertThat(actualGetStudentResponse.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getHttpStatus(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getErrorMessage(),
        equalTo("Error finding student Id=" + STUDENT_ID));
  }

  @Test
  public void testUpdateStudent() {
    AddUpdateStudentRequest expectedUpdateStudentRequest = buildAddUpdateStudentRequest();
    expectedUpdateStudentRequest.setEnrollmentStatus(Status.GRADUATED);  // Status updated
    Student expectedStudent = modelMapper.map(expectedUpdateStudentRequest, Student.class);
    AddUpdateStudentResponse expectedUpdateStudentResponse = new AddUpdateStudentResponse(
        STUDENT_ID, Status.ENROLLED);
    when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));
    when(studentManagementRepository.save(expectedStudent)).thenReturn(expectedStudent);
    when(studentManagementService.updateStudentById(expectedUpdateStudentRequest, STUDENT_ID))
        .thenReturn(expectedUpdateStudentResponse);

    ResponseEntity actualUpdateStudentResponse = studentManagementController
        .updateStudentById(expectedUpdateStudentRequest, STUDENT_ID);

    verify(studentManagementService).updateStudentById(any(), any());
    assertThat(actualUpdateStudentResponse.getStatusCode(), equalTo(HttpStatus.OK));
    assertEquals(expectedUpdateStudentResponse, actualUpdateStudentResponse.getBody());
  }

  @Test
  public void testUpdateStudentError() {
    ResponseEntity actualUpdateStudentResponse = studentManagementController
        .updateStudentById(new AddUpdateStudentRequest(), STUDENT_ID);

    verify(studentManagementService).updateStudentById(any(), any());
    Error actualResponseError = (Error) actualUpdateStudentResponse.getBody();
    assertNotNull(actualResponseError);
    assertThat(actualUpdateStudentResponse.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getHttpStatus(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getErrorMessage(),
        equalTo("Error updating student Id=" + STUDENT_ID));
  }

  @Test
  public void testDeleteStudent() {
    AddUpdateStudentRequest expectedDeleteStudentRequest = buildAddUpdateStudentRequest();
    Student expectedStudent = modelMapper.map(expectedDeleteStudentRequest, Student.class);
    DeleteStudentResponse expectedDeleteStudentResponse = new DeleteStudentResponse(STUDENT_ID,
        Status.DELETED);
    when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));
    when(studentManagementService.deleteStudentById(STUDENT_ID))
        .thenReturn(expectedDeleteStudentResponse);

    ResponseEntity actualDeleteStudentResponse = studentManagementController
        .deleteStudentById(STUDENT_ID);

    verify(studentManagementService).deleteStudentById(any());
    assertThat(actualDeleteStudentResponse.getStatusCode(), equalTo(HttpStatus.OK));
    assertEquals(expectedDeleteStudentResponse, actualDeleteStudentResponse.getBody());
  }

  @Test
  public void testDeleteStudentError() {
    ResponseEntity actualDeleteStudentResponse = studentManagementController
        .deleteStudentById(STUDENT_ID);

    verify(studentManagementService).deleteStudentById(any());
    Error actualResponseError = (Error) actualDeleteStudentResponse.getBody();
    assertNotNull(actualResponseError);
    assertThat(actualDeleteStudentResponse.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getHttpStatus(), equalTo(HttpStatus.BAD_REQUEST));
    assertThat(actualResponseError.getErrorMessage(),
        equalTo("Error deleting student Id=" + STUDENT_ID));
  }

  private AddUpdateStudentRequest buildAddUpdateStudentRequest() {
    AddUpdateStudentRequest expectedAddUpdateStudentRequest = new AddUpdateStudentRequest();
    expectedAddUpdateStudentRequest.setFirstName("Jane");
    expectedAddUpdateStudentRequest.setLastName("Doe");
    expectedAddUpdateStudentRequest.setDateOfBirth(Date.valueOf("1990-01-12"));
    expectedAddUpdateStudentRequest.setYearOfEnrollment("2021");
    expectedAddUpdateStudentRequest.setDegree(Degree.COMPUTER_SCIENCE);
    expectedAddUpdateStudentRequest.setAdvisor("Prof. Kate Harris");
    expectedAddUpdateStudentRequest.setEnrollmentStatus(Status.ENROLLED);
    return expectedAddUpdateStudentRequest;
  }

  private GetStudentResponse buildGetStudentResponse() {
    GetStudentResponse expectedGetStudentResponse = new GetStudentResponse();
    expectedGetStudentResponse.setStudentId(STUDENT_ID);
    expectedGetStudentResponse.setFirstName("Jane");
    expectedGetStudentResponse.setLastName("Doe");
    expectedGetStudentResponse.setDateOfBirth(Date.valueOf("1990-01-12"));
    expectedGetStudentResponse.setYearOfEnrollment("2021");
    expectedGetStudentResponse.setDegree(Degree.COMPUTER_SCIENCE);
    expectedGetStudentResponse.setAdvisor("Prof. Kate Harris");
    expectedGetStudentResponse.setEnrollmentStatus(Status.ENROLLED);
    return expectedGetStudentResponse;
  }
}
