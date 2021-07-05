package com.demoapp.springapp.service;

import com.demoapp.springapp.entity.Department;
import com.demoapp.springapp.errorHandling.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    List<Department> fetchDepartmentByName(String departmentName);
}
