package groomery.groomerywithmaven.repositories;

import groomery.groomerywithmaven.models.Owner;

import java.util.List;

public interface OwnerRepository {
    List<Owner> getAll();
    Owner getOwnerByDogId(int id);
    void save(Owner owner);
    Owner getOwnerByName(String name);
}
