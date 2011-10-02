package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum FlowControlKeyword
		implements JavaKeyword {

	CONTINUE,
	NEW,
	GOTO,
	BREAK,
	THROW,
	THROWS,
	INSTANCEOF

	;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}

}
