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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.consistent.transporte.service.service.http.AlumnosServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AlumnosSoap implements Serializable {

	public static AlumnosSoap toSoapModel(Alumnos model) {
		AlumnosSoap soapModel = new AlumnosSoap();

		soapModel.setMatricula(model.getMatricula());
		soapModel.setNombre(model.getNombre());
		soapModel.setApellido(model.getApellido());
		soapModel.setGrupoId(model.getGrupoId());

		return soapModel;
	}

	public static AlumnosSoap[] toSoapModels(Alumnos[] models) {
		AlumnosSoap[] soapModels = new AlumnosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlumnosSoap[][] toSoapModels(Alumnos[][] models) {
		AlumnosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlumnosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlumnosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlumnosSoap[] toSoapModels(List<Alumnos> models) {
		List<AlumnosSoap> soapModels = new ArrayList<AlumnosSoap>(
			models.size());

		for (Alumnos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlumnosSoap[soapModels.size()]);
	}

	public AlumnosSoap() {
	}

	public int getPrimaryKey() {
		return _matricula;
	}

	public void setPrimaryKey(int pk) {
		setMatricula(pk);
	}

	public int getMatricula() {
		return _matricula;
	}

	public void setMatricula(int matricula) {
		_matricula = matricula;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getApellido() {
		return _apellido;
	}

	public void setApellido(String apellido) {
		_apellido = apellido;
	}

	public int getGrupoId() {
		return _grupoId;
	}

	public void setGrupoId(int grupoId) {
		_grupoId = grupoId;
	}

	private int _matricula;
	private String _nombre;
	private String _apellido;
	private int _grupoId;

}