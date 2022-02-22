package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.Cel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CelRepository extends JpaRepository<Cel, Integer> {
    @Query(value="SELECT cel.id, cel.felhasznaloid, cel.elerendoSuly, cel.kezdes, cel.vege, cel.megjegyzes FROM cel", nativeQuery = true)
    public List<Object[]> getCelok();
}
