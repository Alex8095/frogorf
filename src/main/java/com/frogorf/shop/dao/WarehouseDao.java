/**
 * 
 */
package com.frogorf.shop.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.frogorf.shop.domain.Warehouse;

/** @author Tsurkin Alex
 * @version */
public interface WarehouseDao {

	public List<Warehouse> findWarehouses();

	public List<Warehouse> findWarehousesByWarehouse(Warehouse warehouse);

	public org.springframework.data.domain.Page<Warehouse> findWarehousesByWarehouse(Warehouse warehouse, Pageable pageable);

	public Warehouse findWarehouseById(int id);

	public Warehouse findWarehouseByWarehouse(Warehouse warehouse);

	public void saveWarehouse(Warehouse warehouse);

	public void deleteWarehouse(int id);
}
