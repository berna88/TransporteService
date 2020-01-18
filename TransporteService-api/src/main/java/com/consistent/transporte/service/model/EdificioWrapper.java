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

package com.consistent.transporte.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Edificio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Edificio
 * @generated
 */
@ProviderType
public class EdificioWrapper
	extends BaseModelWrapper<Edificio>
	implements Edificio, ModelWrapper<Edificio> {

	public EdificioWrapper(Edificio edificio) {
		super(edificio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("edificioId", getEdificioId());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer edificioId = (Integer)attributes.get("edificioId");

		if (edificioId != null) {
			setEdificioId(edificioId);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	 * Returns the edificio ID of this edificio.
	 *
	 * @return the edificio ID of this edificio
	 */
	@Override
	public int getEdificioId() {
		return model.getEdificioId();
	}

	/**
	 * Returns the nombre of this edificio.
	 *
	 * @return the nombre of this edificio
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this edificio.
	 *
	 * @return the primary key of this edificio
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the edificio ID of this edificio.
	 *
	 * @param edificioId the edificio ID of this edificio
	 */
	@Override
	public void setEdificioId(int edificioId) {
		model.setEdificioId(edificioId);
	}

	/**
	 * Sets the nombre of this edificio.
	 *
	 * @param nombre the nombre of this edificio
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this edificio.
	 *
	 * @param primaryKey the primary key of this edificio
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EdificioWrapper wrap(Edificio edificio) {
		return new EdificioWrapper(edificio);
	}

}