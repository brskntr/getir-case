package com.example.demo.book;

import com.example.demo.order.OrderEntity;
import com.example.demo.shared.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bariskantar
 */
@Getter
@Setter
@Entity(name = "book")
public class BookEntity extends BaseEntity implements Serializable {

    @Column(name = "author")
    private String author;

    @Column(name = "name")
    private String name;

    @Column(name = "stock_count")
    private int stockCount;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<OrderEntity> orders = new ArrayList<>();

}
