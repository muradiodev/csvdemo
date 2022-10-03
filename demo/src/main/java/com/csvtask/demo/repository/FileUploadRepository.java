package com.csvtask.demo.repository;

import com.csvtask.demo.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUploadRepository extends JpaRepository<Product, Long> {

    List<Product> findAll(Specification<Product> specification, Pageable pageable);

    Product getProductByCode(String code);

    void deleteAllBy();
}
