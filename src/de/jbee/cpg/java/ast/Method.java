package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class Method implements Node {

    private final Declaration declaration;
    private final Parameters parameters;
    private final Identifier name;

    //TODO Implementierung der Methode (Interface damit man verschiedene Möglichkeiten hat diesen Knoten darzustellen)

    public Method( final Declaration declaration, final Identifier name, final Parameters parameters ) {
        // Konstruktoren und (statische) Methoden als besondere Konstruktoren / abgeleitete Klassen ? -> Lesbarkeit
        this.declaration = declaration;
        this.parameters = parameters;
        this.name = name;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( declaration ).assureWhitespace().write( name ).write( parameters ).write( ';' ).assureNewline();
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processMethod( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        declaration.constructBy( walker );
        parameters.constructBy( walker );
        name.constructBy( walker );
    }
}
