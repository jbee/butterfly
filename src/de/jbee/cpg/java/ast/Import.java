package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.DeclarationKeyword;
import de.jbee.cpg.write.Writer;

public final class Import
		implements Node {

	public static final Import IMPLICIT = new Import( "java.lang.*" );

	private final Identifier pkg;

	public Import( final String pkg ) {
		this.pkg = new Identifier( pkg );
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( DeclarationKeyword.IMPORT ).write( pkg ).write( ';' ).assureNewline();
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processImport( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( DeclarationKeyword.IMPORT );
		pkg.transformWith( transformer );
	}

	/*
	 * Für alle unbekannten (nicht aus java.*) Klasse ohne Import kann man das Paket der Klasse
	 * annehmen.
	 */

}
