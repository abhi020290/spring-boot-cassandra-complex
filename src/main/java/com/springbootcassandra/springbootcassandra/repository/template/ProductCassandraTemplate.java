package com.springbootcassandra.springbootcassandra.repository.template;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.springbootcassandra.springbootcassandra.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.EntityWriteResult;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCassandraTemplate {

    @Autowired
    CassandraTemplate cassandraTemplate;

    public Product save(Product product){
        InsertOptions insertOptions = InsertOptions.builder().consistencyLevel(ConsistencyLevel.ONE).build();
        EntityWriteResult<Product> insert = cassandraTemplate.insert(product, insertOptions);
        return insert.getEntity();
    }
}
