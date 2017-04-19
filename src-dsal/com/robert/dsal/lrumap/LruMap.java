package com.robert.dsal.lrumap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LruMap<K, V> {
	private Map<K, V> maps = new HashMap<K, V>();
	private List<K> keys = new LinkedList<K>();

	private int limit;

	public LruMap(int limit) {
		this.limit = limit;
	}

	public synchronized void put(K key, V value) {
		if (keys.size() >= limit) {
			maps.remove(keys.get(0));
			keys.remove(0);
		}

		maps.put(key, value);

		if (keys.contains(key)) {
			keys.remove(key);
		}
		keys.add(key);
	}

	public synchronized V get(K key) {
		if (keys.contains(key)) {
			keys.remove(key);
			keys.add(key);
		}

		return maps.get(key);
	}
}
