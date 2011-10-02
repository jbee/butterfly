package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum DeclarationKeyword
		implements JavaKeyword {

	PACKAGE,
	IMPLEMENTS,
	IMPORT,
	EXTENDS,
	SUPER;

	@Override
	public void write( final Writer writer ) {
		Java.write( this, writer );
	}

}
