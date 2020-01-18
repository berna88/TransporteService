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

import com.consistent.transporte.service.exception.NoSuchAlumnosException;
import com.consistent.transporte.service.model.Alumnos;
import com.consistent.transporte.service.model.impl.AlumnosImpl;
import com.consistent.transporte.service.model.impl.AlumnosModelImpl;
import com.consistent.transporte.service.service.persistence.AlumnosPersistence;
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
 * The persistence implementation for the alumnos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AlumnosPersistence.class)
@ProviderType
public class AlumnosPersistenceImpl
	extends BasePersistenceImpl<Alumnos> implements AlumnosPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AlumnosUtil</code> to access the alumnos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AlumnosImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AlumnosPersistenceImpl() {
		setModelClass(Alumnos.class);

		setModelImplClass(AlumnosImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the alumnos in the entity cache if it is enabled.
	 *
	 * @param alumnos the alumnos
	 */
	@Override
	public void cacheResult(Alumnos alumnos) {
		entityCache.putResult(
			entityCacheEnabled, AlumnosImpl.class, alumnos.getPrimaryKey(),
			alumnos);

		alumnos.resetOriginalValues();
	}

	/**
	 * Caches the alumnoses in the entity cache if it is enabled.
	 *
	 * @param alumnoses the alumnoses
	 */
	@Override
	public void cacheResult(List<Alumnos> alumnoses) {
		for (Alumnos alumnos : alumnoses) {
			if (entityCache.getResult(
					entityCacheEnabled, AlumnosImpl.class,
					alumnos.getPrimaryKey()) == null) {

				cacheResult(alumnos);
			}
			else {
				alumnos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all alumnoses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AlumnosImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the alumnos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Alumnos alumnos) {
		entityCache.removeResult(
			entityCacheEnabled, AlumnosImpl.class, alumnos.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Alumnos> alumnoses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Alumnos alumnos : alumnoses) {
			entityCache.removeResult(
				entityCacheEnabled, AlumnosImpl.class, alumnos.getPrimaryKey());
		}
	}

	/**
	 * Creates a new alumnos with the primary key. Does not add the alumnos to the database.
	 *
	 * @param matricula the primary key for the new alumnos
	 * @return the new alumnos
	 */
	@Override
	public Alumnos create(int matricula) {
		Alumnos alumnos = new AlumnosImpl();

		alumnos.setNew(true);
		alumnos.setPrimaryKey(matricula);

		return alumnos;
	}

	/**
	 * Removes the alumnos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos that was removed
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	@Override
	public Alumnos remove(int matricula) throws NoSuchAlumnosException {
		return remove((Serializable)matricula);
	}

	/**
	 * Removes the alumnos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the alumnos
	 * @return the alumnos that was removed
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	@Override
	public Alumnos remove(Serializable primaryKey)
		throws NoSuchAlumnosException {

		Session session = null;

		try {
			session = openSession();

			Alumnos alumnos = (Alumnos)session.get(
				AlumnosImpl.class, primaryKey);

			if (alumnos == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlumnosException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(alumnos);
		}
		catch (NoSuchAlumnosException nsee) {
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
	protected Alumnos removeImpl(Alumnos alumnos) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(alumnos)) {
				alumnos = (Alumnos)session.get(
					AlumnosImpl.class, alumnos.getPrimaryKeyObj());
			}

			if (alumnos != null) {
				session.delete(alumnos);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (alumnos != null) {
			clearCache(alumnos);
		}

		return alumnos;
	}

	@Override
	public Alumnos updateImpl(Alumnos alumnos) {
		boolean isNew = alumnos.isNew();

		Session session = null;

		try {
			session = openSession();

			if (alumnos.isNew()) {
				session.save(alumnos);

				alumnos.setNew(false);
			}
			else {
				alumnos = (Alumnos)session.merge(alumnos);
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
			entityCacheEnabled, AlumnosImpl.class, alumnos.getPrimaryKey(),
			alumnos, false);

		alumnos.resetOriginalValues();

		return alumnos;
	}

	/**
	 * Returns the alumnos with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the alumnos
	 * @return the alumnos
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	@Override
	public Alumnos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlumnosException {

		Alumnos alumnos = fetchByPrimaryKey(primaryKey);

		if (alumnos == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlumnosException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return alumnos;
	}

	/**
	 * Returns the alumnos with the primary key or throws a <code>NoSuchAlumnosException</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	@Override
	public Alumnos findByPrimaryKey(int matricula)
		throws NoSuchAlumnosException {

		return findByPrimaryKey((Serializable)matricula);
	}

	/**
	 * Returns the alumnos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos, or <code>null</code> if a alumnos with the primary key could not be found
	 */
	@Override
	public Alumnos fetchByPrimaryKey(int matricula) {
		return fetchByPrimaryKey((Serializable)matricula);
	}

	/**
	 * Returns all the alumnoses.
	 *
	 * @return the alumnoses
	 */
	@Override
	public List<Alumnos> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alumnoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alumnoses
	 * @param end the upper bound of the range of alumnoses (not inclusive)
	 * @return the range of alumnoses
	 */
	@Override
	public List<Alumnos> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the alumnoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of alumnoses
	 * @param end the upper bound of the range of alumnoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of alumnoses
	 */
	@Deprecated
	@Override
	public List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the alumnoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alumnoses
	 * @param end the upper bound of the range of alumnoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alumnoses
	 */
	@Override
	public List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator) {

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

		List<Alumnos> list = (List<Alumnos>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ALUMNOS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALUMNOS;

				if (pagination) {
					sql = sql.concat(AlumnosModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Alumnos>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Alumnos>)QueryUtil.list(
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
	 * Removes all the alumnoses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Alumnos alumnos : findAll()) {
			remove(alumnos);
		}
	}

	/**
	 * Returns the number of alumnoses.
	 *
	 * @return the number of alumnoses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALUMNOS);

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
		return "matricula";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALUMNOS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AlumnosModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the alumnos persistence.
	 */
	@Activate
	public void activate() {
		AlumnosModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		AlumnosModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AlumnosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, AlumnosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AlumnosImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.consistent.transporte.service.model.Alumnos"),
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

	private static final String _SQL_SELECT_ALUMNOS =
		"SELECT alumnos FROM Alumnos alumnos";

	private static final String _SQL_COUNT_ALUMNOS =
		"SELECT COUNT(alumnos) FROM Alumnos alumnos";

	private static final String _ORDER_BY_ENTITY_ALIAS = "alumnos.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Alumnos exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AlumnosPersistenceImpl.class);

	static {
		try {
			Class.forName(EscuelaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}