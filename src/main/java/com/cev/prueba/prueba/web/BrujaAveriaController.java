package com.cev.prueba.prueba.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrujaAveriaController {
	
	@GetMapping("/brujaAveria")
	String dimeNavegador(@RequestHeader(name = "user-agent") String userAgent ) {
		
		return "Estas navegando en :"+userAgent+" Y LO SABES";
		
	}

}
