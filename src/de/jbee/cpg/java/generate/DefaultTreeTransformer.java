package de.jbee.cpg.java.generate;

public class DefaultTreeTransformer {

	/*
	 * Ausgabe:
	 * 
	 * wie wird was formatiert - whitespace
	 * 
	 * Wie kann man die Reihenfolge bestimmen ? Konstanten/Felder/Konstruktoren/Methoden
	 * (statisches)
	 * 
	 * Untersortierung: Sichtbarkeit, Alphabetisch, Caller (private zu public)
	 */

	/*
	 * Normalerweise traversiert man den Quellbaum mehrfach um die verschiedenen Aspekte zu
	 * übersetzen und in den Zielbaum einzufügen.
	 * 
	 * absteigen - aufsteigen als action-klasse ?!
	 * 
	 * Beim traversieren:
	 * 
	 * - Wann soll weiter abgestiegen werden ?
	 * 
	 * Etwa: packet/imports -> skip parent
	 * 
	 * - Wann soll die Verarbeitung abgebrochen werden -> Wo gehts weiter ? Ebene/Klasse/Aufsteigen
	 * 
	 * Etwa: nicht absteigen bei: Annotationen, inneren Typen, methoden feldern -> die
	 * collection-nodes ansich - oder aber: wo will ich hin explizit angeben ? -> Würde sich eher
	 * aus den Transformationen ergeben!
	 * 
	 * 
	 * Vielleicht als Action-Map lösen:
	 * 
	 * Wenn man an knoten-typ X kommt, führe Action Y aus, wie: Absteigen, Verarbeiten etc. Bekannt
	 * müssten sein: Hierachie, X
	 * 
	 * Dann könnte man sagen: Ich melde an für: hierachie.within(Method.class).doAction(...);
	 * 
	 * Wo man etwas tun will könnte sich so impliziert ergeben, da der Scope in dem "within" steckt
	 * -> klar use-case orierntiert
	 * 
	 * Etwa: Beim besuchen eines Method-Knotens wird ein MethodBuilder erzeugt, der sich für die
	 * Teiltypen "registiert" (oder wrapper?) Dieser kann dann die Teile neu
	 * zusammensetzen/transformaieren
	 * 
	 * Was man als Filter + Transformation können will:
	 * 
	 * - Alles im Paket verschieben (imports + paket entsprechend transformieren) - Aus Signatur ein
	 * MethodenTemplate ausfüllen
	 */
}
