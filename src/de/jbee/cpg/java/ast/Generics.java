package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Generics
		extends Nodes<Generic> {

	public Generics( final Generic... generics ) {
		super( generics );
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( '<' );
		writeChildren( writer, Delimiter.COMMA );
		writer.write( '>' );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processGenerics( this );
	}

}
