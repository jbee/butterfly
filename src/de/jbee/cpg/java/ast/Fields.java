package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Fields
		extends Nodes<Field> {

	public Fields( final Field... fields ) {
		super( fields );
	}

	@Override
	public void write( final Writer writer ) {
		writeChildren( writer, Delimiter.LINE_FEED );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processFields( this );
	}

	// Konstanten und attribute
}
