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

import com.consistent.transporte.service.model.Alumnos;

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
 * The persistence utility for the alumnos service. This utility wraps <code>com.consistent.transporte.service.service.persistence.impl.AlumnosPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlumnosPersistence
 * @generated
 */
@ProviderType
public class AlumnosUtil {

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
	public static void clearCache(Alumnos alumnos) {
		getPersistence().clearCache(alumnos);
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
	public static Map<Serializable, Alumnos> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Alumnos> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Alumnos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Alumnos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Alumnos> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Alumnos update(Alumnos alumnos) {
		return getPersistence().update(alumnos);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Alumnos update(
		Alumnos alumnos, ServiceContext serviceContext) {

		return getPersistence().update(alumnos, serviceContext);
	}

	/**
	 * Caches the alumnos in the entity cache if it is enabled.
	 *
	 * @param alumnos the alumnos
	 */
	public static void cacheResult(Alumnos alumnos) {
		getPersistence().cacheResult(alumnos);
	}

	/**
	 * Caches the alumnoses in the entity cache if it is enabled.
	 *
	 * @param alumnoses the alumnoses
	 */
	public static void cacheResult(List<Alumnos> alumnoses) {
		getPersistence().cacheResult(alumnoses);
	}

	/**
	 * Creates a new alumnos with the primary key. Does not add the alumnos to the database.
	 *
	 * @param matricula the primary key for the new alumnos
	 * @return the new alumnos
	 */
	public static Alumnos create(int matricula) {
		return getPersistence().create(matricula);
	}

	/**
	 * Removes the alumnos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos that was removed
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	public static Alumnos remove(int matricula)
		throws com.consistent.transporte.service.exception.
			NoSuchAlumnosException {

		return getPersistence().remove(matricula);
	}

	public static Alumnos updateImpl(Alumnos alumnos) {
		return getPersistence().updateImpl(alumnos);
	}

	/**
	 * Returns the alumnos with the primary key or throws a <code>NoSuchAlumnosException</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	public static Alumnos findByPrimaryKey(int matricula)
		throws com.consistent.transporte.service.exception.
			NoSuchAlumnosException {

		return getPersistence().findByPrimaryKey(matricula);
	}

	/**
	 * Returns the alumnos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos, or <code>null</code> if a alumnos with the primary key could not be found
	 */
	public static Alumnos fetchByPrimaryKey(int matricula) {
		return getPersistence().fetchByPrimaryKey(matricula);
	}

	/**
	 * Returns all the alumnoses.
	 *
	 * @return the alumnoses
	 */
	public static List<Alumnos> findAll() {
		return getPersistence().findAll();
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
	public static List<Alumnos> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the alumnoses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of alumnoses.
	 *
	 * @return the number of alumnoses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AlumnosPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AlumnosPersistence, AlumnosPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AlumnosPersistence.class);

		ServiceTracker<AlumnosPersistence, AlumnosPersistence> serviceTracker =
			new ServiceTracker<AlumnosPersistence, AlumnosPersistence>(
				bundle.getBundleContext(), AlumnosPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}