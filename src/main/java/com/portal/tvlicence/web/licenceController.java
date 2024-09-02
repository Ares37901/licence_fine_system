package com.portal.tvlicence.web;

import com.portal.tvlicence.entity.Licence;
import com.portal.tvlicence.service.licenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class licenceController {

	Logger logger = LoggerFactory.getLogger(licenceController.class);
	// create a mapping for "/hello"

	@Autowired
	private licenceService liceService;

	@GetMapping("/")
	public String isMain(Model model) {
		return "main";
	}

	@GetMapping("/inputdetails")
	public String isInput(Model model) {
		model.addAttribute("fine", new FineAmountDTO());
		return "inputdetails";
	}


	@GetMapping("/pullinfo")
	public String isFound(Model model) {
		return "pullinfo";
	}

	@PostMapping("/payment")
	public String isPayment(Model model) {
		return "payment";
	}

	@PostMapping("/completed")
	public String isCompleted(Model model) {
		return "completed";
	}



	@PostMapping("/amendAmount")
	public String displayFineForm(@ModelAttribute FineAmountDTO fineAmountDTO, Model model) {
		//logger.info("db output: " + liceService.findAll());
		Licence theLicence = liceService.findByReference(fineAmountDTO.getReference());

		if (theLicence != null) {
			FineAmountDTO populatedDTO = new FineAmountDTO();
			populatedDTO.setReference(theLicence.getReference());
			populatedDTO.setFirstName(theLicence.getFirstName());
			populatedDTO.setLastName(theLicence.getLastName());
			populatedDTO.setHouse(theLicence.getHouse());
			populatedDTO.setStreet(theLicence.getStreet());
			populatedDTO.setCity(theLicence.getCity());
			populatedDTO.setPostcode(theLicence.getPostcode());
			populatedDTO.setFine(theLicence.getFine());
			populatedDTO.setEmail(theLicence.getEmail());
			model.addAttribute("fineAmountDTO", populatedDTO);

			return "pullinfo";
		} else {
			// Handle case where fine is not found
			return "inputdetails";
		}
	}


}








