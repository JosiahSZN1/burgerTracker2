package com.codingdojo.burgertracker1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgertracker1.models.Burger;
import com.codingdojo.burgertracker1.repositories.BurgerRepository;

@Service
public class BurgerService {
	
//	...inject repository interface as dependency
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}

//	Set up BurgerService with necessary methods
	
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}

	public Burger createBurger (Burger burger) {
		return burgerRepository.save(burger);
	}
	
//	Burger Tracker 2 tasks below
	
	// retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    
//    add update method
    
    public Burger updateBurger (Burger burger) {
		return burgerRepository.save(burger);
	}

}
