package text.txt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import text.TextExtractor;
/**
 * Extrahiert Textinhatle aus einer .txt Datei (theoretisch könnten es auch andere Dateiformate sein,
 * solange sie in irgend einer Weise von einem einfachen Texteditor einlesbar sind).
 */
public class TextReader extends TextExtractor{
	/* Liest eine Datei ein und speichert den ganzen Text in einem sehr langen und großen StringBuffer ab */
	protected String getText(String filename){
		// String filename="txt/gender.txt";
		File file=new File(filename);
		StringBuffer buf=new StringBuffer("");
		try{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			try{
				String line="\0";
				while((line!=null)&&(line.length()>-1)){
					line=br.readLine();
					if(line!=null){
						buf.append(line);
						buf.append("\n");
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
		return buf.toString();
	}
}