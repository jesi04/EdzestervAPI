package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.Feladat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeladatRepository extends JpaRepository<Feladat, Integer> {
    @Query(value="SELECT * FROM feladat", nativeQuery = true)
    public List<Feladat> getFeladatok();

}
