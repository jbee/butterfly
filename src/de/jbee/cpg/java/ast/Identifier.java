package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Identifier
		implements Leaf {

	private final String name;

	public Identifier( final String name ) {
		this.name = name;
	}

	protected final boolean contains( final char c ) {
		return name.contains( String.valueOf( c ) );
	}

	public boolean isFullQualified() {
		return contains( '.' );
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( name );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processIdentifier( this );
	}
}
