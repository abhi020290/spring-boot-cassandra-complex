package com.springbootcassandra.springbootcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Product_type_a")
public class ProductTypeA implements Serializable {
    @PrimaryKeyColumn(value = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;
    @PrimaryKeyColumn(value = "sku_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String skuId;
    @Column("description")
    private String description;
    @Column("product_category")
    private String productCategory;
    @Column("atp")
    private long atp;
    @Column("created_date")
    private Date createdDate = new Date();

}
