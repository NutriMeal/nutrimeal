package com.example.nutrimeal.service;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nutrimeal.model.Recette;
import com.example.nutrimeal.model.RecetteIngredient;
import com.example.nutrimeal.repository.MethodesPratiquesRepository;
import com.example.nutrimeal.repository.RecetteRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ExportBilanPdfService {

	private final String UNITE = "unite";
	
	@Autowired 
	RecetteRepository recetteRepository;
	@Autowired
	MethodesPratiquesRepository methodesPratiquesRepository;
	@Autowired
	CalculService calculService;
	
	public void export(OutputStream outputStream, String listeIdAsString) 
			throws com.itextpdf.text.DocumentException  {
		
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		
		List<Long> listeId = methodesPratiquesRepository.convertirStringIdEnListeLong(listeIdAsString);
		
		document.open();

		for (Long id : listeId) {
		
			PdfPCell cell;
			PdfPTable table = new PdfPTable(4);
			
			Recette recette = recetteRepository.getOne(id);
			
			cell = new PdfPCell(new Phrase("Composition de la recette : " + recette.getNomRecette()));
		    cell.setColspan(4);
			cell.setHorizontalAlignment(1);
			cell.setBackgroundColor(BaseColor.GREEN);
		    table.addCell(cell);
		    
		    String[] entetes = {"Ingredients", "Quantite", "Vitamines", "Mineraux"};
		    
		    for(String entete : entetes) {
		    	cell = new PdfPCell(new Phrase(entete));
		    	cell.setBackgroundColor(BaseColor.CYAN);
			    table.addCell(cell);
		    }
		    
			

		    
		    Double totalVitaminesRecette = 0d;
		    Double totalMinerauxRecette = 0d;
		    
		    
		    
			for(RecetteIngredient ingredient : recette.getRecetteIngredients()) {
			
				Double vitaminesParIngredient = ingredient.getIngredients().getVitamines();
				Double minerauxParIngredient = ingredient.getIngredients().getMineraux();
				
				totalVitaminesRecette += vitaminesParIngredient*ingredient.getQuantite()/1000;
				totalMinerauxRecette += minerauxParIngredient*ingredient.getQuantite()/1000;
				
				table.addCell(ingredient.getIngredients().getLibelle());
				
				if(UNITE.equals(ingredient.getIngredients().getUniteMesure())) {
					table.addCell(ingredient.getQuantite().toString());
				}else {
					table.addCell(ingredient.getQuantite().toString()
							+ " " + ingredient.getIngredients().getUniteMesure());
				}
				
				table.addCell(vitaminesParIngredient.toString() + " mg ");
				table.addCell(minerauxParIngredient.toString() + " mg " );
			}
			
			totalVitaminesRecette = methodesPratiquesRepository.
					deuxChiffresSignificatifs(totalVitaminesRecette);
			totalMinerauxRecette = methodesPratiquesRepository.
					deuxChiffresSignificatifs(totalMinerauxRecette);

			table.addCell("Total de la recette");
			table.addCell("");
			table.addCell(totalVitaminesRecette.toString() + " g ");
			table.addCell(totalMinerauxRecette.toString() + " g ");
			table.setSpacingAfter(50);
			
			document.add(table);
			
			
		}
		
		Double totalVitamines = calculService.calculVitaminesParRecette(listeIdAsString);
		Double totalMineraux = calculService.calculMinerauxParRecette(listeIdAsString);
		
		
		
		document.add(new Paragraph("Le bilan en vitamines est de " + methodesPratiquesRepository.
				deuxChiffresSignificatifs(totalVitamines/1000) ));	
		document.add(new Paragraph("Le bilan en mineraux est de " + methodesPratiquesRepository.
				deuxChiffresSignificatifs(totalMineraux/1000)));
		
		document.close();
	}
	
}
