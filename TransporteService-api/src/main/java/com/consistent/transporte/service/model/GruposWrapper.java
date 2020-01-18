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
 * This class is a wrapper for {@link Grupos}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Grupos
 * @generated
 */
@ProviderType
public class GruposWrapper
	extends BaseModelWrapper<Grupos> implements Grupos, ModelWrapper<Grupos> {

	public GruposWrapper(Grupos grupos) {
		super(grupos);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("grupoId", getGrupoId());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer grupoId = (Integer)attributes.get("grupoId");

		if (grupoId != null) {
			setGrupoId(grupoId);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	 * Returns the grupo ID of this grupos.
	 *
	 * @return the grupo ID of this grupos
	 */
	@Override
	public int getGrupoId() {
		return model.getGrupoId();
	}

	/**
	 * Returns the nombre of this grupos.
	 *
	 * @return the nombre of this grupos
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this grupos.
	 *
	 * @return the primary key of this grupos
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
	 * Sets the grupo ID of this grupos.
	 *
	 * @param grupoId the grupo ID of this grupos
	 */
	@Override
	public void setGrupoId(int grupoId) {
		model.setGrupoId(grupoId);
	}

	/**
	 * Sets the nombre of this grupos.
	 *
	 * @param nombre the nombre of this grupos
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this grupos.
	 *
	 * @param primaryKey the primary key of this grupos
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected GruposWrapper wrap(Grupos grupos) {
		return new GruposWrapper(grupos);
	}

}