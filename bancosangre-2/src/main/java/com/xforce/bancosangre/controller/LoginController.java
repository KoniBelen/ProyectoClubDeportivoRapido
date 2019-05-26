package com.xforce.bancosangre.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash,Authentication authentication) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			System.out.println("Pase 1");
			return "redirect:/home";
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
			System.out.println("Pase 2");
		}
		
		if(logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
			System.out.println("Pase 3");
		}
		if(authentication != null) {
			return "redirect:/listadonante";	
		}
		
		System.out.println("Pase 4");
		
		return "login";
	}
	@GetMapping(value = "") 
	public String validate() {
		
		return "redirect:/home";
	}
	@GetMapping(value = "/home") 
	public String home() {
		
		return "home";
	}
}
