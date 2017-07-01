package repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Long>{

	@Query("SELECT a FROM Matricula a WHERE a.id = ?1")
    Matricula findOne(long id);
    
    @Query("SELECT a FROM Matricula a ")
    Collection<Matricula> findAll();
    
    @Query("SELECT a FROM Matricula a WHERE a.curso=?1 and a.semestre=?2 ")
    Collection<Matricula> findAllByCursoSemestre(long CursoId, String semestre);
    
    @Query("UPDATE Matricula SET Nota=?1 WHERE a.id=?2 ")
    void UpdateNota(double nuevaNota, long idMatricula);
    
    @Query("SELECT a FROM Matricula a WHERE a.alumno = ?1 and a.curso = ?2 and a.semestre = ?3 ")
    Matricula findOneByAlumnoCursoSemestre(long idAlumno, long idCurso, String semestre);
    
    @Query("SELECT a FROM Matricula a WHERE a.alumno = ?1 and a.curso = ?2 ")
    Matricula findOneByAlumnoCurso(long idAlumno, long idCurso);
	
}
