package com.springbootcassandra.springbootcassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String id;
    private String skuId;
    private String description;
    private String productCategory;
    private long atp;
    private Date createdDate = new Date();
}
