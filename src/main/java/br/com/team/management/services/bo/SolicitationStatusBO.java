package br.com.team.management.services.bo;

import br.com.team.management.services.model.SolicitationStatus;
import br.com.team.management.services.repository.SolicitationStatusRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Class responsible for managing business rules related to solicitation status
 * @author vitor.tadashi
 *
 */
@Component
public class SolicitationStatusBO {

    @Inject
    private SolicitationStatusRepository repository;

    public Iterable<SolicitationStatus> findAll() {
        return repository.findAll();
    }
}
