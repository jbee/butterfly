package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

public enum JLDefine implements JLKeyword {

        PACKAGE,
        IMPLEMENTS,
        IMPORT,
        ENUM,
        INTERFACE,
        CLASS,
        EXTENDS,
        SUPER;

    @Override
    public void write( final Writer writer ) {
        Java.write( this, writer );
    }

}
