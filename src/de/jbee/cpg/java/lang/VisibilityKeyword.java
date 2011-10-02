package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum VisibilityKeyword
		implements JavaKeyword {

	PUBLIC,
	PRIVATE,
	PROTECTED,
	DEFAULT;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}

}
