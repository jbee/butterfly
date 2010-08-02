package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLDefine;
import de.jbee.cpg.write.Writer;

public final class Package implements Node {

    private final Identifier name;

    public Package( final String name ) {
        this.name = new Identifier( name );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( JLDefine.PACKAGE ).write( name ).write( ';' ).assureNewline();
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processPackage( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( JLDefine.PACKAGE );
        name.constructBy( walker );
    }

}
