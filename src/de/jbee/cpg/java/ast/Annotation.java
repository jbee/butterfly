package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Annotation
		implements Type {

	private final Identifier name;
	private final Parameters parameters;

	public Annotation( final String name, final Parameters parameters ) {
		this.name = new Identifier( name );
		this.parameters = parameters;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( '@' ).write( name ).write( parameters );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processAnnotation( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		name.transformWith( transformer );
		parameters.transformWith( transformer );
	}

}
