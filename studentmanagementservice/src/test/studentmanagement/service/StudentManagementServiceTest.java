package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.studentmanagement.controller.dto.AddUpdateStudentRequest;
import com.studentmanagement.controller.dto.AddUpdateStudentResponse;
import com.studentmanagement.controller.dto.Degree;
import com.studentmanagement.controller.dto.DeleteStudentResponse;
import com.studentmanagement.controller.dto.GetStudentResponse;
import com.studentmanagement.controller.dto.Status;
import com.studentmanagement.data.model.Student;
import com.studentmanagement.data.repository.StudentManagementRepository;
import com.studentmanagement.service.StudentManagementService;
import java.sql.Date;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentManagementServiceTest {

    private static final Long STUDENT_ID = 0L;
    private final ModelMapper modelMapper = new ModelMapper();

    private final StudentManagementRepository studentManagementRepository = Mockito
            .mock(StudentManagementRepository.class);

    private final StudentManagementService studentManagementService = new StudentManagementService(
            studentManagementRepository);

    @Test
    public void testAddStudent() {
        AddUpdateStudentRequest expectedAddStudentRequest = buildAddUpdateStudentRequest();
        Student expectedStudent = modelMapper.map(expectedAddStudentRequest, Student.class);
        AddUpdateStudentResponse expectedAddStudentResponse = new AddUpdateStudentResponse(
                STUDENT_ID, Status.ENROLLED);
        when(studentManagementRepository.save(expectedStudent)).thenReturn(expectedStudent);

        AddUpdateStudentResponse actualAddStudentResponse = studentManagementService
                .addStudent(expectedAddStudentRequest);

        verify(studentManagementRepository).save(any());
        assertEquals(expectedAddStudentResponse.getStudentId(),
                actualAddStudentResponse.getStudentId());
        assertEquals(expectedAddStudentResponse.getEnrollmentStatus(),
                actualAddStudentResponse.getEnrollmentStatus());
    }

    @Test
    public void testGetStudent() {
        final GetStudentResponse expectedGetStudentResponse = buildGetStudentResponse();
        Student expectedStudent = modelMapper.map(expectedGetStudentResponse, Student.class);
        when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));

        GetStudentResponse actualGetStudentResponse = studentManagementService
                .getStudentById(STUDENT_ID);

        verify(studentManagementRepository).findById(any());
        assertEquals(expectedGetStudentResponse.getStudentId(),
                actualGetStudentResponse.getStudentId());
        assertEquals(expectedGetStudentResponse.getFirstName(),
                actualGetStudentResponse.getFirstName());
        assertEquals(expectedGetStudentResponse.getLastName(),
                actualGetStudentResponse.getLastName());
        assertEquals(expectedGetStudentResponse.getDateOfBirth(),
                actualGetStudentResponse.getDateOfBirth());
        assertEquals(expectedGetStudentResponse.getYearOfEnrollment(),
                actualGetStudentResponse.getYearOfEnrollment());
        assertEquals(expectedGetStudentResponse.getDegree(),
                actualGetStudentResponse.getDegree());
        assertEquals(expectedGetStudentResponse.getAdvisor(),
                actualGetStudentResponse.getAdvisor());
        assertEquals(expectedGetStudentResponse.getEnrollmentStatus(),
                actualGetStudentResponse.getEnrollmentStatus());
    }

    @Test
    public void testUpdateStudent() {
        AddUpdateStudentRequest expectedUpdateStudentRequest = buildAddUpdateStudentRequest();
        expectedUpdateStudentRequest.setEnrollmentStatus(Status.WITHDRAWN);  // Status updated
        Student expectedStudent = modelMapper.map(expectedUpdateStudentRequest, Student.class);
        when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));
        when(studentManagementRepository.save(expectedStudent)).thenReturn(expectedStudent);

        GetStudentResponse actualUpdateStudentResponse = studentManagementService
                .getStudentById(STUDENT_ID);

        verify(studentManagementRepository).findById(any());
        assertEquals(expectedUpdateStudentRequest.getFirstName(),
                actualUpdateStudentResponse.getFirstName());
        assertEquals(expectedUpdateStudentRequest.getLastName(),
                actualUpdateStudentResponse.getLastName());
        assertEquals(expectedUpdateStudentRequest.getDateOfBirth(),
                actualUpdateStudentResponse.getDateOfBirth());
        assertEquals(expectedUpdateStudentRequest.getYearOfEnrollment(),
                actualUpdateStudentResponse.getYearOfEnrollment());
        assertEquals(expectedUpdateStudentRequest.getDegree(),
                actualUpdateStudentResponse.getDegree());
        assertEquals(expectedUpdateStudentRequest.getAdvisor(),
                actualUpdateStudentResponse.getAdvisor());
        assertEquals(actualUpdateStudentResponse.getEnrollmentStatus(), Status.WITHDRAWN);
        assertEquals(expectedUpdateStudentRequest.getEnrollmentStatus(),
                actualUpdateStudentResponse.getEnrollmentStatus());
    }

    @Test
    public void testDeleteStudent() {
        AddUpdateStudentRequest expectedDeleteStudentRequest = buildAddUpdateStudentRequest();
        Student expectedStudent = modelMapper.map(expectedDeleteStudentRequest, Student.class);
        when(studentManagementRepository.findById(STUDENT_ID)).thenReturn(Optional.of(expectedStudent));

        DeleteStudentResponse actualDeleteStudentResponse = studentManagementService
                .deleteStudentById(STUDENT_ID);

        verify(studentManagementRepository).findById(any());
        assertEquals(STUDENT_ID, actualDeleteStudentResponse.getStudentId());
        assertEquals(Status.DELETED, actualDeleteStudentResponse.getDeletionStatus());
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
