package com.store.database.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.store.models.basic.Paging;
import com.store.database.basic.IPersistanceManager;
import com.store.database.exception.InvalidPersistantObjectException;
import com.store.database.exception.PersistanceInitException;
import com.store.database.exception.PersistanceOperationException;
import com.store.database.impl.util.HibernateUtil;
import com.store.models.basic.BasicStoreEntity;

public class HibernatePersistanceManager implements IPersistanceManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2503360784598406450L;
	// private LoggerUtil loggerUtil;
	private static final String PERCENT = "%";
	private HibernateUtil util;

	public HibernatePersistanceManager() throws PersistanceInitException {
		init();
	}

	@Override
	public void init() throws PersistanceInitException {

		util = HibernateUtil.getInstance();
	}

	@Override
	public void destroy() {

		util.destroy();
	}
	@Override
	public Object readFilteredByRange(Class type, Map<String, Object> equal,
			String betweenField, Date startTime, Date endTime)
					throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);

			if (equal != null) {
				Set<String> equalKeysSet = equal.keySet();
				for (String key : equalKeysSet) {
					Object val = equal.get(key);

					if (val instanceof String) {
						compareString(criteria, key, val);
					} else {
						criteria.add(Restrictions.eq(key, equal.get(key)));
					}

				}
			}
			criteria.add(Restrictions.between(betweenField, startTime, endTime));

			return criteria.list();

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}

	}

	private void compareString(Criteria criteria, String key, Object val) {
		String value = new String(PERCENT + val + PERCENT);
		criteria.add(Restrictions.like(key, value).ignoreCase());
	}

	@Override
	public Object readById(Class type, Serializable id)
			throws PersistanceOperationException {
		System.out.println("IN READ BY ID");

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Object output = currentSession.get(type, id);

			return output;

		} catch (HibernateException e) {
			// getLoggerUtil().logException("In READ BY ID ", e);
			throw new PersistanceOperationException(e);

		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public Object readByRange(Class type, Paging pageingObj)
			throws PersistanceOperationException {
		System.out.println("<<<readByRange() >>>");
		// getLoggerUtil().log("<<<readByRange() >>>");

		long before = System.currentTimeMillis();
		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Criteria criteria = currentSession.createCriteria(type);

			// setCriteriaOrder(criteria, type, pageingObj);
			if (pageingObj != null) {
				criteria.setFirstResult(pageingObj.getPageIndex()
						* pageingObj.getPageSize());
				criteria.setMaxResults(pageingObj.getPageSize());
			}
			Object output = criteria.list();

			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			// getLoggerUtil().log(System.currentTimeMillis() - before);
			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if (((List) output).size() == 0) {
				return null;
			} else {
				// System.out.println(((List)output).size());
				return output;
			}

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} /*
		 * catch (NoSuchFieldException e) { e.printStackTrace();
		 * //getLoggerUtil().logException(e); throw new
		 * SearchException("Invalid Sort Field", e); }
		 */finally {
			 util.endUnitOfWork(currentSession);
		 }
	}

	@Override
	public Object readByAttributeFilter(Class type, Paging pageingObj,
			Map<String, Object> filtersMap)
					throws PersistanceOperationException {

		System.out.println("<<<readByAttributeFilter()>>>");
		long before = System.currentTimeMillis();

		if (filtersMap == null || filtersMap.isEmpty()) {
			// getLoggerUtil().log("filter is null");
			return readByRange(type, pageingObj);
		}

		Session currentSession = null;

		try {
			// getLoggerUtil().log("filter is not null");
			currentSession = util.startUnitOfWork();

			Criteria criteria = currentSession.createCriteria(type);

			// setCriteriaOrder(criteria, type, pageingObj);

			Set<String> keysSet = filtersMap.keySet();
			for (String key : keysSet) {

				extractCriteriaData(filtersMap, criteria, key);
			}
			if (pageingObj != null) {
				criteria.setFirstResult(pageingObj.getPageIndex()
						* pageingObj.getPageSize());

				criteria.setMaxResults(pageingObj.getPageSize());
			}
			List<?> output = criteria.list();
			// getLoggerUtil().log("result size::: " + output.size());
			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			// getLoggerUtil().log(System.currentTimeMillis() - before);
			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			return (output.isEmpty() ? null : output);

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		}/*
		 * catch (NoSuchFieldException e) { e.printStackTrace();
		 * //getLoggerUtil().logException(e); throw new
		 * SearchException("Invalid Sort Field", e); }
		 */finally {
			 util.endUnitOfWork(currentSession);
		 }
	}

	// private void setCriteriaOrder(Criteria criteria, Class type,
	// Paging pageingObj) throws NoSuchFieldException {
	//
	// Order order = null;
	// if (pageingObj != null && pageingObj.getSortField() != null) {
	//
	// checkValidField(type, pageingObj.getSortField());
	// if (pageingObj.isAscending()) {
	// order = Order.asc(pageingObj.getSortField());
	// } else {
	// order = Order.desc(pageingObj.getSortField());
	// }
	//
	// } else {
	// // order = ApplicationResource.getDefaultOrderbyResourceClass(type);
	// }
	// if (order != null) {
	// criteria.addOrder(order);
	// }
	//
	// }

	// private void checkValidField(Class type, String sortField)
	// throws NoSuchFieldException {
	// Field field = ReflectionUtils.findField(type, sortField);
	// if (field == null) {
	// throw new NoSuchFieldException(sortField);
	// }
	// }

	private void extractCriteriaData(Map<String, Object> filtersMap,
			Criteria criteria, String key) {

		Object val = filtersMap.get(key);

		if (val instanceof String) {

			compareString(criteria, key, val);

		} else {
			criteria.add(Restrictions.eq(key, filtersMap.get(key)));
		}
	}

	private void extractNOCriteriaData(Map<String, Object> filtersMap,
			Criteria criteria, String key) {

		Object val = filtersMap.get(key);

		for (Object str : (List<Object>) val) {

			criteria.add(Restrictions.or(Restrictions.ne(key, str)));
		}
	}

	@Override
	public Object addObject(Object obj) throws PersistanceOperationException,
	InvalidPersistantObjectException {
		System.out.println("ADD OBJECT **************");

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			currentSession.save(obj);

			return obj;

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new InvalidPersistantObjectException(e);
		} finally {
			util.endUnitOfWork(currentSession);
			// getLoggerUtil().log("** SESSION COMMIT **");
		}

	}

	public Object readByColoumnValue(Class resource, String attributeName,
			Object value) throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Criteria c = currentSession.createCriteria(resource).add(
					Restrictions.eq(attributeName, value));

			// setCriteriaOrder(c, resource, null);
			Object output = c.list();

			return output;

		} catch (HibernateException e) {
			// getLoggerUtil().logException(e);
			e.printStackTrace();
			throw new PersistanceOperationException(e);
		} /*
		 * catch (NoSuchFieldException e) { e.printStackTrace();
		 * //getLoggerUtil().logException(e); throw new
		 * SearchException("Invalid Sort Field", e); }
		 */finally {
			 util.endUnitOfWork(currentSession);
		 }

	}

	@Override
	public Object readAll(Class resources) throws PersistanceOperationException {
		Session session = null;
		try {

			session = util.startUnitOfWork();
			Criteria c = session.createCriteria(resources);
			// setCriteriaOrder(c, resources, null);
			Object output = c.list();
			return output;

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PersistanceOperationException(e);
		} /*
		 * catch (NoSuchFieldException e) { e.printStackTrace();
		 * //getLoggerUtil().logException(e); throw new
		 * SearchException("Invalid Sort Field", e); }
		 */finally {
			 util.endUnitOfWork(session);
		 }
	}

	@Override
	public void updateObject(Object obj) throws PersistanceOperationException {
		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			currentSession.update(obj);

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public void deleteObject(Serializable id, Class resource)
			throws PersistanceOperationException,
			InvalidPersistantObjectException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			// getLoggerUtil().log("IDDDDD: " + id);

			Object deletedObject = currentSession.get(resource, id);

			if (deletedObject != null) {
				currentSession.delete(deletedObject);
			} else {
				throw new InvalidPersistantObjectException(null);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
			throw new PersistanceOperationException(e);

		} finally {

			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public Integer getTotalRowsCount(Class resource,
			Map<String, Object> filtersMap, Map<String, Object> noFiltersMap)
					throws PersistanceOperationException {
		System.out.println("IN get rows count");

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Criteria criteria = currentSession.createCriteria(resource);

			Set<String> keysSet = filtersMap.keySet();
			for (String key : keysSet) {
				extractCriteriaData(filtersMap, criteria, key);
			}

			Set<String> keysSetNo = noFiltersMap.keySet();
			for (String key : keysSetNo) {
				extractNOCriteriaData(noFiltersMap, criteria, key);
			}

			criteria.setProjection(Projections.rowCount());

			List xcc = criteria.list();
			return ((Long) xcc.get(0)).intValue();

		} catch (HibernateException e) {

			throw new PersistanceOperationException(e);

		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public Integer getTotalRowsCount(Class resource)
			throws PersistanceOperationException {
		System.out.println("IN get rows count");

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Criteria criteria = currentSession.createCriteria(resource);

			criteria.setProjection(Projections.rowCount());

			List xcc = criteria.list();
			return ((Long) xcc.get(0)).intValue();

		} catch (HibernateException e) {

			throw new PersistanceOperationException(e);

		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	// @Override
	public Integer getMaxId(Class resource)
			throws PersistanceOperationException {
		System.out.println("IN getMaxId()");

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();

			Criteria criteria = currentSession.createCriteria(resource);

			criteria.setProjection(Projections.max("id"));

			List xcc = criteria.list();
			Integer toRet = (Integer) xcc.get(0);
			if (toRet == null) {
				return new Integer(1);
			}
			return toRet;

		} catch (HibernateException e) {

			throw new PersistanceOperationException(e);

		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	public Object readByAttributeFilter(Class type, Paging pageingObj,
			Map<String, Object> equal, Map<String, Object> notEqual)
					throws PersistanceOperationException {
		long before = System.currentTimeMillis();

		if (equal == null || notEqual == null) {
			// getLoggerUtil().log("filter is null");
			return readByRange(type, pageingObj);
		}
		Session currentSession = null;

		try {
			// getLoggerUtil().log("filter is not null");
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);

			// setCriteriaOrder(criteria, type, pageingObj);
			Set<String> equalKeysSet = equal.keySet();
			for (String key : equalKeysSet) {
				// criteria.add(Restrictions.eq(key, equal.get(key)));

				Object val = equal.get(key);

				if (val instanceof String) {

					compareString(criteria, key, val);

				} else {
					criteria.add(Restrictions.eq(key, equal.get(key)));
				}

			}
			Set<String> notEqualEeysSet = notEqual.keySet();
			for (String key2 : notEqualEeysSet) {
				for (Object str : (List<Object>) notEqual.get(key2)) {
					criteria.add(Restrictions.or(Restrictions.ne(key2, str)));
				}

			}
			if (pageingObj != null) {
				criteria.setFirstResult(pageingObj.getPageIndex()
						* pageingObj.getPageSize());

				criteria.setMaxResults(pageingObj.getPageSize());
			}
			List output = criteria.list();
			// getLoggerUtil().log("result size::: " + output.size());
			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			// getLoggerUtil().log(System.currentTimeMillis() - before);
			// getLoggerUtil().log("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return (output.isEmpty() ? null : output);

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} /*
		 * catch (NoSuchFieldException e) { e.printStackTrace();
		 * //getLoggerUtil().logException(e); throw new
		 * SearchException("Invalid Sort Field", e); }
		 */finally {
			 util.endUnitOfWork(currentSession);
		 }
	}

	@Override
	public Long getItemsCountByAttributesFilter(Class type,
			Map<String, Object> equal, String betweenField, Long startTime,
			Long endTime) throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);

			Set<String> equalKeysSet = equal.keySet();
			for (String key : equalKeysSet) {
				Object val = equal.get(key);

				if (val instanceof String) {
					compareString(criteria, key, val);
				} else {
					criteria.add(Restrictions.eq(key, equal.get(key)));
				}

			}
			criteria.add(Restrictions.between(betweenField, startTime, endTime));

			criteria.setProjection(Projections.rowCount());

			List resultList = criteria.list();

			Long countFinal = (Long) criteria.uniqueResult();

			return countFinal;

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public Object readFilteredByRange(Class type, Map<String, Object> equal,
			String betweenField, Long startTime, Long endTime)
					throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);

			if (equal != null) {
				Set<String> equalKeysSet = equal.keySet();
				for (String key : equalKeysSet) {
					Object val = equal.get(key);

					if (val instanceof String) {
						compareString(criteria, key, val);
					} else {
						criteria.add(Restrictions.eq(key, equal.get(key)));
					}

				}
			}
			criteria.add(Restrictions.between(betweenField, startTime, endTime));

			return criteria.list();

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}

	}

	@Override
	public Object readFilteredByRange(Class type, Map<String, Object> equal,
			String alias, String origField, String betweenField,
			Date startTime, Date endTime) throws PersistanceOperationException {
		// TODO Auto-generated method stub
		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);

			if (equal != null) {
				Set<String> equalKeysSet = equal.keySet();
				for (String key : equalKeysSet) {
					Object val = equal.get(key);

					if (val instanceof String) {
						compareString(criteria, key, val);
					} else {
						criteria.add(Restrictions.eq(key, equal.get(key)));
					}

				}
			}
			criteria.createAlias(alias, origField);
			criteria.add(Restrictions.between(betweenField, startTime, endTime));

			return criteria.list();

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}

	}



	@Override
	public Object readAllWithFilter(Class resources, Map<String, Object> filters)
			throws PersistanceOperationException {
		Session session = null;
		Filter filter = null;
		try {

			session = util.startUnitOfWork();
			if (!filters.isEmpty()) {

				for (Map.Entry<String, Object> filterk : filters.entrySet()) {
					filter = session.enableFilter(filterk.getKey());
					for (Map.Entry<String, Object> filterParams : ((Map<String, Object>) filterk
							.getValue()).entrySet()) {
						((Filter) filter).setParameter(filterParams.getKey(),
								filterParams.getValue());
					}
				}

			}
			Criteria c = session.createCriteria(resources);
			// setCriteriaOrder(c, resources, null);
			Object output = c.list();
			return output;

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new PersistanceOperationException(e);
		} finally {
			if (!filters.isEmpty()) {

				for (Map.Entry<String, Object> filterk : filters.entrySet()) {
					session.disableFilter(filterk.getKey());
				}

			}
			// session.disableFilter(filterName);
			util.endUnitOfWork(session);

		}
	}

	@Override
	public List<BasicStoreEntity> findByColumnsOrred(Class type,
			List<String> searchFields, Object keyWord)
					throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);
			Disjunction or = Restrictions.disjunction();
			if (searchFields != null && !searchFields.isEmpty()) {

				for (String key : searchFields) {

					if (keyWord instanceof String) {
						String value = new String(PERCENT + keyWord + PERCENT);
						or.add(Restrictions.like(key, value).ignoreCase());
					} else {
						or.add(Restrictions.eq(key, keyWord));
					}

				}
			}
			criteria.add(or);
			return criteria.list();

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	@Override
	public List<BasicStoreEntity> findByColumnsOrred2(Class type,
			List<String> searchFields, String keyWord)
					throws PersistanceOperationException {

		Session currentSession = null;
		try {
			currentSession = util.startUnitOfWork();
			Criteria criteria = currentSession.createCriteria(type);
			Disjunction or = Restrictions.disjunction();
			if (searchFields != null && !searchFields.isEmpty()) {

				for (String key : searchFields) {

					Field fieldCurrent = fetchFieldByName(type, key) ;

					if (fieldCurrent.getType().isAssignableFrom(String.class)) {

						or.add(Restrictions.like(key, 
								new String(PERCENT + keyWord + PERCENT))
								.ignoreCase());

					} else if (fieldCurrent.getType().isAssignableFrom(Integer.class)) {
						try {
							Integer x = Integer.parseInt(keyWord);

							or.add(Restrictions.eq(key, x));

						} catch (NumberFormatException e) {
							System.out.println("not int value");
						}
					}

				}
			}
			criteria.add(or);
			return criteria.list();

		} catch (HibernateException e) {
			throw new PersistanceOperationException(e);
		} finally {
			util.endUnitOfWork(currentSession);
		}
	}

	private Field fetchFieldByName(Class type,String key)  {

		Field[] fields = type.getDeclaredFields();
		
		for (int i=0;i<fields.length;i++) {
			if (fields[i].getName().equals(key)) {
				return fields[i];
			}
		}
		return null;
		
	}

}
