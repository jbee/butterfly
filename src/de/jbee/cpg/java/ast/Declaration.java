package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public class Declaration
		implements Node {

	private final Modifier modifier;
	private final Annotations annotations;
	private final Type type;

	public Declaration( final Annotations annotations, final Modifier modifier, final Type type ) {
		this.modifier = modifier;
		this.annotations = annotations;
		this.type = type;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( annotations ).write( modifier ).assureWhitespace().write( type ).assureWhitespace();
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processDeclaration( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		annotations.transformWith( transformer );
		modifier.transformWith( transformer );
		type.transformWith( transformer );
	}

}
