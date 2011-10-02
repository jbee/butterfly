package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Annotations
		extends Nodes<Annotation> {

	public Annotations( final Annotation... annotations ) {
		super( annotations );
	}

	@Override
	public void write( final Writer writer ) {
		writeChildren( writer, Delimiter.LINE_FEED );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processAnnotations( this );
	}

}
