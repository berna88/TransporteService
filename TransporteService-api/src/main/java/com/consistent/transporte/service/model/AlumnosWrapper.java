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
 * This class is a wrapper for {@link Alumnos}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Alumnos
 * @generated
 */
@ProviderType
public class AlumnosWrapper
	extends BaseModelWrapper<Alumnos>
	implements Alumnos, ModelWrapper<Alumnos> {

	public AlumnosWrapper(Alumnos alumnos) {
		super(alumnos);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("matricula", getMatricula());
		attributes.put("nombre", getNombre());
		attributes.put("apellido", getApellido());
		attributes.put("grupoId", getGrupoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer matricula = (Integer)attributes.get("matricula");

		if (matricula != null) {
			setMatricula(matricula);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String apellido = (String)attributes.get("apellido");

		if (apellido != null) {
			setApellido(apellido);
		}

		Integer grupoId = (Integer)attributes.get("grupoId");

		if (grupoId != null) {
			setGrupoId(grupoId);
		}
	}

	/**
	 * Returns the apellido of this alumnos.
	 *
	 * @return the apellido of this alumnos
	 */
	@Override
	public String getApellido() {
		return model.getApellido();
	}

	/**
	 * Returns the grupo ID of this alumnos.
	 *
	 * @return the grupo ID of this alumnos
	 */
	@Override
	public int getGrupoId() {
		return model.getGrupoId();
	}

	/**
	 * Returns the matricula of this alumnos.
	 *
	 * @return the matricula of this alumnos
	 */
	@Override
	public int getMatricula() {
		return model.getMatricula();
	}

	/**
	 * Returns the nombre of this alumnos.
	 *
	 * @return the nombre of this alumnos
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this alumnos.
	 *
	 * @return the primary key of this alumnos
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
	 * Sets the apellido of this alumnos.
	 *
	 * @param apellido the apellido of this alumnos
	 */
	@Override
	public void setApellido(String apellido) {
		model.setApellido(apellido);
	}

	/**
	 * Sets the grupo ID of this alumnos.
	 *
	 * @param grupoId the grupo ID of this alumnos
	 */
	@Override
	public void setGrupoId(int grupoId) {
		model.setGrupoId(grupoId);
	}

	/**
	 * Sets the matricula of this alumnos.
	 *
	 * @param matricula the matricula of this alumnos
	 */
	@Override
	public void setMatricula(int matricula) {
		model.setMatricula(matricula);
	}

	/**
	 * Sets the nombre of this alumnos.
	 *
	 * @param nombre the nombre of this alumnos
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this alumnos.
	 *
	 * @param primaryKey the primary key of this alumnos
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AlumnosWrapper wrap(Alumnos alumnos) {
		return new AlumnosWrapper(alumnos);
	}

}