package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.Felhasznalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FelhasznaloRepository extends JpaRepository<Felhasznalo, Integer> {
    @Query(value="SELECT felhasznalo.id, felhasznalo.email, felhasznalo.nev, felhasznalo.szuldat, felhasznalo.magassag, felhasznalo.megjegyzes FROM felhasznalo;"
            , nativeQuery = true)
    public List<Felhasznalo> getFelhasznalok();

}
