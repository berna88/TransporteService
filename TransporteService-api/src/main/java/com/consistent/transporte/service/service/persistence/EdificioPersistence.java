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

import com.consistent.transporte.service.exception.NoSuchEdificioException;
import com.consistent.transporte.service.model.Edificio;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the edificio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EdificioUtil
 * @generated
 */
@ProviderType
public interface EdificioPersistence extends BasePersistence<Edificio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EdificioUtil} to access the edificio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the edificio in the entity cache if it is enabled.
	 *
	 * @param edificio the edificio
	 */
	public void cacheResult(Edificio edificio);

	/**
	 * Caches the edificios in the entity cache if it is enabled.
	 *
	 * @param edificios the edificios
	 */
	public void cacheResult(java.util.List<Edificio> edificios);

	/**
	 * Creates a new edificio with the primary key. Does not add the edificio to the database.
	 *
	 * @param edificioId the primary key for the new edificio
	 * @return the new edificio
	 */
	public Edificio create(int edificioId);

	/**
	 * Removes the edificio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio that was removed
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	public Edificio remove(int edificioId) throws NoSuchEdificioException;

	public Edificio updateImpl(Edificio edificio);

	/**
	 * Returns the edificio with the primary key or throws a <code>NoSuchEdificioException</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio
	 * @throws NoSuchEdificioException if a edificio with the primary key could not be found
	 */
	public Edificio findByPrimaryKey(int edificioId)
		throws NoSuchEdificioException;

	/**
	 * Returns the edificio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param edificioId the primary key of the edificio
	 * @return the edificio, or <code>null</code> if a edificio with the primary key could not be found
	 */
	public Edificio fetchByPrimaryKey(int edificioId);

	/**
	 * Returns all the edificios.
	 *
	 * @return the edificios
	 */
	public java.util.List<Edificio> findAll();

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
	public java.util.List<Edificio> findAll(int start, int end);

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
	public java.util.List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Edificio> findAll(
		int start, int end, OrderByComparator<Edificio> orderByComparator);

	/**
	 * Removes all the edificios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of edificios.
	 *
	 * @return the number of edificios
	 */
	public int countAll();

}