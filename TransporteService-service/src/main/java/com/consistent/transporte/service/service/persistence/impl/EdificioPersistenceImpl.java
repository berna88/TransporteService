/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.consistent.transporte.service.service.persistence.impl;

import com.consistent.transporte.service.exception.NoSuchEdificioException;
import com.consistent.transporte.service.model.Edificio;
import com.consistent.transporte.service.model.impl.EdificioImpl;
import com.consistent.transporte.service.model.impl.EdificioModelImpl;
import com.consistent.transporte.service.service.persistence.EdificioPersistence;
import com.consistent.transporte.service.service.persistence.impl.constants.EscuelaPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the edificio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EdificioPersistence.class)
@ProviderType
public class EdificioPersistenceImpl
	extends BasePersistenceImpl<Edificio> implements EdificioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EdificioUtil</code> to access the edificio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EdificioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EdificioPersistenceImpl() {
		setModelClass(Edificio.class);

		setModelImplClass(EdificioImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the edificio in the entity cache if it is enabled.
	 *
	 * @param edificio the edificio
	 */
	@Override
	public void cacheResult(Edificio edificio) {
		entityCache.putResult(
			entityCacheEnabled, EdificioImpl.class, edificio.getPrimaryKey(),
			edificio);

		edificio.resetOriginalValues();
	}

	/**
	 * Caches the edificios in the entity cache if it is enabled.
	 *
	 * @param edificios the edificios
	 */
	@Override
	public void cacheResult(List<Edificio> edificios) {
		for (Edificio edificio : edificios) {
			if (entityCache.getResult(
					entityCacheEnabled, EdificioImpl.class,
					edificio.getPrimaryKey()) == null) {

				cacheResult(edificio);
			}
			else {
				edificio.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all edificios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EdificioImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the edificio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Edificio edificio) {
		entityCache.removeResult(
			entityCacheEnabled, EdificioImpl.class, edificio.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Edificio> edificios) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Edificio edificio : edificios) {
			entityCache.removeResult(
				entityCacheEnabled, EdificioImpl.class,
				edificio.getPrimaryKey());
		}
	}

	/**
	 * Creates a new edificio with the primary key. Does not add the edificio to the database.
	 *
	 * @param edificioId the primary key for the new edificio
	 * @return the new edificio
	 */
	@Override
	public Edificio create(int edificioId) {
		Edificio edificio = new EdificioImpl();

		edificio.setNew(true);
		edificio.setPrimaryKey(edificioId);

		return edificio;
	}

	/**
	 * Removes the edificio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio that was removed
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	@Override
	public Edificio remove(int edificioId) throws NoSuchEdificioException {
		return remove((Serializable)edificioId);
	}

	/**
	 * Removes the edificio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the edificio
	 * @return the edificio that was removed
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	@Override
	public Edificio remove(Serializable primaryKey)
		throws NoSuchEdificioException {

		Session session = null;

		try {
			session = openSession();

			Edificio edificio = (Edificio)session.get(
				EdificioImpl.class, primaryKey);

			if (edificio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEdificioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(edificio);
		}
		catch (NoSuchEdificioException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Edificio removeImpl(Edificio edificio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(edificio)) {
				edificio = (Edificio)session.get(
					EdificioImpl.class, edificio.getPrimaryKeyObj());
			}

			if (edificio != null) {
				session.delete(edificio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (edificio != null) {
			clearCache(edificio);
		}

		return edificio;
	}

	@Override
	public Edificio updateImpl(Edificio edificio) {
		boolean isNew = edificio.isNew();

		Session session = null;

		try {
			session = openSession();

			if (edificio.isNew()) {
				session.save(edificio);

				edificio.setNew(false);
			}
			else {
				edificio = (Edificio)session.merge(edificio);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, EdificioImpl.class, edificio.getPrimaryKey(),
			edificio, false);

		edificio.resetOriginalValues();

		return edificio;
	}

	/**
	 * Returns the edificio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the edificio
	 * @return the edificio
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	@Override
	public Edificio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEdificioException {

		Edificio edificio = fetchByPrimaryKey(primaryKey);

		if (edificio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEdificioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return edificio;
	}

	/**
	 * Returns the edificio with the primary key or throws a <code>NoSuchEdificioException</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	@Override
	public Edificio findByPrimaryKey(int edificioId)
		throws NoSuchEdificioException {

		return findByPrimaryKey((Serializable)edificioId);
	}

	/**
	 * Returns the edificio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio, or <code>null</code> if a edificio with the primary key could not be found
	 */
	@Override
	public Edificio fetchByPrimaryKey(int edificioId) {
		return fetchByPrimaryKey((Serializable)edificioId);
	}

	/**
	 * Returns all the edificios.
	 *
	 * @return the edificios
	 */
	@Override
	public List<Edificio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the edificios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EdificioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of edificios
	 * @param end the upper bound of the range of edificios (not inclusive)
	 * @return the range of edificios
	 */
	@Override
	public List<Edificio> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the edificios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EdificioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of edificios
	 * @param end the upper bound of the range of edificios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of edificios
	 */
	@Deprecated
	@Override
	public List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the edificios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EdificioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of edificios
	 * @param end the upper bound of the range of edificios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of edificios
	 */
	@Override
	public List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Edificio> list = (List<Edificio>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EDIFICIO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDIFICIO;

				if (pagination) {
					sql = sql.concat(EdificioModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Edificio>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Edificio>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the edificios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Edificio edificio : findAll()) {
			remove(edificio);
		}
	}

	/**
	 * Returns the number of edificios.
	 *
	 * @return the number of edificios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDIFICIO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "edificioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EDIFICIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EdificioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the edificio persistence.
	 */
	@Activate
	public void activate() {
		EdificioModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EdificioModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EdificioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EdificioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EdificioImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = EscuelaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.consistent.transporte.service.model.Edificio"),
			true);
	}

	@Override
	@Reference(
		target = EscuelaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EscuelaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EDIFICIO =
		"SELECT edificio FROM Edificio edificio";

	private static final String _SQL_COUNT_EDIFICIO =
		"SELECT COUNT(edificio) FROM Edificio edificio";

	private static final String _ORDER_BY_ENTITY_ALIAS = "edificio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Edificio exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EdificioPersistenceImpl.class);

	static {
		try {
			Class.forName(EscuelaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}