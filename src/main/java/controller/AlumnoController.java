package controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AlumnoService;
import java.util.Collection;

import domain.Alumno;
import domain.Person;

@Controller
public class AlumnoController {

	@Autowired(required=true)
	AlumnoService alumnoService;

	
	@RequestMapping(value ="/alumnos", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Alumno> showAlumnos(){
        return alumnoService.showAlumnos();
    }
	
	@RequestMapping(value ="/alumno", method = RequestMethod.GET)
    @ResponseBody
    public Alumno showAlumno(@RequestParam long id){
        return alumnoService.showAlumnoId(id);
    }
	@RequestMapping(value ="/hola", method = RequestMethod.GET)
    @ResponseBody
    public String showHola(){
        return "hola mundo";
    }
	
	
	
}
