package text;
/**
 * Liest eine Datei aus und speichert diesen in eine temporäre String Variable ab. Dabei sollte das Dateiformat möglichst egal sein.
 * Dieser String wird dann später von der Klasse Ungender verarbeitet.
 */
public abstract class TextExtractor {
	/* Liest den Textinhalt einer Datei filename aus */
	protected abstract String getText(String filename);
}
