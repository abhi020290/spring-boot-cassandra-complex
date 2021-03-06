package com.springbootcassandra.springbootcassandra.repository;

import com.springbootcassandra.springbootcassandra.entity.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
