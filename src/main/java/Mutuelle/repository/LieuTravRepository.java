package Mutuelle.repository;


import Mutuelle.model.Adherent;
import Mutuelle.model.LieuTrav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LieuTravRepository extends JpaRepository<LieuTrav, Integer> {


}
