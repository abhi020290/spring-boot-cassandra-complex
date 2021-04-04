package com.springbootcassandra.springbootcassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductLocation implements Serializable {

    private String city;
    private String zipCode;
    private String state;
}
