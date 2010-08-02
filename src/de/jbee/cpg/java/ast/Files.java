package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Files extends Nodes<File> {

    public Files( final File... files ) {
        super( files );
    }

    @Override
    public void write( final Writer writer ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processFiles( this );
    }

}
