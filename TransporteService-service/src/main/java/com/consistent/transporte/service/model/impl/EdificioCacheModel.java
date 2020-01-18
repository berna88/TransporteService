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

package com.consistent.transporte.service.model.impl;

import com.consistent.transporte.service.model.Edificio;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Edificio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EdificioCacheModel
	implements CacheModel<Edificio>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EdificioCacheModel)) {
			return false;
		}

		EdificioCacheModel edificioCacheModel = (EdificioCacheModel)obj;

		if (edificioId == edificioCacheModel.edificioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, edificioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{edificioId=");
		sb.append(edificioId);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Edificio toEntityModel() {
		EdificioImpl edificioImpl = new EdificioImpl();

		edificioImpl.setEdificioId(edificioId);

		if (nombre == null) {
			edificioImpl.setNombre("");
		}
		else {
			edificioImpl.setNombre(nombre);
		}

		edificioImpl.resetOriginalValues();

		return edificioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		edificioId = objectInput.readInt();
		nombre = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(edificioId);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}
	}

	public int edificioId;
	public String nombre;

}