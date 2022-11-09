package com.sistema.asesoria;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class IndexController {
    
    @GetMapping(path = {"/", "", "index"})
	public String index() {
		return "index";
	}

    @PostMapping(path = {"/","","formularioprincipal"})
	public String formularioprincipal(){
		return "formularioprincipal";
	}

}
