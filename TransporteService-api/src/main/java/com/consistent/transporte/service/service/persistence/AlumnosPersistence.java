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

import com.consistent.transporte.service.exception.NoSuchAlumnosException;
import com.consistent.transporte.service.model.Alumnos;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the alumnos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlumnosUtil
 * @generated
 */
@ProviderType
public interface AlumnosPersistence extends BasePersistence<Alumnos> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlumnosUtil} to access the alumnos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the alumnos in the entity cache if it is enabled.
	 *
	 * @param alumnos the alumnos
	 */
	public void cacheResult(Alumnos alumnos);

	/**
	 * Caches the alumnoses in the entity cache if it is enabled.
	 *
	 * @param alumnoses the alumnoses
	 */
	public void cacheResult(java.util.List<Alumnos> alumnoses);

	/**
	 * Creates a new alumnos with the primary key. Does not add the alumnos to the database.
	 *
	 * @param matricula the primary key for the new alumnos
	 * @return the new alumnos
	 */
	public Alumnos create(int matricula);

	/**
	 * Removes the alumnos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos that was removed
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	public Alumnos remove(int matricula) throws NoSuchAlumnosException;

	public Alumnos updateImpl(Alumnos alumnos);

	/**
	 * Returns the alumnos with the primary key or throws a <code>NoSuchAlumnosException</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos
	 * @throws NoSuchAlumnosException if a alumnos with the primary key could not be found
	 */
	public Alumnos findByPrimaryKey(int matricula)
		throws NoSuchAlumnosException;

	/**
	 * Returns the alumnos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos, or <code>null</code> if a alumnos with the primary key could not be found
	 */
	public Alumnos fetchByPrimaryKey(int matricula);

	/**
	 * Returns all the alumnoses.
	 *
	 * @return the alumnoses
	 */
	public java.util.List<Alumnos> findAll();

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
	public java.util.List<Alumnos> findAll(int start, int end);

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
	public java.util.List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Alumnos> findAll(
		int start, int end, OrderByComparator<Alumnos> orderByComparator);

	/**
	 * Removes all the alumnoses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of alumnoses.
	 *
	 * @return the number of alumnoses
	 */
	public int countAll();

}