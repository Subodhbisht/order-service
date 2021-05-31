package sb.bisht.microservice.orderservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sb.bisht.microservice.orderservice.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
