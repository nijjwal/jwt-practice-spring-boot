package com.nijjwal.jwtpractice.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("/")
	public String home(Principal principal) {
		return "Welcome home " + principal.getName();
	}
	
	
	@PreAuthorize("hasAnyAuthority('SCOPE_user','SCOPE_admin') ")
	@GetMapping("/user")
	public String userPage() {
		return "This is visible for both user and admin!";
	}
	
	@PreAuthorize("hasAuthority('SCOPE_admin')")
	@GetMapping("/admin")
	public String adminPage() {
		return "This page is visible only for admin!";
	}
	
	
	
}
