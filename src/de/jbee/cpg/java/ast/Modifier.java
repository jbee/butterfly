package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JavaKeyword;
import de.jbee.cpg.java.lang.ModifierKeyword;
import de.jbee.cpg.java.lang.StabilityKeyword;
import de.jbee.cpg.java.lang.VisibilityKeyword;
import de.jbee.cpg.write.Writer;

public final class Modifier
		implements Node {

	public static final Modifier NONE = new Modifier( null, null );
	public static final Modifier GETTER_SETTER = new Modifier( VisibilityKeyword.PUBLIC,
			StabilityKeyword.FINAL );
	public static final Modifier INTERFACE_METHOD = new Modifier( VisibilityKeyword.PUBLIC,
			StabilityKeyword.ABSTRACT );
	public static final Modifier INTERFACE_FIELD = new Modifier( VisibilityKeyword.PUBLIC,
			StabilityKeyword.FINAL, ModifierKeyword.STATIC );

	private final VisibilityKeyword visibility;
	private final StabilityKeyword stability;
	private final ModifierKeyword[] modifiers;

	public Modifier( final VisibilityKeyword visibility, final StabilityKeyword stability,
			final ModifierKeyword... modifiers ) {
		this.visibility = visibility;
		this.stability = stability;
		this.modifiers = modifiers;
	}

	public boolean isStatic() {
		return contains( ModifierKeyword.STATIC );
	}

	public boolean contains( final ModifierKeyword m ) {
		if ( modifiers == null ) {
			return false;
		}
		for ( int i = 0; i < modifiers.length; i++ ) {
			if ( m == modifiers[i] ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void write( final Writer writer ) {
		if ( visibility != null ) {
			writer.write( visibility );
		}
		if ( modifiers != null ) {
			for ( int i = 0; i < modifiers.length; i++ ) {
				writer.write( modifiers[i] );
			}
		}
		if ( stability != null ) {
			writer.write( stability );
		}
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processModifier( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		transformer.processKeyword( visibility == null
			? VisibilityKeyword.DEFAULT
			: visibility );
		if ( modifiers != null ) {
			for ( final JavaKeyword k : modifiers ) {
				transformer.processKeyword( k );
			}
		}
		if ( stability != null ) {
			transformer.processKeyword( stability );
		}
	}
}
