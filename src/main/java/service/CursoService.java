package service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import domain.Curso;
import repository.CursoRepository;

@Service
public class CursoService {

	CursoRepository cursoRepository;
	
	 public Curso findOneById(long id){
		 return cursoRepository.findOneById(id);
	 }

	 }
	 public Curso findOneByName(String name){
		 return cursoRepository.findOneByName( name);
	 }
	 public Collection<Curso> findPrerequisitos(long idCurso){
		 return cursoRepository.findPrerequisitos( idCurso );
	 }
	 
	 public Collection<Curso> findAll(){
		 return cursoRepository.findAll();
	 }
	
}
