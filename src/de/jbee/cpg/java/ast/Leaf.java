package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writable;

public interface Leaf extends Writable, Constrcutable {

    public static final Writable BLOC_OPEN = Delimiter.character( '{' );
    public static final Writable BLOC_CLOSE = Delimiter.character( '}' );

    public static final Writable GENERIC_OPEN = Delimiter.character( '<' );
    public static final Writable GENERIC_CLOSE = Delimiter.character( '>' );

    public static final Writable ARGS_OPEN = Delimiter.character( '(' );
    public static final Writable ARGS_CLOSE = Delimiter.character( ')' );

    public static final Writable ASSIGNMENT = Delimiter.character( '=' );

}
