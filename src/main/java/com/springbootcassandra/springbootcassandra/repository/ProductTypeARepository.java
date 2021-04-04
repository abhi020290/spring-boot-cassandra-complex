package com.springbootcassandra.springbootcassandra.repository;

import com.springbootcassandra.springbootcassandra.entity.ProductTypeA;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ProductTypeARepository extends CassandraRepository<ProductTypeA, Serializable> {

    Optional<ProductTypeA> findByIdAndSkuId(String id, String skuId);
}
