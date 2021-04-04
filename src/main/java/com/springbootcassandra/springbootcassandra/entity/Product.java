package com.springbootcassandra.springbootcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("product")
public class Product implements Serializable {

    @PrimaryKey(value = "id")
    private UUID id;
    @Column("description")
    private String description;
    @Column("sku_id")
    private String skuId;
    @Column("product_category")
    private String productCategory;
    @Column("atp")
    private long atp;
    @Column("created_date")
    private Date createdDate = new Date();

}
