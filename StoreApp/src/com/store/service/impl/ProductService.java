package com.store.service.impl;

import java.util.List;

import com.store.database.exception.PersistanceOperationException;
import com.store.models.basic.BasicStoreEntity;
import com.store.models.impl.Customer;
import com.store.models.impl.Product;
import com.store.service.basic.BasicServiceManager;


public class ProductService extends BasicServiceManager {

	public List<BasicStoreEntity> allProducts()
			throws PersistanceOperationException {
		List<BasicStoreEntity> lista = (List<BasicStoreEntity>) persistanceManager
				.readAll(Product.class);
		return lista;
	}
    
}
