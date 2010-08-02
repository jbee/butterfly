package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum JLType implements JLKeyword {

        BOOLEAN,
        BYTE,
        CHAR,
        DOUBLE,
        FLOAT,
        INT,
        LONG,
        SHORT,
        VOID;

    @Override
    public void write( final Writer writer ) {
        Java.write( this, writer );
    }

}
