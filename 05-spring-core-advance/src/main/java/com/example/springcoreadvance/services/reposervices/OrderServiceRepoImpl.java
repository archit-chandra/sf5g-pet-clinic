package com.example.springcoreadvance.services.reposervices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.springcoreadvance.domain.Order;
import com.example.springcoreadvance.repositories.OrderRepository;
import com.example.springcoreadvance.services.OrderService;

@Service
@Profile({"springdatajpa", "jpadao"})
public class OrderServiceRepoImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<?> listAll() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add); //fun with Java 8
        return orders;
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return orderRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
