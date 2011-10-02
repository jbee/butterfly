package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.DeclarationKeyword;
import de.jbee.cpg.java.lang.TypeKeyword;
import de.jbee.cpg.write.Writer;

public final class Class
		implements Type {

	private final Generic type;
	private final Generics superInterfaces;
	private final Generics superClasses;

	public Class( final Generic type, final Generics superClasses, final Generics superInterfaces ) {
		this.type = type;
		this.superClasses = superClasses;
		this.superInterfaces = superInterfaces;
	}

	@Override
	public void write( final Writer writer ) {
		writer.write( TypeKeyword.CLASS ).write( type );
		if ( hasSuperClasses() ) {
			writer.write( DeclarationKeyword.EXTENDS ).write( superClasses );
		}
		if ( hasSuperInterfaces() ) {
			writer.write( DeclarationKeyword.IMPLEMENTS ).write( superInterfaces );
		}
	}

	public boolean hasSuperClasses() {
		return superClasses != null;
	}

	public boolean hasSuperInterfaces() {
		return superInterfaces != null;
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processClass( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processGeneric( type );
		if ( hasSuperClasses() ) {
			transformer.processKeyword( DeclarationKeyword.EXTENDS );
			transformer.processGenerics( superClasses );
		}
		if ( hasSuperInterfaces() ) {
			transformer.processKeyword( DeclarationKeyword.IMPLEMENTS );
			transformer.processGenerics( superInterfaces );
		}
	}
}
