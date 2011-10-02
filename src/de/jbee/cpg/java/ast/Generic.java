package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Generic
		implements Type {

	private final Identifier name;
	private final Identifier superBound;
	private final Identifier extendsBound;
	private final Generics generics;

	public Generic( final String name, final Generics generics ) {
		this.name = new Identifier( name );
		this.generics = generics;
		this.superBound = null;
		this.extendsBound = null;
		//TODO super und extends -> Eigene Typen, die von Generic abgeleitet werden ?
	}

	public boolean isGeneric() {
		return generics != null;
	}

	public final boolean isPrimitive() {
		return false; // wie ? 
	}

	public final boolean isArray() {
		return false; // wie ? 
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( name );
		if ( isGeneric() ) {
			writer.write( generics );
		}
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processGeneric( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		name.transformWith( transformer );
		generics.transformWith( transformer );
	}
}
