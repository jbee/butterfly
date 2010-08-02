package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum JLStability implements JLKeyword {

        FINAL,
        VOLATILE,
        ABSTRACT;

    @Override
    public void write( final Writer writer ) {
        Java.write( this, writer );
    }

}
