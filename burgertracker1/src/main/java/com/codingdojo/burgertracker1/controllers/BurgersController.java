package com.codingdojo.burgertracker1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.burgertracker1.models.Burger;
import com.codingdojo.burgertracker1.services.BurgerService;

@Controller
public class BurgersController {
	@Autowired BurgerService burgerService;
	
//	Create route in controller to render index.jsp
	
	@GetMapping("/")
	
//	Add @ModelAttribute annotation and associated syntax to render route, to bind an empty Burger object to JSP form to capture user input
	
	public String index(
			Model model,
			@ModelAttribute("burger") Burger burger) {
		
//		...retrieve all records from database...
		
		List<Burger> burgers = burgerService.allBurgers();
		
//		...and render them on the page...
		
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
//	Add POST route to process form and add new burger to database...
	
	@PostMapping("/")
	public String create(
			
//			...using @ModelAttribute annotation to receive filled Burger object
			
//			...handle validations
			
		Model model,
		@Valid @ModelAttribute("burger") Burger burger,
		BindingResult result) {
		if (result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers", burgers);
			return "index.jsp";
		} else {
			burgerService.createBurger(burger);
			
//			POST route redirects to render route after creating new burger
			
			return "redirect:/";
		}
	}
	
//	Burger Tracker 2 tasks below
	
//	add a route to generate edit.jsp page
	
	@RequestMapping("/burgers/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.findBurger(id);
        model.addAttribute("burger", burger);
        return "edit.jsp";
    }
    
//	add PUT route in controller that will update burger
	
    @RequestMapping(value="/burgers/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }
}
