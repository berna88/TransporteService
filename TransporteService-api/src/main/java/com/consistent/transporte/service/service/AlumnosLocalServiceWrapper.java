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

package com.consistent.transporte.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link AlumnosLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AlumnosLocalService
 * @generated
 */
@ProviderType
public class AlumnosLocalServiceWrapper
	implements AlumnosLocalService, ServiceWrapper<AlumnosLocalService> {

	public AlumnosLocalServiceWrapper(AlumnosLocalService alumnosLocalService) {
		_alumnosLocalService = alumnosLocalService;
	}

	/**
	 * Adds the alumnos to the database. Also notifies the appropriate model listeners.
	 *
	 * @param alumnos the alumnos
	 * @return the alumnos that was added
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos addAlumnos(
		com.consistent.transporte.service.model.Alumnos alumnos) {

		return _alumnosLocalService.addAlumnos(alumnos);
	}

	/**
	 * Creates a new alumnos with the primary key. Does not add the alumnos to the database.
	 *
	 * @param matricula the primary key for the new alumnos
	 * @return the new alumnos
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos createAlumnos(
		int matricula) {

		return _alumnosLocalService.createAlumnos(matricula);
	}

	/**
	 * Deletes the alumnos from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alumnos the alumnos
	 * @return the alumnos that was removed
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos deleteAlumnos(
		com.consistent.transporte.service.model.Alumnos alumnos) {

		return _alumnosLocalService.deleteAlumnos(alumnos);
	}

	/**
	 * Deletes the alumnos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos that was removed
	 * @throws PortalException if a alumnos with the primary key could not be found
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos deleteAlumnos(
			int matricula)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alumnosLocalService.deleteAlumnos(matricula);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alumnosLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alumnosLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _alumnosLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.consistent.transporte.service.model.impl.AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _alumnosLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.consistent.transporte.service.model.impl.AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _alumnosLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _alumnosLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _alumnosLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.consistent.transporte.service.model.Alumnos fetchAlumnos(
		int matricula) {

		return _alumnosLocalService.fetchAlumnos(matricula);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _alumnosLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the alumnos with the primary key.
	 *
	 * @param matricula the primary key of the alumnos
	 * @return the alumnos
	 * @throws PortalException if a alumnos with the primary key could not be found
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos getAlumnos(
			int matricula)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alumnosLocalService.getAlumnos(matricula);
	}

	/**
	 * Returns a range of all the alumnoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.consistent.transporte.service.model.impl.AlumnosModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of alumnoses
	 * @param end the upper bound of the range of alumnoses (not inclusive)
	 * @return the range of alumnoses
	 */
	@Override
	public java.util.List<com.consistent.transporte.service.model.Alumnos>
		getAlumnoses(int start, int end) {

		return _alumnosLocalService.getAlumnoses(start, end);
	}

	/**
	 * Returns the number of alumnoses.
	 *
	 * @return the number of alumnoses
	 */
	@Override
	public int getAlumnosesCount() {
		return _alumnosLocalService.getAlumnosesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _alumnosLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _alumnosLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alumnosLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the alumnos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param alumnos the alumnos
	 * @return the alumnos that was updated
	 */
	@Override
	public com.consistent.transporte.service.model.Alumnos updateAlumnos(
		com.consistent.transporte.service.model.Alumnos alumnos) {

		return _alumnosLocalService.updateAlumnos(alumnos);
	}

	@Override
	public AlumnosLocalService getWrappedService() {
		return _alumnosLocalService;
	}

	@Override
	public void setWrappedService(AlumnosLocalService alumnosLocalService) {
		_alumnosLocalService = alumnosLocalService;
	}

	private AlumnosLocalService _alumnosLocalService;

}