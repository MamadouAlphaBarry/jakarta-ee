package it.cws.jakartaee.services;

import it.cws.jakartaee.entities.Product;
import it.cws.jakartaee.exceptions.ProductAllReadyExisteException;
import it.cws.jakartaee.exceptions.ProdutNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
     Map<String,Product> productMap= new HashMap<String,Product>();
    @Override
    public Product saveProduct(Product product) throws ProductAllReadyExisteException {
        if (productMap.containsKey(product.getId())){
            throw new ProductAllReadyExisteException("le Product existe deja");
        }
        return productMap.put(product.getId(),product);
    }

    @Override
    public List<Map<String,Product>> listAllProduct() {
       if (productMap.isEmpty()){
           return List.of();
       }
        return List.of(productMap);
    }

    @Override
    public Product findProduct(String id) throws ProdutNotFoundException {
        Product p= productMap.get(id);
        if (p==null){
            throw  new ProdutNotFoundException("Le produit n'existe pas.");
        }
        return p;
    }

    @Override
    public String deleteProduct(String id) throws ProdutNotFoundException{
        Product product = productMap.get(id);
        if (product== null){
            throw new ProdutNotFoundException("Le produit exite deja!");
        }
        return "Le product avec l'id"+id+"a etè supprimer";
    }

    @Override
    public List<Map<String,Product>>  getProductByNameContain() {
        return null;
    }

    @Override
    public long countTotalProduct() {
        long count = productMap.values().stream().count();
        return count;
    }
}
