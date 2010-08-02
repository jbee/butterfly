package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLDefine;
import de.jbee.cpg.write.Writer;

public final class Import implements Node {

    public static final Import JAVA = new Import( "java.lang.*" );

    private final Identifier pkg;

    public Import( final String pkg ) {
        this.pkg = new Identifier( pkg );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( JLDefine.IMPORT ).write( pkg ).write( ';' ).assureNewline();
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processImport( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        walker.processKeyword( JLDefine.IMPORT );
        pkg.constructBy( walker );
    }

    /*
     * Für alle unbekannten (nicht aus java.*) Klasse ohne Import kann man das
     * Paket der Klasse annehmen.
     */

}
