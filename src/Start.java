import text.Ungender;

/** 
 * Genervt von der Gengersprache? Dann kopieren Sie einen gegenderten Text, speichern ihn in eine Datei ab und übergeben dann den Namen dieser Datei als Parameter für dieses Programm.
 * Soweit wie möglich habe ich versucht möglichst viele Fälle der Gendersprache abzufangen. Natürlich ist dies nur eingeschränkt möglich. Wollen Sie noch viel mehr gegenderte Begriffe normalisieren,
 * dann fügen Sie Ihre zusätzlich gewünschten Begriffe in die Datei removable.txt. Gehen Sie dabei so vor wie in der Datei schon vorgegeben:
 * removable.txt: ["ursprünglicher Begriff";"geänderter Begriff"]
 * Beispiel: java Ungender removable.txt
 * 
 * Verwenden Sie dieses Program am besten nur relevativ kurze oder mittellange Texte (d. h. im Umfang von ca. 2 - 5 Minuten Lesezeit).
 * Längere Texte könnten für dieses Programm kritisch sein (je nach Speichergröße)
 * 
 * @author Nguyen V. Tan
 */
public class Start {
	private static String help(){
		return "Usage: java -cp ungender.jar Start [FILE]\nFILE\tDateiname (z. B. datei.txt)\nhelp\tgibt diesen Hilfetextaus";
	}
	
	/** Versucht möglichst viele gegenderte Begriffe bzw. Formulieren zu entfernen oder wenigstens zu vereinfachen */
	public static void main(String[] args) {
		if(args.length > 0){
			if(args[0].compareTo("help")==0){
				System.out.println(help());
			}else{
				Ungender ungender=new Ungender();
				String filename=args[0];
				String newText=ungender.getUngenderedText(filename);
				System.out.println(newText);
			}
		}else{
			System.err.println("Geben Sie eine Datei (inklusive Pfadname; also p1/p2/p3/gender.file.txt) an, welche einen gegenderten Text enthält!");
			System.err.println(help());
			System.exit(1);
		}
	}
}
