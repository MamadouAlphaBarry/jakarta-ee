package it.cws.jakartaee.services;

import it.cws.jakartaee.entities.Product;
import it.cws.jakartaee.exceptions.ProductAllReadyExisteException;
import it.cws.jakartaee.exceptions.ProdutNotFoundException;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product saveProduct(Product product) throws ProductAllReadyExisteException;
    List<Map<String,Product>> listAllProduct();
    Product findProduct(String id) throws ProdutNotFoundException;
    String deleteProduct(String id) throws ProdutNotFoundException;
    List<Map<String,Product>> getProductByNameContain();
    long countTotalProduct();

}
