package com.trabajo.demo.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.support.SessionStatus;

import com.trabajo.demo.models.entities.Factura;
import com.trabajo.demo.services.IFacturaService;
import jakarta.validation.Valid;

@Controller
public class facturaController {

	@Autowired
	private IFacturaService facturaService;
	
	@RequestMapping(value = "/listarFactura")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de Facturas");
		model.addAttribute("factura",facturaService.findAll());
		return "listarFactura"; 
	}
	
	@RequestMapping(value="/formFactura")
	public String crear(Map<String,Object> model) {
		
		Factura factura= new Factura();
		model.put("factura", factura);
		model.put("titulo","Formulario de facturas");
		return "formFactura";
	}
	
	@RequestMapping(value="/formFactura", method=RequestMethod.POST)
	public String guardar(@Valid  Factura factura,BindingResult result,Model model,SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Facturas");
			return "formFactura";
		}
		
		facturaService.save(factura);
		status.setComplete(); 
		return "redirect:listarFactura";
		
	}

	
	@RequestMapping(value="/formFactura/{id}")
	public String editar(@PathVariable(value="id" )Long id, Map<String,Object> model) {
		
		Factura factura=null;
		
		if(id>0) {
			
			factura=facturaService.findById(id);
		
	
		}else {
			
			return "redirect:/listarFactura";
			
		}
		
		model.put("factura", factura);
		model.put("titulo","Editar Factura");
		return "formFactura";
		
	}
	
	
	
	@RequestMapping(value = "eliminarFactura/{id}")
	public String eliminar(@PathVariable(value="id") Long id)
	{
		if(id>0) {
			facturaService.delete(id);
		}
		return "redirect:/listarFactura";
	}
	}