package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import domain.Curso;
import domain.Alumno;
import domain.Matricula;
import repository.AlumnoRepository;
import repository.CursoRepository;
import repository.MatriculaRepository;

@Service
public class MatriculaService {


	@Autowired
	MatriculaRepository matriculaRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	AlumnoRepository alumnoRepository;
	
	public Collection<Matricula> ListarPorCurso(long CursoId, String semestre){
		return matriculaRepository.findAllByCursoSemestre( CursoId, semestre);
	}
	
	public void ActualizarNota(long idAlumno, long idCurso, String semestre, double nota)
	{
		Matricula Matricula = matriculaRepository.findOneByAlumnoCursoSemestre(idAlumno, idCurso, semestre);
		matriculaRepository.UpdateNota(nota, Matricula.getId());
	}
	
	public boolean AproboSemestre(long idAlumno, long idCurso, String semestre)
	{
		Matricula Matricula = matriculaRepository.findOneByAlumnoCursoSemestre(idAlumno, idCurso, semestre);
		if(Matricula.getNota()>= 11.5){return true;}
		return false;
	}
	public boolean AproboCurso(long idAlumno, long idCurso)
	{
		Matricula Matricula = matriculaRepository.findOneByAlumnoCurso(idAlumno, idCurso);
		if(Matricula.getNota()>= 11.5){return true;}
		return false;
	}
	
	public boolean Matricular (long idAlumno, long idCurso, String semestre){
		Collection<Curso> Prerequisitos= cursoRepository.findPrerequisitos(idCurso);
		for(Curso i: Prerequisitos){
			if(!AproboCurso(idAlumno, i.getId())){
				return false;
			}
		}
		Alumno alumn = alumnoRepository.findOneById(idAlumno);
		Curso cur =cursoRepository.findOneById(idCurso);
		
		Matricula nuevaMatricula=new Matricula(cur, alumn, "2017-01");
		matriculaRepository.save(nuevaMatricula);
		
		return true;
	}
	
	
}
