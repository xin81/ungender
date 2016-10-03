package text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import text.pdf.PDFReader;
// import text.pdf.PdfExtractor;
import text.txt.TextReader;

public class Ungender {	
	public String getUngenderedText(String filename){
		// TODO Auto-generated method stub
		String text="";
		if(filename.endsWith(".pdf")==true){
			TextExtractor pdf=new PDFReader();
			text=pdf.getText(filename);
		}else{
			TextExtractor txt=new TextReader();
			text=txt.getText(filename);
		}
		
		/* entfernt gegenderte Endungen bzw. Formulieren
		 * Dieser Bereich muss eventuell erweitertet werden, wenn noch nicht alle Fälle ausschöpfend abgedeckt sind
		 */
		String newText=(text.replace("*", "").replace("_", "").replace("/-", ""));
		newText=(newText.replace("(innen)", ""));
		newText=(newText.replace("Innen", "innen"));
		newText=(newText.replace("innen und ", ""));
		newText=(newText.replace("innen oder ", ""));
		newText=(newText.replace("rinnen", "r"));
		newText=(newText.replace("ginnen", "gen"));
		newText=(newText.replace("tinnen", "ten"));
		
		/* Weitere Korrekturen mit Hilfe der Resource-Datei removable.txt
		 * removable.txt enthält weitgehnd alle bekannten Wörter und Ausdrücke, die erfahrungsgemäß schon gegendert
		 * wurden
		 */
		String resourcename="resource/removable.txt";
		File resource=new File(resourcename);
		try{
			FileReader fr=new FileReader(resource);
			BufferedReader br=new BufferedReader(fr);
			try{
				String line="\0";
				while((line!=null)&&(line.length()>-1)){
					line=br.readLine();
					if(line!=null){
						String[] token=line.split(";");
						newText=newText.replace(token[0], token[1]);
					}
				}				
				br.close();
				fr.close();
			}catch(IOException e){
				System.err.println(e.getMessage());
			}
		}catch(FileNotFoundException e){
			System.err.println(e.getMessage());
		}
		return newText;	
	}
}