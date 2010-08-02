package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLDefine;
import de.jbee.cpg.write.Writer;

public final class Enum implements Type {

    private final Generic type;
    private final Generics superInterfaces;

    public Enum( final Generic type, final Generics superInterfaces ) {
        this.type = type;
        this.superInterfaces = superInterfaces;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( JLDefine.ENUM ).write( type );
        if ( hasSuperInterfaces() ) {
            writer.write( JLDefine.IMPLEMENTS ).write( superInterfaces );
        }
    }

    public boolean hasSuperInterfaces() {
        return superInterfaces != null;
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processEnum( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( JLDefine.ENUM );
        type.constructBy( walker );
        if ( hasSuperInterfaces() ) {
            walker.processKeyword( JLDefine.IMPLEMENTS );
            superInterfaces.constructBy( walker );
        }
    }
}
