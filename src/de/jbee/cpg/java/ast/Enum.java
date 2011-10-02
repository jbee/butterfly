package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.DeclarationKeyword;
import de.jbee.cpg.java.lang.TypeKeyword;
import de.jbee.cpg.write.Writer;

public final class Enum
		implements Type {

	private final Generic type;
	private final Generics superInterfaces;

	public Enum( final Generic type, final Generics superInterfaces ) {
		this.type = type;
		this.superInterfaces = superInterfaces;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( TypeKeyword.ENUM ).write( type );
		if ( hasSuperInterfaces() ) {
			writer.write( DeclarationKeyword.IMPLEMENTS ).write( superInterfaces );
		}
	}

	private boolean hasSuperInterfaces() {
		return superInterfaces != null;
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processEnum( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( TypeKeyword.ENUM );
		type.transformWith( transformer );
		if ( hasSuperInterfaces() ) {
			transformer.processKeyword( DeclarationKeyword.IMPLEMENTS );
			superInterfaces.transformWith( transformer );
		}
	}
}
