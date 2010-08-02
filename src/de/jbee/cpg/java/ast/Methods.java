package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Methods extends Nodes<Method> {

    public Methods( final Method... methods ) {
        super( methods );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( childNodes( Delimiter.LINE_FEED ) );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processMethods( this );
    }

}
