package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.PrimitiveKeyword;
import de.jbee.cpg.write.Writer;

public final class Primitive
		implements Type {

	private final PrimitiveKeyword primitive;

	public Primitive( final PrimitiveKeyword primitive ) {
		super();
		this.primitive = primitive;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( primitive );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processPrimitive( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( primitive );
	}

}
