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
    public List<Object[]> getFelhasznalok();

    @Query(value="SELECT felhasznalo.id, felhasznalo.nev, cel.elerendoSuly, cel.megjegyzes AS celMegjegyzes FROM felhasznalo INNER JOIN cel ON felhasznalo.id=cel.felhasznaloid; "
            , nativeQuery = true)
    public List<Object[]> getEdzestervek();

    @Query(value="SELECT felhasznalo.id, feladat.izomcsoport FROM felhasznalo INNER JOIN feladat ON felhasznalo.id=feladat.id; "
            , nativeQuery = true)
    public List<Object[]> edzesnapok(int felhasznaloid);
}
