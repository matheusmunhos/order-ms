package br.com.munhosdev.orderms.repository;

import br.com.munhosdev.orderms.controller.dto.OrderResponse;
import br.com.munhosdev.orderms.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Page<Order> findAllByCustomerId(Long customerId, PageRequest pageable);
}
