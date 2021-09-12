package com.example.demo.shared.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @author bariskantar
 */

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;

    @Version
    @Column(name = "version")
    private int version;

    @CreationTimestamp
    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private ZonedDateTime updateDate;
}
