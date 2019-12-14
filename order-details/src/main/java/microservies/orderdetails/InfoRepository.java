package microservies.orderdetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface InfoRepository extends CrudRepository<Order, Integer> {
    Order findOrderByUserId(int userId);
}
