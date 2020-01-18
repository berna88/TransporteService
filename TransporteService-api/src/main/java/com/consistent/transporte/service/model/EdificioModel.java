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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Edificio service. Represents a row in the &quot;Escuela_Edificio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.consistent.transporte.service.model.impl.EdificioModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.consistent.transporte.service.model.impl.EdificioImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Edificio
 * @generated
 */
@ProviderType
public interface EdificioModel extends BaseModel<Edificio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a edificio model instance should use the {@link Edificio} interface instead.
	 */

	/**
	 * Returns the primary key of this edificio.
	 *
	 * @return the primary key of this edificio
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this edificio.
	 *
	 * @param primaryKey the primary key of this edificio
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the edificio ID of this edificio.
	 *
	 * @return the edificio ID of this edificio
	 */
	public int getEdificioId();

	/**
	 * Sets the edificio ID of this edificio.
	 *
	 * @param edificioId the edificio ID of this edificio
	 */
	public void setEdificioId(int edificioId);

	/**
	 * Returns the nombre of this edificio.
	 *
	 * @return the nombre of this edificio
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this edificio.
	 *
	 * @param nombre the nombre of this edificio
	 */
	public void setNombre(String nombre);

}