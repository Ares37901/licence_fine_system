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
public class FineWebController {

    @Autowired
    private licenceService liceService;

    @PostMapping("/amendAmount")
    public String displayFineForm(@ModelAttribute FineAmountDTO fineAmountDTO, Model model) {
        Licence theLicence = liceService.findByReference(fineAmountDTO.getReference());

        if (theLicence != null) {
            FineAmountDTO populatedDTO = new FineAmountDTO();
            populatedDTO.setReference(theLicence.getReference());
            populatedDTO.setAmount(theLicence.getFine());
            model.addAttribute("fineAmountDTO", populatedDTO);

            return "fine-form";
        } else {
            // Handle case where fine is not found
            return "search";
        }
    }

    @GetMapping("/confirmation")
    public String displaySuccessPage(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "success";
    }

    @GetMapping("/search")
    public String searchByReference(Model model) {
        model.addAttribute("fine", new FineAmountDTO());
        return "search";
    }

    @PostMapping("/updateAmount")
    public String updateAmount(@ModelAttribute FineAmountDTO fineAmountDTO) {

        String theReference = fineAmountDTO.getReference();
        double theAmount = fineAmountDTO.getAmount();


        // Check if amount and reference is set to something acceptable
        // i.e. Amount is not zero, and Reference is not an empty string or null
        if((theAmount <= 0) || theReference.trim().isEmpty()) {
            return "redirect:/amendAmount";
        }
        else {
            // Update the specific column of the entity
            Licence theLicence = liceService.findByReference(theReference);
            double balance = theLicence.getFine();
            balance = balance - fineAmountDTO.getAmount();
            theLicence.setFine(balance);

            // Save the updated entity
            liceService.save(theLicence);

            // Redirect to a success page or handle accordingly
            return "redirect:/confirmation";

        }
    }
}