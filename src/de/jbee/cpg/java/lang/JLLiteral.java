package de.jbee.cpg.java.lang;

import de.jbee.cpg.write.Writer;

/**
 * Lieterale sind keine echten Schlüsselwörte der Java-Sprache, aber im Sinne
 * des AST als solche zu sehen.
 * 
 */
public enum JLLiteral implements JLKeyword {

        TRUE,
        FALSE,
        THIS,
        NULL;

    @Override
    public void write( final Writer writer ) {
        Java.write( this, writer );
    }

}
