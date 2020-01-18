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

import com.consistent.transporte.service.exception.NoSuchGruposException;
import com.consistent.transporte.service.model.Grupos;
import com.consistent.transporte.service.model.impl.GruposImpl;
import com.consistent.transporte.service.model.impl.GruposModelImpl;
import com.consistent.transporte.service.service.persistence.GruposPersistence;
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
 * The persistence implementation for the grupos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GruposPersistence.class)
@ProviderType
public class GruposPersistenceImpl
	extends BasePersistenceImpl<Grupos> implements GruposPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GruposUtil</code> to access the grupos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GruposImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GruposPersistenceImpl() {
		setModelClass(Grupos.class);

		setModelImplClass(GruposImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	@Override
	public void cacheResult(Grupos grupos) {
		entityCache.putResult(
			entityCacheEnabled, GruposImpl.class, grupos.getPrimaryKey(),
			grupos);

		grupos.resetOriginalValues();
	}

	/**
	 * Caches the gruposes in the entity cache if it is enabled.
	 *
	 * @param gruposes the gruposes
	 */
	@Override
	public void cacheResult(List<Grupos> gruposes) {
		for (Grupos grupos : gruposes) {
			if (entityCache.getResult(
					entityCacheEnabled, GruposImpl.class,
					grupos.getPrimaryKey()) == null) {

				cacheResult(grupos);
			}
			else {
				grupos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gruposes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GruposImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the grupos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Grupos grupos) {
		entityCache.removeResult(
			entityCacheEnabled, GruposImpl.class, grupos.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Grupos> gruposes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Grupos grupos : gruposes) {
			entityCache.removeResult(
				entityCacheEnabled, GruposImpl.class, grupos.getPrimaryKey());
		}
	}

	/**
	 * Creates a new grupos with the primary key. Does not add the grupos to the database.
	 *
	 * @param grupoId the primary key for the new grupos
	 * @return the new grupos
	 */
	@Override
	public Grupos create(int grupoId) {
		Grupos grupos = new GruposImpl();

		grupos.setNew(true);
		grupos.setPrimaryKey(grupoId);

		return grupos;
	}

	/**
	 * Removes the grupos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos that was removed
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	@Override
	public Grupos remove(int grupoId) throws NoSuchGruposException {
		return remove((Serializable)grupoId);
	}

	/**
	 * Removes the grupos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the grupos
	 * @return the grupos that was removed
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	@Override
	public Grupos remove(Serializable primaryKey) throws NoSuchGruposException {
		Session session = null;

		try {
			session = openSession();

			Grupos grupos = (Grupos)session.get(GruposImpl.class, primaryKey);

			if (grupos == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGruposException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(grupos);
		}
		catch (NoSuchGruposException nsee) {
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
	protected Grupos removeImpl(Grupos grupos) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(grupos)) {
				grupos = (Grupos)session.get(
					GruposImpl.class, grupos.getPrimaryKeyObj());
			}

			if (grupos != null) {
				session.delete(grupos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (grupos != null) {
			clearCache(grupos);
		}

		return grupos;
	}

	@Override
	public Grupos updateImpl(Grupos grupos) {
		boolean isNew = grupos.isNew();

		Session session = null;

		try {
			session = openSession();

			if (grupos.isNew()) {
				session.save(grupos);

				grupos.setNew(false);
			}
			else {
				grupos = (Grupos)session.merge(grupos);
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
			entityCacheEnabled, GruposImpl.class, grupos.getPrimaryKey(),
			grupos, false);

		grupos.resetOriginalValues();

		return grupos;
	}

	/**
	 * Returns the grupos with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the grupos
	 * @return the grupos
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	@Override
	public Grupos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGruposException {

		Grupos grupos = fetchByPrimaryKey(primaryKey);

		if (grupos == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGruposException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return grupos;
	}

	/**
	 * Returns the grupos with the primary key or throws a <code>NoSuchGruposException</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	@Override
	public Grupos findByPrimaryKey(int grupoId) throws NoSuchGruposException {
		return findByPrimaryKey((Serializable)grupoId);
	}

	/**
	 * Returns the grupos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos, or <code>null</code> if a grupos with the primary key could not be found
	 */
	@Override
	public Grupos fetchByPrimaryKey(int grupoId) {
		return fetchByPrimaryKey((Serializable)grupoId);
	}

	/**
	 * Returns all the gruposes.
	 *
	 * @return the gruposes
	 */
	@Override
	public List<Grupos> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gruposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GruposModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gruposes
	 * @param end the upper bound of the range of gruposes (not inclusive)
	 * @return the range of gruposes
	 */
	@Override
	public List<Grupos> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gruposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GruposModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of gruposes
	 * @param end the upper bound of the range of gruposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gruposes
	 */
	@Deprecated
	@Override
	public List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gruposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GruposModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gruposes
	 * @param end the upper bound of the range of gruposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gruposes
	 */
	@Override
	public List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator) {

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

		List<Grupos> list = (List<Grupos>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GRUPOS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GRUPOS;

				if (pagination) {
					sql = sql.concat(GruposModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Grupos>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Grupos>)QueryUtil.list(
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
	 * Removes all the gruposes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Grupos grupos : findAll()) {
			remove(grupos);
		}
	}

	/**
	 * Returns the number of gruposes.
	 *
	 * @return the number of gruposes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GRUPOS);

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
		return "grupoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GRUPOS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GruposModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the grupos persistence.
	 */
	@Activate
	public void activate() {
		GruposModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GruposModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GruposImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GruposImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GruposImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.consistent.transporte.service.model.Grupos"),
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

	private static final String _SQL_SELECT_GRUPOS =
		"SELECT grupos FROM Grupos grupos";

	private static final String _SQL_COUNT_GRUPOS =
		"SELECT COUNT(grupos) FROM Grupos grupos";

	private static final String _ORDER_BY_ENTITY_ALIAS = "grupos.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Grupos exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GruposPersistenceImpl.class);

	static {
		try {
			Class.forName(EscuelaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}