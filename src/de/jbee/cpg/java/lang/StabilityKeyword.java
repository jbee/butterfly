package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum StabilityKeyword
		implements JavaKeyword {

	FINAL,
	VOLATILE,
	ABSTRACT;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}

}
