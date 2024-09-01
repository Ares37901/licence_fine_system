package com.portal.tvlicence.web;

import com.portal.tvlicence.entity.Licence;
import com.portal.tvlicence.service.licenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class licenceController {

	// create a mapping for "/hello"

	@GetMapping("/main")
	public String isMain(Model theModel) {

		return "main";
	}

	@GetMapping("/inputdetails")
	public String isInput(Model theModel) {

//		theModel.addAttribute("theDate", new java.util.Date());

		return "inputdetails";
	}

	@PostMapping("/payment")
	public String isPayment(Model theModel) {

//		theModel.addAttribute("theDate", new java.util.Date());

		return "payment";
	}

	@PostMapping("/completed")
	public String isCompleted(Model theModel) {

//		theModel.addAttribute("theDate", new java.util.Date());

		return "completed";
	}





	@Autowired
	private licenceService liceService;

	@PostMapping("/amendAmount")
	public String displayFineForm(@ModelAttribute FineAmountDTO fineAmountDTO, Model model) {
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
			model.addAttribute("fineAmountDTO", populatedDTO);

			return "fine-form";
		} else {
			// Handle case where fine is not found
			return "search";
		}
	}
}








