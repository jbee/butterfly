package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Array implements Type {

    private final Type type;

    public Array( final Type type ) {
        super();
        this.type = type;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( type ).write( "[]" );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processArray( this );
    }

    //@Override
    public void constructParts( final JavaTreeWalker walker ) {
        type.constructBy( walker );
    }

}
