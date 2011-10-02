package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.DeclarationKeyword;
import de.jbee.cpg.write.Writer;

public final class Package
		implements Node {

	private final Identifier name;

	public Package( final String name ) {
		this.name = new Identifier( name );
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( DeclarationKeyword.PACKAGE ).write( name ).write( ';' ).assureNewline();
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processPackage( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( DeclarationKeyword.PACKAGE );
		name.transformWith( transformer );
	}

}
