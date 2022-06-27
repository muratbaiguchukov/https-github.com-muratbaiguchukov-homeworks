package kg.itacademy.employee.service;

import kg.itacademy.employee.model.EmployeeApiListResponse;
import kg.itacademy.employee.model.EmployeeApiModel;
import kg.itacademy.employee.model.EmployeeApiResponse;

import java.util.List;

public interface EmployeeApiService {

    EmployeeApiListResponse getAll();

    EmployeeApiResponse getById(Long id);

    EmployeeApiResponse create(EmployeeApiModel body);
}

