package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.Bemutato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BemutatoRepository extends JpaRepository<Bemutato, Integer> {
    @Query(value="SELECT bemutatok.id, bemutatok.feladatid, bemutatok.fajlNeve, bemutatok.fajlTipusa FROM bemutatok", nativeQuery = true)
    public List<Object[]> getBemutatok();
}
