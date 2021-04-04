package com.springbootcassandra.springbootcassandra.repository;

import com.springbootcassandra.springbootcassandra.entity.ProductTypeB;
import com.springbootcassandra.springbootcassandra.entity.ProductTypeBKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeBRepository extends CassandraRepository<ProductTypeB, ProductTypeBKey> {

}
