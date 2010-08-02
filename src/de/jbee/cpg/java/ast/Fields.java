package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Fields extends Nodes<Field> {

    public Fields( final Field... fields ) {
        super( fields );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( childNodes( Delimiter.LINE_FEED ) );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processFields( this );
    }

    // Konstanten und attribute
}
