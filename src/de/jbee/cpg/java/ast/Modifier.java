package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLKeyword;
import de.jbee.cpg.java.lang.JLModifier;
import de.jbee.cpg.java.lang.JLStability;
import de.jbee.cpg.java.lang.JLVisibility;
import de.jbee.cpg.write.Writer;

public final class Modifier implements Node {

    public static final Modifier NONE = new Modifier( null, null );
    public static final Modifier GETTER_SETTER = new Modifier( JLVisibility.PUBLIC, JLStability.FINAL );
    public static final Modifier INTERFACE_METHOD = new Modifier( JLVisibility.PUBLIC, JLStability.ABSTRACT );
    public static final Modifier INTERFACE_FIELD = new Modifier( JLVisibility.PUBLIC, JLStability.FINAL, JLModifier.STATIC );

    private final JLVisibility visibility;
    private final JLStability stability;
    private final JLModifier[] modifiers;

    public Modifier( final JLVisibility visibility, final JLStability stability, final JLModifier... modifiers ) {
        this.visibility = visibility;
        this.stability = stability;
        this.modifiers = modifiers;
    }

    public boolean isStatic() {
        return contains( JLModifier.STATIC );
    }

    public boolean contains( final JLModifier m ) {
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
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processModifier( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( visibility == null
            ? JLVisibility.DEFAULT
            : visibility );
        if ( modifiers != null ) {
            for ( final JLKeyword k : modifiers ) {
                walker.processKeyword( k );
            }
        }
        if ( stability != null ) {
            walker.processKeyword( stability );
        }
    }
}
