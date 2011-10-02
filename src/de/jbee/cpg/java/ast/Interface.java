package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.DeclarationKeyword;
import de.jbee.cpg.java.lang.TypeKeyword;
import de.jbee.cpg.write.Writer;

public final class Interface
		implements Type {

	private final Generic type;
	private final Generics superInterfaces;

	public Interface( final Generic type, final Generics superInterfaces ) {
		this.type = type;
		this.superInterfaces = superInterfaces;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( TypeKeyword.INTERFACE ).write( type );
		if ( hasSuperInterfaces() ) {
			writer.write( DeclarationKeyword.EXTENDS ).write( superInterfaces );
		}
	}

	public boolean hasSuperInterfaces() {
		return superInterfaces != null;
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processInterface( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( TypeKeyword.INTERFACE );
		type.transformWith( transformer );
		transformer.processKeyword( DeclarationKeyword.EXTENDS );
		superInterfaces.transformWith( transformer );
	}

}
