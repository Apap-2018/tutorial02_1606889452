package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else{
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue="0") String a, 
			@RequestParam(value = "b", required = false, defaultValue="0") String b, Model model) {
		
		String hm_value ="";
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		
		int number_a= Integer.parseInt(a);
		int number_b= Integer.parseInt(b);
		
		if ((number_a==1 && number_b==1) || (number_a==0 && number_b==1) || (number_a==1 && number_b==0) || (number_a==0 && number_b==0) ) {
			hm_value = "hm";
			model.addAttribute("hasil",hm_value);
			
		}
		else {
			hm_value= "hm";
			
			for (int i = 1; i < number_a; i++) {
				hm_value += "m";
			}
			
			String kelompok_hm = "";
			
			if(number_b<1) {
				number_b=1;
			}
			for (int i = 0; i < number_b; i++) {
				kelompok_hm += " "+hm_value;
			}
			model.addAttribute("hasil",kelompok_hm);
		}
		return "generator";
	}
}




