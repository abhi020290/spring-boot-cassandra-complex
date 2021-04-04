package com.springbootcassandra.springbootcassandra.resource;

import com.springbootcassandra.springbootcassandra.entity.ProductTypeA;
import com.springbootcassandra.springbootcassandra.repository.ProductTypeARepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productTypeA")
public class ProductTypeAResource {

    @Autowired
    private ProductTypeARepository productRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductTypeA> save(@RequestBody ProductTypeA paymentDetails) {
        try {
            ProductTypeA save = productRepository.save(paymentDetails);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductTypeA> fetchPaymentById(@PathVariable("id") String id,@PathVariable("sku") String sku) {
        Optional<ProductTypeA> paymentById = null;
        try {
            if (StringUtils.isNotBlank(String.valueOf(id)) || StringUtils.isNotEmpty(String.valueOf(id))) {
                paymentById = productRepository.findByIdAndSkuId(id,sku);
            }
            if (paymentById != null && paymentById.isPresent()) {
                return new ResponseEntity<>(paymentById.get(),HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
