package com.example.demo.book;

import com.example.demo.customer.CustomerEntity;
import com.example.demo.shared.model.CaseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author bariskantar
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity,String> {
}
