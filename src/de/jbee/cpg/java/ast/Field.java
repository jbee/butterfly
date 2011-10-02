package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public class Field
		implements Node {

	private final Declaration declaration;
	private final Identifier name;

	public Field( final Declaration declaration, final Identifier name ) {
		this.declaration = declaration;
		this.name = name;
		//TODO initialwert ?? --> später 
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( declaration ).assureWhitespace().write( name );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processField( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		declaration.transformWith( transformer );
		name.transformWith( transformer );
	}

}
