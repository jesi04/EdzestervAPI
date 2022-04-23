package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.Feladat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeladatRepository extends JpaRepository<Feladat, Integer> {
    @Query(value="SELECT feladat.id, feladat.nev, feladat.elegetettKcal, feladat.leiras, feladat.megjegyzes, feladat.izomcsoport FROM feladat", nativeQuery = true)
    public List<Object[]> getFeladatok();

    @Query(value="SELECT feladat.id, feladat.nev, feladat.leiras, feladat.megjegyzes FROM feladat", nativeQuery = true)
    public List<Object[]> edzesnapFeladatok(int edzesnapFeladatId);
}
