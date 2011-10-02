package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum ModifierKeyword
		implements JavaKeyword {

	SYNCHRONIZED,
	TRANSIENT,
	STATIC,
	STRICTFP,
	CONST,
	NATIVE;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}

}
