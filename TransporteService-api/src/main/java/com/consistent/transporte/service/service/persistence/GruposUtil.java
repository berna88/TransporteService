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

package com.consistent.transporte.service.service.persistence;

import com.consistent.transporte.service.model.Grupos;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the grupos service. This utility wraps <code>com.consistent.transporte.service.service.persistence.impl.GruposPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GruposPersistence
 * @generated
 */
@ProviderType
public class GruposUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Grupos grupos) {
		getPersistence().clearCache(grupos);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Grupos> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Grupos> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Grupos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Grupos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Grupos> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Grupos update(Grupos grupos) {
		return getPersistence().update(grupos);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Grupos update(Grupos grupos, ServiceContext serviceContext) {
		return getPersistence().update(grupos, serviceContext);
	}

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	public static void cacheResult(Grupos grupos) {
		getPersistence().cacheResult(grupos);
	}

	/**
	 * Caches the gruposes in the entity cache if it is enabled.
	 *
	 * @param gruposes the gruposes
	 */
	public static void cacheResult(List<Grupos> gruposes) {
		getPersistence().cacheResult(gruposes);
	}

	/**
	 * Creates a new grupos with the primary key. Does not add the grupos to the database.
	 *
	 * @param grupoId the primary key for the new grupos
	 * @return the new grupos
	 */
	public static Grupos create(int grupoId) {
		return getPersistence().create(grupoId);
	}

	/**
	 * Removes the grupos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos that was removed
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	public static Grupos remove(int grupoId)
		throws com.consistent.transporte.service.exception.
			NoSuchGruposException {

		return getPersistence().remove(grupoId);
	}

	public static Grupos updateImpl(Grupos grupos) {
		return getPersistence().updateImpl(grupos);
	}

	/**
	 * Returns the grupos with the primary key or throws a <code>NoSuchGruposException</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	public static Grupos findByPrimaryKey(int grupoId)
		throws com.consistent.transporte.service.exception.
			NoSuchGruposException {

		return getPersistence().findByPrimaryKey(grupoId);
	}

	/**
	 * Returns the grupos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos, or <code>null</code> if a grupos with the primary key could not be found
	 */
	public static Grupos fetchByPrimaryKey(int grupoId) {
		return getPersistence().fetchByPrimaryKey(grupoId);
	}

	/**
	 * Returns all the gruposes.
	 *
	 * @return the gruposes
	 */
	public static List<Grupos> findAll() {
		return getPersistence().findAll();
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
	public static List<Grupos> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the gruposes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gruposes.
	 *
	 * @return the number of gruposes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GruposPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GruposPersistence, GruposPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GruposPersistence.class);

		ServiceTracker<GruposPersistence, GruposPersistence> serviceTracker =
			new ServiceTracker<GruposPersistence, GruposPersistence>(
				bundle.getBundleContext(), GruposPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}