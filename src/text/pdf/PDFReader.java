package text.pdf;

import java.io.IOException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import text.TextExtractor;

/**
 * Extrahiert Textinhatle aus einer .pdf Datei.
 */
public class PDFReader extends TextExtractor {
	@Override
	protected String getText(String filename) {
		// TODO Auto-generated method stub
		StringBuilder builder=new StringBuilder("");
		try{
			PdfReader reader=new PdfReader(filename);//new PdfTextExtractor(filename);
			for(int p = 1; p < reader.getNumberOfPages(); p++){
				String text=PdfTextExtractor.getTextFromPage(reader, p);
				builder.append(text);
			}
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
		return builder.toString();
	}
}
