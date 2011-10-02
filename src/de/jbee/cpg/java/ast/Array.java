package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Array
		implements Type {

	private final Type type;

	public Array( final Type type ) {
		super();
		this.type = type;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( type ).write( "[]" );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processArray( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		type.transformWith( transformer );
	}

}
