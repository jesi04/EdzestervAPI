package hu.EdzestervAPI.repositories;

import hu.EdzestervAPI.domain.JavasoltEdzes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface JavasoltEdzesRepository extends JpaRepository<JavasoltEdzes, Integer> {
    @Query(value="SELECT * FROM javasolt_edzes;"
            , nativeQuery = true)
    public List<JavasoltEdzes> getJavasoltak();
}
