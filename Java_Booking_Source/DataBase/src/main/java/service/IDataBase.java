package service;

import exceptions.ElementAvailableException;
import exceptions.NoElementException;
import model.IResource;
import model.Id;

public interface IDataBase {
    /**
     *
     * @param resource
     */
    Id add(IResource resource) throws ElementAvailableException;

    /**
     *
     * @param id
     * @throws NoElementException
     */
    void remove(Id id) throws NoElementException;

    /**
     *
     * @return
     */
    boolean hasElement(IResource resource);
    boolean hasElement(Id id);
}
