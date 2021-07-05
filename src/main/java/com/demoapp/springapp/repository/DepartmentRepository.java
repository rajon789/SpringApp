package com.demoapp.springapp.repository;

import com.demoapp.springapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

    //public Department findByDepartmentName(String departmentName);
    //public Department findAllByDepartmentNameIgnoreCase(String departmentName);

    public List<Department> findAllByDepartmentNameIgnoreCase(String departmentName);
}
