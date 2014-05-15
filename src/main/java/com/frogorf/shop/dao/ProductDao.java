/**
 * 
 */
package com.frogorf.shop.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.shop.domain.Product;

/** @author Tsurkin Alex
 * @version */
public interface ProductDao {

	public List<Product> findProducts();

	public List<Product> findProductsByProduct(Product Product);

	public org.springframework.data.domain.Page<Product> findProductsByProduct(Product product, Pageable pageable);

	public Product findProductById(int id);

	public Product findProductByProduct(Product product);

	public void saveProduct(Product product);

	public void deleteProduct(int id);
}
