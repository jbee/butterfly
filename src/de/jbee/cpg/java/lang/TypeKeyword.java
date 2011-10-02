package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum TypeKeyword
		implements JavaKeyword {

	ENUM,
	INTERFACE,
	CLASS;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}
}
