package com.springbootcassandra.springbootcassandra.resource;

import com.springbootcassandra.springbootcassandra.entity.ProductTypeB;
import com.springbootcassandra.springbootcassandra.entity.ProductTypeBKey;
import com.springbootcassandra.springbootcassandra.model.ProductRequest;
import com.springbootcassandra.springbootcassandra.repository.ProductTypeBRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productTypeB")
public class ProductTypeBResource {

    @Autowired
    private ProductTypeBRepository productRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductTypeB> save(@RequestBody ProductRequest productRequest) {
        try {
            ProductTypeB productTypeB = new ProductTypeB();
            productTypeB.setProductCategory(productRequest.getProductCategory());
            productTypeB.setAtp(productRequest.getAtp());
            productTypeB.setDescription(productRequest.getDescription());
            productTypeB.setProductTypeBKey(new ProductTypeBKey(productRequest.getId(),productRequest.getSkuId()));
            ProductTypeB save = productRepository.save(productTypeB);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductTypeB> fetchPaymentById(@PathVariable("id") String id,@PathVariable("sku") String sku) {
        Optional<ProductTypeB> paymentById = null;
        try {
            if (StringUtils.isNotBlank(String.valueOf(id)) || StringUtils.isNotEmpty(String.valueOf(id))) {
                ProductTypeBKey productTypeBKey = new ProductTypeBKey(id,sku);
                paymentById = productRepository.findById(productTypeBKey);
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
