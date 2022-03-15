package com.karitoreyes.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karitoreyes.project.models.Gasto;
import com.karitoreyes.project.services.GastoService;

@Controller
public class GastoController {
	
	@Autowired
	GastoService gastoService;
	
	@RequestMapping(value="/expenses")
	public String index(Model model) {
		List<Gasto> gastos = gastoService.allGastos();
		model.addAttribute("gastos", gastos);
	    return "index.jsp";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createGasto(
		RedirectAttributes redirectAttributes,
		@RequestParam(value="id", required=false) String id,
	    @RequestParam(value="name", required=false) String name,
	    @RequestParam(value="vendor", required=false) String vendor,
	    @RequestParam(value="amount", required=false) String amount,
	    @RequestParam(value="description", required=false) String description) {
		System.out.println(amount);
		if(name == "" || vendor == "" || amount == "" || description == "") {
			redirectAttributes.addFlashAttribute("nullerror", "Todos los campos son obligatorios");
			if(id == "" || id == null) {
				return "redirect:/expenses";
			}else {
				return "redirect:/expenses/edit/" + id;
			}
		}
		try {
			Double amountCast = Double.parseDouble(amount);
			System.out.println("Pass1");
			if(id == "" || id == null) {
				Gasto gasto = new Gasto(name, vendor, amountCast, description);
				gastoService.createGasto(gasto);
				System.out.println("Pass2");
			}else {
				Long idCast = Long.parseLong(id);
				gastoService.updateGasto(idCast, name, vendor, amountCast, description);
				System.out.println("Pass3");
			}
		    return "redirect:/expenses";
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("amountcasterror", "La cantidad debe ser un número");
			if(id == "" || id == null) {
				return "redirect:/expenses";
			}else {
				return "redirect:/expenses/edit/" + id;
			}
		}
	}
	
	@RequestMapping(value="/expenses/edit/{id}")
	public String editGasto(Model model, @PathVariable("id") String id) {
		Long idCast = Long.parseLong(id);
		Gasto gasto = gastoService.findGasto(idCast);
		model.addAttribute("gasto", gasto);
	    return "edit.jsp";
	}
	
	@RequestMapping(value="/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		gastoService.deleteGasto(id);
		return "redirect:/expenses";
	}
	
	@RequestMapping(value="/expenses/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		Gasto gasto = gastoService.findGasto(id);
		if(gasto == null) {
			return "redirect:/expenses";
		}
		model.addAttribute("gasto", gasto);
		return "detail.jsp";
	}
	
}