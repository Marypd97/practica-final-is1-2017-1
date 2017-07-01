package repository;

import java.util.*;

import org.springframework.data.jpa.repository.Query;

import domain.Alumno;

//@Repository
public interface AlumnoRepository extends BaseRepository<Alumno, Long>{
	
	@Query("SELECT a FROM Alumno a WHERE a.id = ?1")
    Alumno findOneById(long id);
	
	@Query("SELECT a FROM Alumno a WHERE a.apellidoPaterno = ?1")
    Alumno findOneByApPat(String ApellidoPaterno);
    
    @Query("SELECT a FROM Alumno a ")
    Collection<Alumno> findAll();
}
