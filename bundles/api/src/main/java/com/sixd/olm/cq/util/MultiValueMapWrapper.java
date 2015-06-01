package com.st.olm.cq.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.sling.api.resource.ValueMap;

/**
 * A MultiValueMapWrapper is backed by a number of ValueMap and will make calls
 * against all of the wrapped ValueMaps in the order they are added.
 * 
 * @author dklco
 */
public class MultiValueMapWrapper implements ValueMap {

	/**
	 * The internal lists of maps to use for property aggregation
	 */
	private List<ValueMap> maps = new ArrayList<ValueMap>();

	/**
	 * Adds a ValueMap to back this MultiValueMap.
	 * 
	 * @param map
	 *            the map to add
	 */
	public void add(ValueMap map) {
		maps.add(map);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		throw new UnsupportedOperationException(
				"Writing operations are not supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		for (ValueMap map : maps) {
			if (map.containsKey(key)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		return values().contains(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<Map.Entry<String, Object>> entrySet() {
		Set<String> keys = new HashSet<String>();
		Set<Map.Entry<String, Object>> entries = new HashSet<Map.Entry<String, Object>>();
		for (ValueMap map : maps) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (!keys.contains(entry.getKey())) {
					entries.add(entry);
					keys.add(entry.getKey());
				}
			}
		}
		return entries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {
		for (ValueMap map : maps) {
			Object value = map.get(key);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		for (ValueMap map : maps) {
			if (!map.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<String> keySet() {
		Set<String> keys = new HashSet<String>();
		for (ValueMap map : maps) {
			keys.addAll(map.keySet());
		}
		return keys;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {
		throw new UnsupportedOperationException(
				"Writing operations are not supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> col) {
		throw new UnsupportedOperationException(
				"Writing operations are not supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object arg0) {
		throw new UnsupportedOperationException(
				"Writing operations are not supported");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return keySet().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<Object> values() {
		Set<String> keys = new HashSet<String>();
		Collection<Object> values = new ArrayList<Object>();
		for (ValueMap map : maps) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (!keys.contains(entry.getKey())) {
					values.add(entry.getValue());
					keys.add(entry.getKey());
				}
			}
		}
		return values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.sling.api.resource.ValueMap#get(java.lang.String,
	 * java.lang.Class)
	 */
	@Override
	public <T> T get(String name, Class<T> type) {
		for (ValueMap map : maps) {
			T value = map.get(name, type);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.sling.api.resource.ValueMap#get(java.lang.String,
	 * java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String name, T defaultValue) {
		if (defaultValue != null) {
			T value = (T) get(name, defaultValue.getClass());
			if (value != null) {
				return value;
			} else {
				return defaultValue;
			}
		} else {
			return (T) get(name);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder toStr = new StringBuilder("MultiValueMapWrapper values={");
		Iterator<Map.Entry<String, Object>> entries = this.entrySet()
				.iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Object> entry = entries.next();
			toStr.append(entry.getKey() + "=" + entry.getValue());
			if (entries.hasNext()) {
				toStr.append(", ");
			}
		}
		toStr.append("}");
		return toStr.toString();
	}

}
