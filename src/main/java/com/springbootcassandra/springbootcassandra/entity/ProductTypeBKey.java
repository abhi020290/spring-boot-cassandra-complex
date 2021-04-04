package com.springbootcassandra.springbootcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeBKey implements Serializable {
    @PrimaryKeyColumn(value = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;
    @PrimaryKeyColumn(value = "sku_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String skuId;

}
