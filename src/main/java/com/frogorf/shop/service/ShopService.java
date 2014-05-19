/**
 * 
 */
package com.frogorf.shop.service;

import com.frogorf.shop.dao.OrderDao;
import com.frogorf.shop.dao.OrderHistoryDao;
import com.frogorf.shop.dao.ProductDao;
import com.frogorf.shop.dao.WarehouseDao;


/** @author Tsurkin Alex
 * @version */
public interface ShopService extends ProductDao, WarehouseDao, OrderDao, OrderHistoryDao  {
}
