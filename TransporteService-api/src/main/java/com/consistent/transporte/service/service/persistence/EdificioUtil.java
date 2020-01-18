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

import com.consistent.transporte.service.model.Edificio;

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
 * The persistence utility for the edificio service. This utility wraps <code>com.consistent.transporte.service.service.persistence.impl.EdificioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EdificioPersistence
 * @generated
 */
@ProviderType
public class EdificioUtil {

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
	public static void clearCache(Edificio edificio) {
		getPersistence().clearCache(edificio);
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
	public static Map<Serializable, Edificio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Edificio> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Edificio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Edificio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Edificio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Edificio update(Edificio edificio) {
		return getPersistence().update(edificio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Edificio update(
		Edificio edificio, ServiceContext serviceContext) {

		return getPersistence().update(edificio, serviceContext);
	}

	/**
	 * Caches the edificio in the entity cache if it is enabled.
	 *
	 * @param edificio the edificio
	 */
	public static void cacheResult(Edificio edificio) {
		getPersistence().cacheResult(edificio);
	}

	/**
	 * Caches the edificios in the entity cache if it is enabled.
	 *
	 * @param edificios the edificios
	 */
	public static void cacheResult(List<Edificio> edificios) {
		getPersistence().cacheResult(edificios);
	}

	/**
	 * Creates a new edificio with the primary key. Does not add the edificio to the database.
	 *
	 * @param edificioId the primary key for the new edificio
	 * @return the new edificio
	 */
	public static Edificio create(int edificioId) {
		return getPersistence().create(edificioId);
	}

	/**
	 * Removes the edificio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio that was removed
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	public static Edificio remove(int edificioId)
		throws com.consistent.transporte.service.exception.
			NoSuchEdificioException {

		return getPersistence().remove(edificioId);
	}

	public static Edificio updateImpl(Edificio edificio) {
		return getPersistence().updateImpl(edificio);
	}

	/**
	 * Returns the edificio with the primary key or throws a <code>NoSuchEdificioException</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	public static Edificio findByPrimaryKey(int edificioId)
		throws com.consistent.transporte.service.exception.
			NoSuchEdificioException {

		return getPersistence().findByPrimaryKey(edificioId);
	}

	/**
	 * Returns the edificio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio, or <code>null</code> if a edificio with the primary key could not be found
	 */
	public static Edificio fetchByPrimaryKey(int edificioId) {
		return getPersistence().fetchByPrimaryKey(edificioId);
	}

	/**
	 * Returns all the edificios.
	 *
	 * @return the edificios
	 */
	public static List<Edificio> findAll() {
		return getPersistence().findAll();
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
	public static List<Edificio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the edificios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of edificios.
	 *
	 * @return the number of edificios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EdificioPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EdificioPersistence, EdificioPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EdificioPersistence.class);

		ServiceTracker<EdificioPersistence, EdificioPersistence>
			serviceTracker =
				new ServiceTracker<EdificioPersistence, EdificioPersistence>(
					bundle.getBundleContext(), EdificioPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}