package com.studentmanagement.controller;

import com.studentmanagement.controller.dto.AddUpdateStudentRequest;
import com.studentmanagement.controller.dto.AddUpdateStudentResponse;
import com.studentmanagement.controller.dto.DeleteStudentResponse;
import com.studentmanagement.controller.dto.GetStudentResponse;
import com.studentmanagement.controller.error.Error;
import com.studentmanagement.service.StudentManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prachi.shah
 */
@RestController
@RequestMapping(value = "/studentmanagementservice/",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentManagementController {

    private static final Logger log = LoggerFactory.getLogger(StudentManagementController.class);

    private final StudentManagementService studentManagementService;

    @Autowired
    public StudentManagementController(final StudentManagementService studentManagementService) {
        this.studentManagementService = studentManagementService;
    }

    @PostMapping(value = EndpointConstants.ADD_STUDENT_RECORD, consumes = MediaType.APPLICATION_JSON_VALUE, produces
            = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addStudent(
            @RequestBody @NonNull AddUpdateStudentRequest addUpdateStudentRequest
    ) {

        AddUpdateStudentResponse addUpdateStudentResponse = studentManagementService
                .addStudent(addUpdateStudentRequest);

        if (addUpdateStudentResponse == null) {
            return getGetStudentResponseResponseEntity("Error adding a new student");
        }

        log.info("Successfully added Student={} {} with enrollment status={}",
                addUpdateStudentRequest.getFirstName(),
                addUpdateStudentRequest.getLastName(),
                addUpdateStudentResponse.getEnrollmentStatus().name());
        return new ResponseEntity(addUpdateStudentResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = EndpointConstants.GET_STUDENT_RECORD_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getStudentById(@PathVariable @NonNull Long studentId) {

        try {
            GetStudentResponse getStudentResponse = studentManagementService.getStudentById(studentId);
            if (getStudentResponse == null) {
                return getGetStudentResponseResponseEntity("Error finding student Id=" + studentId);
            }
            log.info("Successfully found student={} {} with id={}",
                    getStudentResponse.getFirstName(), getStudentResponse.getLastName(), studentId);
            return new ResponseEntity(getStudentResponse, HttpStatus.OK);
        } catch (Exception e) {
            return getGetStudentResponseResponseEntity(e.getMessage());
        }
    }

    @PutMapping(value = EndpointConstants.UPDATE_STUDENT_RECORD_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStudentById(
            @RequestBody @NonNull AddUpdateStudentRequest addUpdateStudentRequest,
            @PathVariable @NonNull Long studentId
    ) {

        try {
            AddUpdateStudentResponse addUpdateStudentResponse = studentManagementService
                    .updateStudentById(addUpdateStudentRequest, studentId);
            if (addUpdateStudentResponse == null) {
                return getGetStudentResponseResponseEntity("Error updating student Id=" + studentId);
            }
            log.info("Successfully updated student={} {} with id={}",
                    addUpdateStudentRequest.getFirstName(), addUpdateStudentRequest.getLastName(), studentId);
            return new ResponseEntity(addUpdateStudentResponse, HttpStatus.OK);
        } catch (Exception e) {
            return getGetStudentResponseResponseEntity(e.getMessage());
        }
    }

    @DeleteMapping(value = EndpointConstants.DELETE_STUDENT_RECORD_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteStudentById(@PathVariable @NonNull Long studentId) {

        try {
            DeleteStudentResponse deleteStudentResponse = studentManagementService
                    .deleteStudentById(studentId);
            if (deleteStudentResponse == null) {
                return getGetStudentResponseResponseEntity("Error deleting student Id=" + studentId);
            }
            log.info("Successfully deleted student={}", studentId);
            return new ResponseEntity(deleteStudentResponse, HttpStatus.OK);
        } catch (Exception e) {
            return getGetStudentResponseResponseEntity(e.getMessage());
        }
    }

    private ResponseEntity getGetStudentResponseResponseEntity(
            String errorMessage
    ) {
        final Error error = new Error(HttpStatus.BAD_REQUEST, errorMessage);
        log.error(error.getErrorMessage());
        return new ResponseEntity(error, error.getHttpStatus());
    }
}