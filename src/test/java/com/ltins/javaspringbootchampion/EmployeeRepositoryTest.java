package com.ltins.javaspringbootchampion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.ltins.javaspringbootchampion.repository.*;
import com.ltins.javaspringbootchampion.entity.*;
import java.sql.Timestamp;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {
    private EmployeeRepository repo;

    @Autowired
    public EmployeeRepositoryTest(EmployeeRepository repo){
        this.repo = repo;
    }

    @Test
    public void testAddNew(){
        Employee employee = new Employee();
        employee.setName("Nikitka");
        employee.setHireDate(new Timestamp(5000));
        employee.setBuilding(null);
        employee.setSalary(300);
        employee.setJobTitle("Debilnik");

        Employee savedEmployee = repo.save(employee);

        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable<Employee> employees = repo.findAll();
        Assertions.assertThat(employees).hasSizeGreaterThan(0);

        for (Employee building : employees){
            System.out.println(building);
        }
    }
    @Test
    public void testUpdate(){
        Integer employeeId = 4;
        Optional<Employee> optionalEmployee = repo.findById(employeeId);
        Employee employee = optionalEmployee.get();
        employee.setName("Oleg");

        repo.save(employee);

        Employee updatedEmployee = repo.findById(employeeId).get();
        Assertions.assertThat(updatedEmployee.getName()).isEqualTo("Oleg");
    }
    @Test
    public void deleteByID(){
        Integer employeeId = 5;
        repo.deleteById(employeeId);

        Optional<Employee> optionalEmployee = repo.findById(employeeId);
        Assertions.assertThat(optionalEmployee).isNotPresent();
    }

}
