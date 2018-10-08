package myapp;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class EmployeeRepository {
    public Flux<Employee> findAllEmployees() {
        return null;
    }
}
