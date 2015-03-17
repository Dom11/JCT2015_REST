package com.bluesky.rest.data.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;


/**
 * Generic data access object, implementing most common CRUD functionalities.
 * 
 * @param <T> type to be generified.
 * @param <I> key type to be generified.
 */
public class GenericDao<T, I extends Serializable>  {

	/**
	 * The <code>EntityManager</code> used by this <code>AbstractDaoImpl</code>.
	 * 
	 */
	@PersistenceContext(unitName = "webapp")
	protected EntityManager entityManager;


	/**
	 * The type of the objects to be persisted with the created instance.
	 */
	private final Class<? extends T> clazz;
	
	// ---- Constructors

	/**
	 * Creates a new <code>GenericDaoImpl</code> instance for objects of the
	 * given type.
	 * 
	 * @param clazz
	 *            the type of the objects to be persisted with the created
	 *            instance.
	 */
	protected GenericDao(Class<? extends T> clazz) {
		this.clazz = clazz;
	}

	// ---- Methods

	/**
	 * Returns the Hibernate <code>Session</code> instance backing the current
	 * <code>EntityManager</code>.
	 * 
	 * @return the Hibernate <code>Session</code> instance.
	 * @throws DaoException
	 *             generic data access exception.
	 */
	protected Session getSession() throws DaoException {

		try {
			final Object delegate = entityManager.getDelegate();
			if (delegate instanceof Session) {
				return (Session) delegate;
			}
			if (delegate instanceof EntityManagerImpl) {
				return ((EntityManagerImpl) delegate).getSession();
			}
			throw new DaoException(new IllegalStateException(
					"Hibernate EntityManager not portable"));
		} catch (IllegalStateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find entity based on unique id.
	 * 
	 * @param id
	 *            an unique entity bean primary key attribute.
	 * @throws DaoException
	 */
	public T get(I id) throws DaoException {

		try {
			return entityManager.find(clazz, id);
		} catch (Exception e) {
			System.out.println("GenericDaoImpl:get : error fetching records");
			throw new DaoException(
					"GenericDaoImpl:get : error fetching records", e);
		}
	}

	/**
	 * Remove entity based on unique id.
	 * 
	 * @param id
	 *            a unique entity bean primary key attribute.
	 * @throws DaoException
	 */
	public void delete(I id) throws DaoException {
		try {
			entityManager.remove(get(id));
		} catch (Exception e) {
			System.out.println("GenericDaoImpl:delete : error removing record");
			throw new DaoException(
					"GenericDaoImpl:delete : error removing record", e);
		}
	}

	/**
	 * Persist single entity instance.
	 * 
	 * @param t
	 *            the entity bean reference.
	 * @throws DaoException
	 *             with the following possible error codes:
	 */
	public T save(T t) throws DaoException {
		try {
			return entityManager.merge(t);
		} catch (OptimisticLockException e) {
			System.out.println("Record was changed by another user");
			throw new DaoException(
					"Record was changed by another user", e);
		} catch (Exception e) {
			System.out.println("GenericDaoImpl:save : error persisting record");
			throw new DaoException(
					"GenericDaoImpl:save : error persisting record", e);
		}
	}
	
	/**
	 * synchronize persistence context with database
	 * 
	 * 
	 * @throws DaoException
	 *             with the following possible error codes:
	 */
	public void flush() throws DaoException {
		try {
			entityManager.flush();
		} catch (Exception e) {
			System.out.println("GenericDaoImpl:flush : error flushing state");
			throw new DaoException(
					"GenericDaoImpl:flush : error flushing state", e);
		}
	}

	/**
	 * Returns all persistent instances of the associated type in one
	 * <code>List</code>. Note: Even though you get a <code>List</code> back,
	 * there is no guarantee that the values are in any special order!
	 * 
	 * @throws DaoException
	 * @return all persistent instances of the associated type in one
	 *         <code>List</code>.
	 * @see GenericDao#findAll
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws DaoException {
		final Criteria crit = getSession().createCriteria(clazz);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		try {
			return crit.list();	
			
		} catch (Exception e) {
			System.out.println("GenericDaoImpl:findAll : error retrieving records");
			throw new DaoException(
					"GenericDaoImpl:findAll : error retieving records", e);
		}
	}

	/**
	 * Re-read the state of the object with database.
	 * 
	 * @param id
	 *            a the entity bean reference.
	 * @throws DaoException
	 */
	public void refresh(T t) throws DaoException {
		try {
			entityManager.refresh(t);
		} catch (Exception e) {
			System.out.println(
					"GenericDaoImpl:refresh : error refreshing state of object");
			throw new DaoException(
					"GenericDaoImpl:refresh : error refreshing state of object",
					e);
		}
	}

}
