package com.springbootcassandra.springbootcassandra.resource;

import com.springbootcassandra.springbootcassandra.entity.Product;
import com.springbootcassandra.springbootcassandra.repository.template.ProductCassandraTemplate;
import com.springbootcassandra.springbootcassandra.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCassandraTemplate productCassandraTemplate;

    @PostMapping(value = "/save")
    public ResponseEntity<Product> save(@RequestBody Product paymentDetails) {
        try {
            Product save = productService.saveOrUpdate(paymentDetails);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> fetchPaymentById(@PathVariable("id") String id) {
        Optional<Product> paymentById = null;
        try {
            if (StringUtils.isNotBlank(String.valueOf(id)) || StringUtils.isNotEmpty(String.valueOf(id))) {
                paymentById = Optional.ofNullable(productService.findById(UUID.fromString(String.valueOf(id))));
            }
            if (paymentById != null && paymentById.isPresent()) {
                return paymentById.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = "/save/template")
    public ResponseEntity<Product> saveTemplate(@RequestBody Product paymentDetails) {
        try {
            Product save = productCassandraTemplate.save(paymentDetails);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
