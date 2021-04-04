package com.springbootcassandra.springbootcassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;

@UserDefinedType("product_location")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductLocationEntity implements Serializable {

    @Column("city")
    private String city;
    @Column("zipCode")
    private String zipCode;
    @Column("state")
    private String state;

}
