package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Owner;

import java.util.List;

public interface OwnerService {
    void save(Owner owner);
    List<Owner> getAll();
    Owner getOwnerByName(String name);
}
