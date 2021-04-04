package com.springbootcassandra.springbootcassandra.resource;

import com.springbootcassandra.springbootcassandra.entity.ProductAvailabilityEntity;
import com.springbootcassandra.springbootcassandra.entity.ProductLocationEntity;
import com.springbootcassandra.springbootcassandra.entity.ProductTypeBKey;
import com.springbootcassandra.springbootcassandra.model.ProductAvailability;
import com.springbootcassandra.springbootcassandra.model.ProductLocation;
import com.springbootcassandra.springbootcassandra.repository.ProductAvailabilityRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productAvailability")
public class ProductAvailabilityResource {

    @Autowired
    private ProductAvailabilityRepository productAvailabilityRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductAvailabilityEntity> save(@RequestBody ProductAvailability productAvailability) {
        try {
            ProductAvailabilityEntity productAvailabilityEntity = new ProductAvailabilityEntity();
            productAvailabilityEntity.setProductCategory(productAvailability.getProductCategory());
            productAvailabilityEntity.setAtp(productAvailability.getAtp());
            productAvailabilityEntity.setDescription(productAvailability.getDescription());
            productAvailabilityEntity.setProductTypeBKey(new ProductTypeBKey(productAvailability.getId(), productAvailability.getSkuId()));
            ProductLocation productLocation = productAvailability.getProductLocation();
            ProductLocationEntity productLocationEntity = new ProductLocationEntity(productLocation.getCity(),productLocation.getZipCode(),productLocation.getState());
            productAvailabilityEntity.setProductLocationEntity(productLocationEntity);

            ProductAvailabilityEntity save = productAvailabilityRepository.save(productAvailabilityEntity);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductAvailabilityEntity> fetchPaymentById(@PathVariable("id") String id,@PathVariable("sku") String sku) {
        Optional<ProductAvailabilityEntity> paymentById = null;
        try {
            if (StringUtils.isNotBlank(String.valueOf(id)) || StringUtils.isNotEmpty(String.valueOf(id))) {
                ProductTypeBKey productTypeBKey = new ProductTypeBKey(id,sku);
                paymentById = productAvailabilityRepository.findById(productTypeBKey);
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
