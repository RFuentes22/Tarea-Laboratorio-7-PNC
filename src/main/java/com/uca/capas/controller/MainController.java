package com.uca.capas.controller;

import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.EstudianteDTO.EstudianteDTO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	//Show students list
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("estudiantes",listEstudiantes());
		mav.setViewName("main");
		//mav.setViewName("main2");
		
		return mav;
		
		 
	}
	
	//Show student by id
	@RequestMapping(value = "/mostrarEstudiante",method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante",estudiante);
		mav.setViewName("estudiante");
		//mav.setViewName("estudiante2");

		return mav;
	}
	
	@PostMapping(value = "/filtrar")
	public ModelAndView filtrar(@RequestParam(value="nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			//estudiantes = estudianteService.filtrarPor(cadena);
			//estudiantes = estudianteService.lastnameStartingWith(cadena);
			estudiantes = estudianteService.findByName(cadena);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("main");

		return mav;
	} 
	
	@PostMapping(value = "/mostrarDTO")
	public ModelAndView mostrarDTO() {
		ModelAndView mav = new ModelAndView();
		List<EstudianteDTO> estudiantes = null;
		try {
			estudiantes = estudianteService.showNamLastDTO();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("showDTO");

		return mav;
	} 
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) throws ParseException {
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName("agregarEstudiante");
			mav.addObject("estudiante ",estudiante);
			//System.out.println(result.getAllErrors());
		}else {
			estudianteService.save(estudiante);
			mav.addObject("estudiantes ",listEstudiantes());
			mav.setViewName("listaEstudiantes");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/borrarEstudiante",method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id) throws ParseException {
		ModelAndView mav = new ModelAndView();
		
		
		estudianteService.delete(id);
		mav.addObject("estudiantes",listEstudiantes());
		mav.setViewName("main");
		
		return mav;
		
	}
	
	@GetMapping("/insertarEstudiante")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante",new Estudiante());
		mav.setViewName("agregarEstudiante");
		
		return mav;
	}
	
	
	public List<Estudiante> listEstudiantes(){
		
		
		List<Estudiante> estudiantes = null;
		
		try {
			//estudiantes = estudianteService.findAllEstudiante();
			estudiantes = estudianteService.showAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return estudiantes;
	}
	 
}
