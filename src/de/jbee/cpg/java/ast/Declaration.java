package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public class Declaration implements Node {

    private final Modifier modifier;
    private final Annotations annotations;
    private final Type type;

    public Declaration( final Annotations annotations, final Modifier modifier, final Type type ) {
        this.modifier = modifier;
        this.annotations = annotations;
        this.type = type;
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( annotations ).write( modifier ).assureWhitespace().write( type ).assureWhitespace();
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processDeclaration( this );
    }

    @Override
    public void constructParts( final JavaTreeWalker walker ) {
        annotations.constructBy( walker );
        modifier.constructBy( walker );
        type.constructBy( walker );
    }

}
