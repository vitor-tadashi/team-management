package br.com.team.management.services.bo;

import br.com.team.management.services.model.ProfessionalAllocation;
import br.com.team.management.services.model.TypeAllocation;
import br.com.team.management.services.repository.ProfessionalAllocationRepository;
import br.com.team.management.services.repository.TypeAllocationRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Class responsible for managing business rules related to type allocation
 * @author vitor.tadashi
 *
 */
@Component
public class TypeAllocationBO {

    @Inject
    private TypeAllocationRepository repository;

    public Iterable<TypeAllocation> findAll() {
        return repository.findAll();
    }
}
