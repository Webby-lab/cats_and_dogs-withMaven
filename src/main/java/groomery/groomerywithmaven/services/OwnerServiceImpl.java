package groomery.groomerywithmaven.services;

import groomery.groomerywithmaven.models.Owner;
import groomery.groomerywithmaven.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.getAll();
    }

    @Override
    public Owner getOwnerByName(String name) {
        return ownerRepository.getOwnerByName(name);
    }
}
