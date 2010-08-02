package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Generics extends Nodes<Generic> {

    public Generics( final Generic... generics ) {
        super( generics );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( '<' ).write( childNodes( Delimiter.COMMA ) ).write( '>' );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processGenerics( this );
    }

}
