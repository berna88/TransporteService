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
public class EdificioSoap implements Serializable {

	public static EdificioSoap toSoapModel(Edificio model) {
		EdificioSoap soapModel = new EdificioSoap();

		soapModel.setEdificioId(model.getEdificioId());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static EdificioSoap[] toSoapModels(Edificio[] models) {
		EdificioSoap[] soapModels = new EdificioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EdificioSoap[][] toSoapModels(Edificio[][] models) {
		EdificioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EdificioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EdificioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EdificioSoap[] toSoapModels(List<Edificio> models) {
		List<EdificioSoap> soapModels = new ArrayList<EdificioSoap>(
			models.size());

		for (Edificio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EdificioSoap[soapModels.size()]);
	}

	public EdificioSoap() {
	}

	public int getPrimaryKey() {
		return _edificioId;
	}

	public void setPrimaryKey(int pk) {
		setEdificioId(pk);
	}

	public int getEdificioId() {
		return _edificioId;
	}

	public void setEdificioId(int edificioId) {
		_edificioId = edificioId;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private int _edificioId;
	private String _nombre;

}