package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Annotations extends Nodes<Annotation> {

    public Annotations( final Annotation... annotations ) {
        super( annotations );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( childNodes( Delimiter.LINE_FEED ) );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processAnnotations( this );
    }

}
