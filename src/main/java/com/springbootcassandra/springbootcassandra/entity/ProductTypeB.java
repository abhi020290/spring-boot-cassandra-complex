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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Product_type_b")
public class ProductTypeB implements Serializable {

    @PrimaryKey
    private ProductTypeBKey productTypeBKey;
    @Column("description")
    private String description;
    @Column("product_category")
    private String productCategory;
    @Column("atp")
    private long atp;
    @Column("created_date")
    private Date createdDate = new Date();

}
