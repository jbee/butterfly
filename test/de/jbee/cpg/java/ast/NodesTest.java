package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.StreamWriter;
import de.jbee.cpg.write.Writer;

public class NodesTest {

	/**
	 * @param args
	 */
	public static void main( final String[] args ) {
		final Writer w = new StreamWriter( System.out );
		final Method m = new Method( new Declaration( null, Modifier.INTERFACE_METHOD, new Generic(
				"String", null ) ), new Identifier( "doIt" ),
				new Parameters(
						new Parameter( new Declaration( new Annotations(
								new Annotation( "me", null ) ), Modifier.NONE, new Generic(
								"Integer", new Generics( new Generic( "right", new Generics(
										new Generic( "second", null ) ) ) ) ) ), new Identifier(
								"hansi" ) ) ) );
		final File classA = new File( new Package( "hier.und.da" ), new Imports( new Import(
				"ich.Du" ) ), new Declaration( null, Modifier.NONE, new Class( new Generic(
				"MyClass", null ), null, null ) ), null, new Methods( m ), null );
		w.write( classA );
	}

}
