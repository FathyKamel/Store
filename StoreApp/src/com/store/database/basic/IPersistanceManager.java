package com.store.database.basic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.store.models.basic.Paging;
import com.store.database.exception.InvalidPersistantObjectException;
import com.store.database.exception.PersistanceInitException;
import com.store.database.exception.PersistanceOperationException;
import com.store.models.basic.BasicStoreEntity;

public interface IPersistanceManager extends Serializable{

	public void init() throws PersistanceInitException ;
	public void destroy();

	public Object readById(Class type, Serializable id) throws PersistanceOperationException;

	public Object readByRange(Class type, Paging pageingObj)
			throws PersistanceOperationException ;

	public Object readByAttributeFilter(Class type, Paging pageingObj,
			Map<String, Object> filtersMap)
					throws PersistanceOperationException;

	public Object readByColoumnValue(Class resource, 
			String attributeName,
			Object value) throws PersistanceOperationException;

	public Object addObject(Object obj)
			throws PersistanceOperationException,
			InvalidPersistantObjectException;

	public Object readAll (Class resources) throws PersistanceOperationException;

	public void updateObject(Object obj) throws PersistanceOperationException;

	public void deleteObject(Serializable id, Class resource)
			throws PersistanceOperationException, 
			InvalidPersistantObjectException;

	public Long getItemsCountByAttributesFilter(Class type,
			Map<String, Object> equal,String betweenField,
			Long startTime,Long endTime) 
					throws PersistanceOperationException ;

	public Integer getTotalRowsCount(Class resource, 
			Map<String, Object> filtersMap, Map<String, Object> noFiltersMap)
					throws PersistanceOperationException;

	Integer getTotalRowsCount(Class resource)
			throws PersistanceOperationException;

	Object readFilteredByRange(Class type, Map<String, Object> equal,
			String betweenField, Long startTime, Long endTime)
					throws PersistanceOperationException;

	Object readFilteredByRange(Class type, Map<String, Object> equal,
			String alias, String orgiginalField,
			String betweenField, Date startTime, Date endTime)
					throws PersistanceOperationException;

	public Object readFilteredByRange(Class type, 
			Map<String, Object> equal,String betweenField,
			Date startTime,Date endTime) throws PersistanceOperationException ;
	Object readAllWithFilter(Class resources,
			Map<String, Object> filters)
					throws PersistanceOperationException;

	public List<BasicStoreEntity> findByColumnsOrred(Class type,
			List<String> searchFields, 
			Object keyWord)
					throws PersistanceOperationException;
	List<BasicStoreEntity> findByColumnsOrred2(Class type, List<String> searchFields, String keyWord)
			throws PersistanceOperationException;
	

}
