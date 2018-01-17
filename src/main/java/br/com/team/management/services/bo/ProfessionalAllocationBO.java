package br.com.team.management.services.bo;

import br.com.team.management.services.exceptions.BusinessException;
import br.com.team.management.services.model.ProfessionalAllocation;
import br.com.team.management.services.repository.ProfessionalAllocationRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Class responsible for managing business rules related to professional allocation
 * @author vitor.tadashi
 *
 */
@Component
public class ProfessionalAllocationBO {

    @Inject
    private ProfessionalAllocationRepository repository;

    public Iterable<ProfessionalAllocation> findAll() {
        return repository.findAll();
    }

    public ProfessionalAllocation findOne(Integer id) {
        return repository.findOne(id);
    }

    public ProfessionalAllocation save(ProfessionalAllocation professionalAllocation) {
        return repository.save(professionalAllocation);
    }

    public ProfessionalAllocation update(ProfessionalAllocation professionalAllocation) throws BusinessException {
        if (repository.exists(professionalAllocation.getId())) {
            professionalAllocation = repository.save(professionalAllocation);
            return professionalAllocation;
        } else {
            throw new BusinessException("Professional allocation not found.");
        }
    }
}
