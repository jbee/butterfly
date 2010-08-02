package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLDefine;
import de.jbee.cpg.write.Writer;

public final class Class implements Type {

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
        writer.write( JLDefine.CLASS ).write( type );
        if ( hasSuperClasses() ) {
            writer.write( JLDefine.EXTENDS ).write( superClasses );
        }
        if ( hasSuperInterfaces() ) {
            writer.write( JLDefine.IMPLEMENTS ).write( superInterfaces );
        }
    }

    public boolean hasSuperClasses() {
        return superClasses != null;
    }

    public boolean hasSuperInterfaces() {
        return superInterfaces != null;
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processClass( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processGeneric( type );
        if ( hasSuperClasses() ) {
            walker.processKeyword( JLDefine.EXTENDS );
            walker.processGenerics( superClasses );
        }
        if ( hasSuperInterfaces() ) {
            walker.processKeyword( JLDefine.IMPLEMENTS );
            walker.processGenerics( superInterfaces );
        }
    }
}
