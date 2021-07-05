package com.demoapp.springapp.service;

import com.demoapp.springapp.entity.Department;
import com.demoapp.springapp.errorHandling.DepartmentNotFoundException;
import com.demoapp.springapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /*@Autowired
    private DepartmentRepository departmentRepository;
    */
    @Override
    public Department saveDepartment(Department department) {
        System.out.println(department.getDepartmentId());
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDbInfo = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDbInfo.setDepartmentName(department.getDepartmentName());
        }

       if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
           departmentDbInfo.setDepartmentCode(department.getDepartmentCode());
       }

       if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
           departmentDbInfo.setDepartmentAddress(department.getDepartmentAddress());
       }

        return departmentRepository.save(departmentDbInfo);
    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findAllByDepartmentNameIgnoreCase(departmentName);
    }
}