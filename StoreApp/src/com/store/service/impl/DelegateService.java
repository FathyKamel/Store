package com.store.service.impl;

import java.util.List;

import com.store.database.exception.PersistanceOperationException;
import com.store.models.basic.BasicStoreEntity;
import com.store.models.impl.Customer;
import com.store.models.impl.Delegate;
import com.store.service.basic.BasicServiceManager;

public class DelegateService extends BasicServiceManager {
	
	public List<BasicStoreEntity> allDelegates()
			throws PersistanceOperationException {
		List<BasicStoreEntity> lista = (List<BasicStoreEntity>) persistanceManager
				.readAll(Delegate.class);
		return lista;
	}

}
