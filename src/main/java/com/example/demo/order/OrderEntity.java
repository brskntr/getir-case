package com.example.demo.order;

import com.example.demo.book.BookEntity;
import com.example.demo.customer.CustomerEntity;
import com.example.demo.shared.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author bariskantar
 */
@Getter
@Setter
@Entity(name = "book_order")
public class OrderEntity extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity book;

    @Column(name = "count")
    private int count;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
