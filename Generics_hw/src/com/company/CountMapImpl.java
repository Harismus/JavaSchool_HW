package com.company;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map;

    CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(T object) {
        if (map.containsKey( object ))
            map.put( object, map.get( object ) + 1 );
        else
            map.put( object, 1 );
    }

    @Override
    public int getCount(T object) {
        return map.get( object );
    }

    @Override
    public int remove(T object) {
        return map.remove( object );
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        map.putAll( source.toMap() );
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll( map );
    }
}
