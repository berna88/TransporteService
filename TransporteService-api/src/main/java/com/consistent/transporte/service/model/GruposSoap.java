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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class GruposSoap implements Serializable {

	public static GruposSoap toSoapModel(Grupos model) {
		GruposSoap soapModel = new GruposSoap();

		soapModel.setGrupoId(model.getGrupoId());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static GruposSoap[] toSoapModels(Grupos[] models) {
		GruposSoap[] soapModels = new GruposSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GruposSoap[][] toSoapModels(Grupos[][] models) {
		GruposSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GruposSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GruposSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GruposSoap[] toSoapModels(List<Grupos> models) {
		List<GruposSoap> soapModels = new ArrayList<GruposSoap>(models.size());

		for (Grupos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GruposSoap[soapModels.size()]);
	}

	public GruposSoap() {
	}

	public int getPrimaryKey() {
		return _grupoId;
	}

	public void setPrimaryKey(int pk) {
		setGrupoId(pk);
	}

	public int getGrupoId() {
		return _grupoId;
	}

	public void setGrupoId(int grupoId) {
		_grupoId = grupoId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _grupoId;
	private String _nombre;

}