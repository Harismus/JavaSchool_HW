package service;

import exceptions.ElementAvailableException;
import exceptions.NoElementException;
import model.IResource;
import model.Id;

import java.util.HashMap;
import java.util.Map;

public class DataBaseMap implements IDataBase {
    Map<Id, IResource> base = new HashMap<>();

    @Override
    public Id add(IResource resource) throws ElementAvailableException {
        if (hasElement( resource )) {
            throw new ElementAvailableException( "Такой элемент уже есть в базе" );
        }

        Id id = new Id();
        base.put( id, resource );

        return id;
    }

    @Override
    public void remove(Id id) throws NoElementException {
        if (!hasElement( id )) {
            throw new NoElementException( "Такого элемента нету в базе" );
        }

        base.remove( id );
    }

    @Override
    public boolean hasElement(IResource resource) {
        return base.containsValue( resource );
    }

    @Override
    public boolean hasElement(Id id) {
        return base.containsKey( id );
    }
}
