package repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long>{
	
	@Query("SELECT a FROM Curso a WHERE a.id = ?1")
    Curso findOneById(long id);
	
	@Query("SELECT a FROM Curso a WHERE a.name LIKE '% ?1 %' ")
    Curso findOneByName(String name);
    
    @Query("SELECT a FROM Curso a ")
    Collection<Curso> findAll();
    
    @Query("SELECT b from Curso a INNER JOIN a.prerequisitos b where a.id=?1")
    Collection<Curso> findPrerequisitos(long idCurso);
}
