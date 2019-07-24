package Mutuelle.repository;

import Mutuelle.model.Adherent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

    Optional<Adherent> findById(Long adherentId);


}
