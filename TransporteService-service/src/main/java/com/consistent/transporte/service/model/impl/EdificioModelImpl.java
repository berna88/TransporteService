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
import com.consistent.transporte.service.model.EdificioModel;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Edificio service. Represents a row in the &quot;Escuela_Edificio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>EdificioModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EdificioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EdificioImpl
 * @generated
 */
@ProviderType
public class EdificioModelImpl
	extends BaseModelImpl<Edificio> implements EdificioModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a edificio model instance should use the <code>Edificio</code> interface instead.
	 */
	public static final String TABLE_NAME = "Escuela_Edificio";

	public static final Object[][] TABLE_COLUMNS = {
		{"edificioId", Types.INTEGER}, {"nombre", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("edificioId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("nombre", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Escuela_Edificio (edificioId INTEGER not null primary key,nombre VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Escuela_Edificio";

	public static final String ORDER_BY_JPQL =
		" ORDER BY edificio.edificioId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Escuela_Edificio.edificioId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public EdificioModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _edificioId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setEdificioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _edificioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Edificio.class;
	}

	@Override
	public String getModelClassName() {
		return Edificio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Edificio, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Edificio, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Edificio, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Edificio)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Edificio, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Edificio, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Edificio)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Edificio, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Edificio, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Edificio>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Edificio.class.getClassLoader(), Edificio.class,
			ModelWrapper.class);

		try {
			Constructor<Edificio> constructor =
				(Constructor<Edificio>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Edificio, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Edificio, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Edificio, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Edificio, Object>>();
		Map<String, BiConsumer<Edificio, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Edificio, ?>>();

		attributeGetterFunctions.put("edificioId", Edificio::getEdificioId);
		attributeSetterBiConsumers.put(
			"edificioId",
			(BiConsumer<Edificio, Integer>)Edificio::setEdificioId);
		attributeGetterFunctions.put("nombre", Edificio::getNombre);
		attributeSetterBiConsumers.put(
			"nombre", (BiConsumer<Edificio, String>)Edificio::setNombre);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public int getEdificioId() {
		return _edificioId;
	}

	@Override
	public void setEdificioId(int edificioId) {
		_edificioId = edificioId;
	}

	@Override
	public String getNombre() {
		if (_nombre == null) {
			return "";
		}
		else {
			return _nombre;
		}
	}

	@Override
	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	@Override
	public Edificio toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Edificio>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EdificioImpl edificioImpl = new EdificioImpl();

		edificioImpl.setEdificioId(getEdificioId());
		edificioImpl.setNombre(getNombre());

		edificioImpl.resetOriginalValues();

		return edificioImpl;
	}

	@Override
	public int compareTo(Edificio edificio) {
		int primaryKey = edificio.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Edificio)) {
			return false;
		}

		Edificio edificio = (Edificio)obj;

		int primaryKey = edificio.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Edificio> toCacheModel() {
		EdificioCacheModel edificioCacheModel = new EdificioCacheModel();

		edificioCacheModel.edificioId = getEdificioId();

		edificioCacheModel.nombre = getNombre();

		String nombre = edificioCacheModel.nombre;

		if ((nombre != null) && (nombre.length() == 0)) {
			edificioCacheModel.nombre = null;
		}

		return edificioCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Edificio, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Edificio, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Edificio, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Edificio)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Edificio, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Edificio, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Edificio, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Edificio)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Edificio>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private int _edificioId;
	private String _nombre;
	private Edificio _escapedModel;

}