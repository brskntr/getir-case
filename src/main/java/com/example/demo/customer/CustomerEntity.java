package com.example.demo.customer;

import com.example.demo.order.OrderEntity;
import com.example.demo.shared.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bariskantar
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "customer")
public class CustomerEntity extends BaseEntity implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "fullname")
    private String fullname;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<OrderEntity> orders = new ArrayList<>();
}
