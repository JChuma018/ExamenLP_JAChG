package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cibertec.model.HistorialMedico;
import com.cibertec.repository.IHistorialMedicoRepository;

@Controller
public class ProyectoControllerHistorialMedico {
	
	@Autowired
	private IHistorialMedicoRepository repos;
	
	@GetMapping("/formularioHistorial")
	public String mostrarFormularioHistorial() {
		return "formularioHistorial";
	}
	
	@PostMapping("/registrarHistorial")
	public String registrarHistorial(@RequestParam("idPaciente") int idPaciente,
									 @RequestParam("fechaHistorial") String fechaHistorial,
									 @RequestParam("diagnostico") String diagnostico,
									 @RequestParam("alergias") String alergias,
									 @RequestParam("tratamiento") String tratamiento,
									 @RequestParam("medicoAtendio") String medicoAtendio,
									 Model model) {
		try {
			HistorialMedico hm = new HistorialMedico();
			hm.setIdPaciente(idPaciente);
			hm.setFechaHistorial(fechaHistorial);
			hm.setDiagnostico(diagnostico);
			hm.setAlergias(alergias);
			hm.setTratamiento(tratamiento);
			hm.setMedicoAtendio(medicoAtendio);
			
			hm = repos.save(hm);
			model.addAttribute("name", hm);
			return "redirect:/listarHistorial";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error al registrar el historial medico: " + e.getMessage());
			return "formularioHistorial";
		}
	}
	
	@GetMapping("/listarHistorial")
	public String listHistorial(Model model) {
		model.addAttribute("ltsHistorial", repos.findAll());
		return "listadoHistorial";
	}
	
}
