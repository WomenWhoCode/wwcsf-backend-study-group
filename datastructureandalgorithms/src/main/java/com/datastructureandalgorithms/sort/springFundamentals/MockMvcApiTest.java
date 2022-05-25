package test;

//import org.junit.Test;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.studentmanagement.controller.EndpointConstants;
//import com.studentmanagement.controller.StudentManagementController;
//import com.studentmanagement.controller.dto.AddUpdateStudentRequest;
//import com.studentmanagement.service.StudentManagementService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@WebMvcTest(StudentManagementController.class)
public class MockMvcApiTest {

//    private static final String BASE_URL = "http://localhost:8080/studentmanagementservice/";
//    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//
//    @Mock
//    private StudentManagementService studentManagementService;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        StudentManagementController studentManagementController = new StudentManagementController(
//                studentManagementService);
//        mockMvc = MockMvcBuilders.standaloneSetup(studentManagementController).build();
//    }
//
//    @Test
//    public void testAddStudent() throws Exception {
//        AddUpdateStudentRequest addUpdateStudentRequest = buildAddUpdateStudentRequest();
//        // expected
//        MockHttpServletRequestBuilder httpEntity = MockMvcRequestBuilders
//                .post(BASE_URL + EndpointConstants.ADD_STUDENT_RECORD)
//                .content(OBJECT_MAPPER.writeValueAsString(addUpdateStudentRequest))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult response = mockMvc.perform(httpEntity).andReturn();
//        System.out.println(response.getResponse().getContentAsString());
//        // actual
//        //compare
//    }
}
