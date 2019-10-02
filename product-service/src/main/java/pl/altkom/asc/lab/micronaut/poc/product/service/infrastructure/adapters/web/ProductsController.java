package pl.altkom.asc.lab.micronaut.poc.product.service.infrastructure.adapters.web;

import io.micronaut.http.annotation.Controller;
import io.reactivex.Maybe;
import io.reactivex.Single;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.ProductDto;
import pl.altkom.asc.lab.micronaut.poc.product.service.api.v1.ProductOperations;
import pl.altkom.asc.lab.micronaut.poc.product.service.domain.Products;

import java.util.List;

@Controller("/products")
public class ProductsController implements ProductOperations {

    private final Products products;

    public ProductsController(Products products) {
        this.products = products;
    }

    @Override
    public Single<List<ProductDto>> getAll() {
        return products.findAll().map(ProductsAssembler::map);
    }

    @Override
    public Maybe<ProductDto> get(String productCode) {
        return products.findOne(productCode).map(ProductsAssembler::map);
    }
}
