package com.vti.entity;

public class Staff<K, V> extends MyMap<K, V> {

	public Staff(K key, V value) {
		super(key, value);
	}
	
	public V getValue() {
		return value;
	}

	@Override
	public K getKey() {
		return key;
	}

}
