package com.springbootcassandra.springbootcassandra.repository;

import com.springbootcassandra.springbootcassandra.entity.ProductAvailabilityEntity;
import com.springbootcassandra.springbootcassandra.entity.ProductTypeBKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAvailabilityRepository extends CassandraRepository<ProductAvailabilityEntity, ProductTypeBKey> {
}
