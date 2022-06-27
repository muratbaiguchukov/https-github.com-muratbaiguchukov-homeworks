package kg.itacademy.employee.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.itacademy.employee.model.EmployeeApiListResponse;
import kg.itacademy.employee.model.EmployeeApiModel;
import kg.itacademy.employee.model.EmployeeApiResponse;
import kg.itacademy.employee.service.EmployeeApiService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Key;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class EmployeeApiServiceImpl implements EmployeeApiService {

    private static final String HOST = "https://dummy.restapiexample.com";
    private static final String GET_ALL = HOST + "/api/v1/employees";
    private static final String GET_BY_ID = HOST + "/api/v1/employee/";
    private static final String CREATE = HOST + "/api/v1/create";
    private static final String PUT = HOST + "/api/v1/update/";
    private static final String DELETE = HOST + "/api/v1/delete/";


    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public EmployeeApiListResponse getAll() {

        return getAllForEntity();
    }

//    final String getByIdFullPath = GET_ALL;
//    EmployeeApiListResponse response = restTemplate.getForEntity(getByIdFullPath, EmployeeApiListResponse.class);
//    List<EmployeeApiModel> employees = response.getEmployees();
//        return

//    getAllForEntity();
//        return null;
//}

    public EmployeeApiResponse getById(Long id) {
        return getByIdForEntityWithParsing(id);
        //return getByIdForEntityWithoutParsing(id);
        //return getByIdForObject(id);
    }
//        final String getByIdFullPath = GET_BY_ID + id.toString();
//        ResponseEntity<EmployeeApiResponse> response = restTemplate.getForEntity(getByIdFullPath, EmployeeApiResponse.class);
//        if (response.getStatusCode().equals(HttpStatus.OK)) {
//            System.out.println(response.getBody());
//        }
//        return null;
//    }

//}

    @Override
    public EmployeeApiResponse create(EmployeeApiModel body) {
        return createWithoutHeaders(body);
    }

    private EmployeeApiResponse getByIdForEntityWithoutHeaders(EmployeeApiModel body) {
        return null;
    }

    private EmployeeApiResponse getByIdForEntityWithParsing(Long id) {
        // формируем ссылку
        final String getByIdFullPath = GET_BY_ID + id.toString();

        ResponseEntity<EmployeeApiResponse> response = restTemplate.getForEntity(getByIdFullPath, EmployeeApiResponse.class);
        while (response.getStatusCode().equals(HttpStatus.TOO_MANY_REQUESTS)) { // для решения задачи о том, что выйдет статус 429.если такая задача не стоит то можно удалить
            // или можно сделать так
            //while (response.getStatusCodeValue() == 429){
            // HttpsStatus.TOO_MANY_REQUESTS;
        }
        System.out.println(response);
        EmployeeApiResponse result = response.getBody();
        return result;
    }

    private EmployeeApiResponse getByIdForEntityWithoutParsing(Long id) {
        return null;
    }

    private EmployeeApiResponse getByIdForObject(Long id) {
        // Формируем ссылку
        final String getByIdFullPath = GET_BY_ID + id.toString();
        EmployeeApiResponse response = restTemplate.getForObject(getByIdFullPath, EmployeeApiResponse.class);
        System.out.println(response);
        EmployeeApiResponse result = response;
        return result;
    }

    private EmployeeApiListResponse getAllForEntity() {
        // Формируем ссылку
        final String getByIdFullPath = GET_ALL;
        ResponseEntity<EmployeeApiListResponse> response = restTemplate.getForEntity(getByIdFullPath, EmployeeApiListResponse.class);
        System.out.println(response);
        EmployeeApiListResponse result = response.getBody();
        return result;
    }

    private EmployeeApiResponse createWithoutHeaders(EmployeeApiModel body) {
        //RequestEntity<EmployeeApiModel> request = new RequestEntity<>(body);
        HttpEntity<EmployeeApiModel> request = new HttpEntity<>(body);
        ResponseEntity<EmployeeApiResponse> result = restTemplate.postForEntity(CREATE, request, EmployeeApiResponse.class);
        return result.getBody();
    }

    private EmployeeApiResponse createWithHeaders(EmployeeApiModel body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.ALL_VALUE);
        HttpEntity<EmployeeApiModel> request = new HttpEntity<>(body, headers);
        ResponseEntity<EmployeeApiResponse> result = restTemplate.postForEntity(CREATE, request, EmployeeApiResponse.class);
        return result.getBody();
    }

    private EmployeeApiResponse putWithHeaders(EmployeeApiModel body) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT_CHARSET, "asdfasdf");
        headers.add("Custom", "asdfasdf");
        HttpEntity<EmployeeApiModel> request = new HttpEntity<>(body, headers);
        ResponseEntity<EmployeeApiResponse> response = restTemplate.exchange(CREATE, HttpMethod.PUT, request, EmployeeApiResponse.class);
        return response.getBody();
    }


}




