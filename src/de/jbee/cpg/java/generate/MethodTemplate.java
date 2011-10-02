package de.jbee.cpg.java.generate;

/**
 * Ein Template wird als String etwa aus einer Datei geladen. Variablen darin werden mit
 * <code>$name</code> dargestellt. Über <code>$[suchen>ersetzen]name</code> können die beiden
 * Regulären Ausdrücke angegeben werden, welche auf den bisherigen Namen angewand werden.
 * 
 * Beispiel: Ein Getter/Setter Template wäre dann
 * 
 * <pre>
 * 
 * 
 * public $type get$Property() {
 * 	return this.$property;
 * }
 * 
 * public void set$Property( $type $property ) {
 * 	this.$property = $property;
 * }
 * </pre>
 * 
 * @author Jan Bernitt (jan.bernitt@gmx.de) (initial creation)
 */
public interface MethodTemplate {

}
