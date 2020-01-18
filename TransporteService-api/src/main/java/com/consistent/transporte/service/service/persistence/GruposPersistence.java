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

import com.consistent.transporte.service.exception.NoSuchGruposException;
import com.consistent.transporte.service.model.Grupos;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the grupos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GruposUtil
 * @generated
 */
@ProviderType
public interface GruposPersistence extends BasePersistence<Grupos> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GruposUtil} to access the grupos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	public void cacheResult(Grupos grupos);

	/**
	 * Caches the gruposes in the entity cache if it is enabled.
	 *
	 * @param gruposes the gruposes
	 */
	public void cacheResult(java.util.List<Grupos> gruposes);

	/**
	 * Creates a new grupos with the primary key. Does not add the grupos to the database.
	 *
	 * @param grupoId the primary key for the new grupos
	 * @return the new grupos
	 */
	public Grupos create(int grupoId);

	/**
	 * Removes the grupos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos that was removed
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	public Grupos remove(int grupoId) throws NoSuchGruposException;

	public Grupos updateImpl(Grupos grupos);

	/**
	 * Returns the grupos with the primary key or throws a <code>NoSuchGruposException</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos
	 * @throws NoSuchGruposException if a grupos with the primary key could not be found
	 */
	public Grupos findByPrimaryKey(int grupoId) throws NoSuchGruposException;

	/**
	 * Returns the grupos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param grupoId the primary key of the grupos
	 * @return the grupos, or <code>null</code> if a grupos with the primary key could not be found
	 */
	public Grupos fetchByPrimaryKey(int grupoId);

	/**
	 * Returns all the gruposes.
	 *
	 * @return the gruposes
	 */
	public java.util.List<Grupos> findAll();

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
	public java.util.List<Grupos> findAll(int start, int end);

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
	public java.util.List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Grupos> findAll(
		int start, int end, OrderByComparator<Grupos> orderByComparator);

	/**
	 * Removes all the gruposes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gruposes.
	 *
	 * @return the number of gruposes
	 */
	public int countAll();

}