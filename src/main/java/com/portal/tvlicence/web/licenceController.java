package com.portal.tvlicence.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class licenceController {

	// create a mapping for "/hello"

	@GetMapping("/hello")
	public String sayHello(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "helloworld";
	}

	@GetMapping("/main")
	public String isMain(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "main";
	}

	@GetMapping("/inputdetails")
	public String isInput(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "inputdetails";
	}

	@PostMapping("/payment")
	public String isPayment(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "payment";
	}

	@PostMapping("/completed")
	public String isCompleted(Model theModel) {

		theModel.addAttribute("theDate", new java.util.Date());

		return "completed";
	}
}








