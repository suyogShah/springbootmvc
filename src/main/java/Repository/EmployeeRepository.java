package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
