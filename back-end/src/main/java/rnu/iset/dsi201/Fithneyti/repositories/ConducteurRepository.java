package rnu.iset.dsi201.Fithneyti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rnu.iset.dsi201.Fithneyti.entities.Conducteur;
@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur,Integer>{

}
