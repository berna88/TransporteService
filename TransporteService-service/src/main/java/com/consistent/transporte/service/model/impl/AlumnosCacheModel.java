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

import com.consistent.transporte.service.model.Alumnos;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Alumnos in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AlumnosCacheModel implements CacheModel<Alumnos>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlumnosCacheModel)) {
			return false;
		}

		AlumnosCacheModel alumnosCacheModel = (AlumnosCacheModel)obj;

		if (matricula == alumnosCacheModel.matricula) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, matricula);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{matricula=");
		sb.append(matricula);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", apellido=");
		sb.append(apellido);
		sb.append(", grupoId=");
		sb.append(grupoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Alumnos toEntityModel() {
		AlumnosImpl alumnosImpl = new AlumnosImpl();

		alumnosImpl.setMatricula(matricula);

		if (nombre == null) {
			alumnosImpl.setNombre("");
		}
		else {
			alumnosImpl.setNombre(nombre);
		}

		if (apellido == null) {
			alumnosImpl.setApellido("");
		}
		else {
			alumnosImpl.setApellido(apellido);
		}

		alumnosImpl.setGrupoId(grupoId);

		alumnosImpl.resetOriginalValues();

		return alumnosImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		matricula = objectInput.readInt();
		nombre = objectInput.readUTF();
		apellido = objectInput.readUTF();

		grupoId = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(matricula);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (apellido == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apellido);
		}

		objectOutput.writeInt(grupoId);
	}

	public int matricula;
	public String nombre;
	public String apellido;
	public int grupoId;

}