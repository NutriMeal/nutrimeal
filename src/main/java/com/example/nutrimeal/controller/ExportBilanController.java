package com.example.nutrimeal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutrimeal.service.ExportBilanPdfService;
import com.itextpdf.text.DocumentException;

/**
 * 
 * @author Gaetan Inidjel
 *
 */
@RestController
public class ExportBilanController {

	@Autowired
	ExportBilanPdfService exportBilanPdfService;
	
	@RequestMapping("/bilan/{listeId}/pdf")
	    public void bilanSemainePdf(@PathVariable("listeId") String listeIdAsString, HttpServletRequest request, 
	    		HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=\"Bilan de la semaine.pdf\"");
	        exportBilanPdfService.export(response.getOutputStream(), listeIdAsString);
	    }
	
	
}
