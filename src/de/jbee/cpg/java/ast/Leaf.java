package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writable;
import de.jbee.cpg.write.Write;

public interface Leaf
		extends Writable, Transformable {

	public static final Writable BLOC_OPEN = Write.character( '{' );
	public static final Writable BLOC_CLOSE = Write.character( '}' );

	public static final Writable GENERIC_OPEN = Write.character( '<' );
	public static final Writable GENERIC_CLOSE = Write.character( '>' );

	public static final Writable ARGS_OPEN = Write.character( '(' );
	public static final Writable ARGS_CLOSE = Write.character( ')' );

	public static final Writable ASSIGNMENT = Write.character( '=' );

}
