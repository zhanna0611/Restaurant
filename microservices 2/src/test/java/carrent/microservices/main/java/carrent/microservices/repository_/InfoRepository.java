package carrent.microservices.repository_;

import carrent.microservices.Information;
import org.springframework.data.repository.CrudRepository;

public interface InfoRepository extends CrudRepository<Information, Integer> {
}

