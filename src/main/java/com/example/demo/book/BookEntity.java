package com.example.demo.book;

import com.example.demo.order.OrderEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bariskantar
 */
@Getter
@Setter
@Entity(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

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
