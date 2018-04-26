package com.example.nutrimeal.service;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nutrimeal.repository.RecetteRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class ExportBilanPdfService {

	
	@Autowired 
	RecetteRepository recetteRepository;

	@Autowired
	CalculService calculService;
	
	public void export(OutputStream outputStream, String listeIdAsString) 
			throws com.itextpdf.text.DocumentException  {
		
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		
		document.open();

		Double totalVitamines = calculService.calculVitaminesParRecette(listeIdAsString);
		Double totalMineraux = calculService.calculMinerauxParRecette(listeIdAsString);
		
		
		document.add(new Paragraph("Le bilan en vitamines est de " + totalVitamines ));	
		document.add(new Paragraph("Le bilan en mineraux est de " + totalMineraux));
		
		document.close();
	}
	
}
