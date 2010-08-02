package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLDefine;
import de.jbee.cpg.write.Writer;

public final class Interface implements Type {

    private final Generic type;
    private final Generics superInterfaces;

    public Interface( final Generic type, final Generics superInterfaces ) {
        this.type = type;
        this.superInterfaces = superInterfaces;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( JLDefine.INTERFACE ).write( type );
        if ( hasSuperInterfaces() ) {
            writer.write( JLDefine.EXTENDS ).write( superInterfaces );
        }
    }

    public boolean hasSuperInterfaces() {
        return superInterfaces != null;
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processInterface( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( JLDefine.INTERFACE );
        type.constructBy( walker );
        walker.processKeyword( JLDefine.EXTENDS );
        superInterfaces.constructBy( walker );
    }

}
