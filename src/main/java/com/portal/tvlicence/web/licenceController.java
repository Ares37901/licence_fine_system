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

	@GetMapping("/_error")
	public String isError(Model model) {
		return "_error";
	}

	@GetMapping("/_error2")
	public String isError2(Model model) {

		return "_error2";
	}

	@GetMapping("/inputdetails")
	public String isInput(Model model) {
		model.addAttribute("fineAmountDTO", new FineAmountDTO());
		return "inputdetails";
	}

	@PostMapping("/payment")
	public String isPayment(@ModelAttribute("fineAmountDTO") FineAmountDTO fineAmountDTO, Model model) {

		logger.info("object output: " + fineAmountDTO.getReference() + fineAmountDTO.getCity() + fineAmountDTO.getFine());
		model.addAttribute("fineAmountDTO", fineAmountDTO);
		return "payment";
	}

	@GetMapping("/success")
	public String isCompleted(Model model) {
		return "success";
	}



	@PostMapping("/amendAmount")
	public String displayFineForm(@ModelAttribute("fineAmountDTO") FineAmountDTO fineAmountDTO, Model model) {
		logger.info("object output: " + fineAmountDTO.getReference() + fineAmountDTO.getCity() + fineAmountDTO.getFine());

		Licence theLicence = null;
		try {
			theLicence = liceService.findByReference(fineAmountDTO.getReference());
		}
		catch (Exception e){
			logger.info(String.valueOf(e));

			return "_error2";
		}

		if (theLicence != null) {
			if(
					theLicence.getFirstName().equals(fineAmountDTO.getFirstName()) &&
					theLicence.getLastName().equals(fineAmountDTO.getLastName()) &&
					theLicence.getHouse().equals(fineAmountDTO.getHouse()) &&
					theLicence.getStreet().equals(fineAmountDTO.getStreet()) &&
					theLicence.getCity().equals(fineAmountDTO.getCity()) &&
					theLicence.getPostcode().equals(fineAmountDTO.getPostcode())
			) {
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
			}
			else {
				return "_error";
			}

		} else {
			// Handle case where fine is not found
			return "_error2";
		}
	}


	@PostMapping("/updateAmount")
	public String updateAmount(@ModelAttribute("fineAmountDTO") FineAmountDTO fineAmountDTO, Model model) {
			model.addAttribute("fineAmountDTO", fineAmountDTO);
		String theReference = fineAmountDTO.getReference();
		double theAmount = fineAmountDTO.getFine();
		logger.info("object output: " + fineAmountDTO.getReference() + fineAmountDTO.getCity() + fineAmountDTO.getFine() + theAmount);


		// Check if amount and reference is set to something acceptable
		// i.e. Amount is not zero, and Reference is not an empty string or null
		if(theAmount <= 0) {
			return "redirect:/_error";
		} else if(theReference.trim().isEmpty()) {
			return "redirect:/_error2";
		}
		else {
			// Update the specific column of the entity
			Licence theFine = liceService.findByReference(theReference);
			double balance = theFine.getFine();
			balance = balance - fineAmountDTO.getFine();
			theFine.setFine(balance);

			// Save the updated entity
			liceService.save(theFine);

			// Redirect to a success page or handle accordingly
			return "redirect:/success";

		}
	}


}








