package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLType;
import de.jbee.cpg.write.Writer;

public final class Primitive implements Type {

    private final JLType primitive;

    public Primitive( final JLType primitive ) {
        super();
        this.primitive = primitive;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( primitive );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processPrimitive( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( primitive );
    }

}
