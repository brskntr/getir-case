package com.example.demo.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author bariskantar
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {
    List<OrderEntity> findByCreateDateBetween(ZonedDateTime startDate,ZonedDateTime endDate);
}
