package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.model.Paciente;
import com.cibertec.repository.IPacienteRepository;

@Controller
public class ProyectoControllerPaciente {
	
	@Autowired
	private IPacienteRepository repos;
	
	@GetMapping("/formularioPaciente")
	public String mostrarFormularioPaciente() {
		return "formularioPaciente";
	}
	
	@PostMapping("/registrarPaciente")
	public String registrarPaciente(@RequestParam("nombre") String nombre,
									@RequestParam("apellido") String apellido,
									@RequestParam("direccion") String direccion,
									@RequestParam("telefono") String telefono,
									@RequestParam("correo") String correo,
									@RequestParam("fechaRegistro") String fechaRegistro,
									Model model){
	try {
		Paciente p = new Paciente();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDireccion(direccion);
		p.setTelefono(telefono);
		p.setCorreo(correo);
		p.setFechaRegistro(fechaRegistro);
		
		p = repos.save(p);
		model.addAttribute("name", p);
		return "redirect:/listarPaciente";
	} catch (Exception e) {
		model.addAttribute("errorMessage", "Error al registrar al paciente: " + e.getMessage());
		return "formularioPaciente";
		}
	}
	
	@GetMapping("/listarPaciente")
	public String listPaciente(Model model) {
		model.addAttribute("ltsPaciente", repos.findAll());
		return "listadoPaciente";
	}
	
	@GetMapping("/home")
	public String Inicio(){
		return "index";
	}
	
}
