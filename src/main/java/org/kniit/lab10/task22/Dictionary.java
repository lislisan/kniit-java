package org.kniit.lab10.task22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary<K, V> {
    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry> entries;

    public Dictionary() {
        this.entries = new ArrayList<>();
    }

    public Dictionary(int initialCapacity) {
        this.entries = new ArrayList<>(initialCapacity);
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        entries.add(new Entry(key, value));
        return null;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            return null;
        }

        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entries.remove(i);
                return oldValue;
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }

        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }


    public boolean containsValue(V value) {
        for (Entry entry : entries) {
            if (entry.value == null && value == null) {
                return true;
            }
            if (entry.value != null && entry.value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return entries.size();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

    public void clear() {
        entries.clear();
    }

    public V putIfAbsent(K key, V value) {
        if (containsKey(key)) {
            return get(key);
        }
        return put(key, value);
    }

    public V getOrDefault(K key, V defaultValue) {
        V value = get(key);
        return value != null ? value : defaultValue;
    }

    public boolean remove(K key, V value) {
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            if (entry.key.equals(key)) {
                if (entry.value == null && value == null ||
                        entry.value != null && entry.value.equals(value)) {
                    entries.remove(i);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public V replace(K key, V newValue) {
        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = newValue;
                return oldValue;
            }
        }
        return null;
    }


    public V computeIfAbsent(K key, java.util.function.Function<K, V> provider) {
        V value = get(key);
        if (value == null) {
            value = provider.apply(key);
            put(key, value);
        }
        return value;
    }

    public void replaceAll(java.util.function.BiFunction<K, V, V> function) {
        for (Entry entry : entries) {
            entry.value = function.apply(entry.key, entry.value);
        }
    }

    public List<Entry> entries() {
        return new ArrayList<>(entries);
    }
}