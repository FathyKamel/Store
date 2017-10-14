package com.store.service.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.store.database.basic.IPersistanceManager;
import com.store.database.exception.InvalidPersistantObjectException;
import com.store.database.exception.PersistanceInitException;
import com.store.database.exception.PersistanceOperationException;
import com.store.database.impl.HibernatePersistanceManager;
import com.store.models.basic.BasicStoreEntity;
import com.store.ws.service.exception.OperationFailureException;



public class BasicServiceManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1839314394008895545L;
	protected IPersistanceManager persistanceManager;

	public BasicServiceManager() {
		try {
			persistanceManager = new HibernatePersistanceManager();
		} catch (PersistanceInitException e) {
			e.printStackTrace();
		}
	}

	

	public BasicStoreEntity insertNewItem(BasicStoreEntity currentItem) throws OperationFailureException {
		try {
			BasicStoreEntity outBasicStoreEntity = 
					(BasicStoreEntity) persistanceManager.addObject(currentItem);

			return outBasicStoreEntity;

		} catch (PersistanceOperationException | InvalidPersistantObjectException e) {
			e.printStackTrace();
			throw new OperationFailureException(e.getMessage());
		}

	}

	
}
