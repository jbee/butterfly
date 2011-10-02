package de.jbee.cpg.java.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.jbee.cpg.write.Writable;
import de.jbee.cpg.write.Write;
import de.jbee.cpg.write.Writer;

public abstract class Nodes<T extends Node>
		implements Node {

	private final List<T> nodes;

	protected Nodes( final T[] nodes ) {
		this.nodes = new ArrayList<T>( Arrays.asList( nodes ) );
	}

	protected final void writeChildren( Writer writer, Writable delimiter ) {
		writer.write( Write.list( nodes, delimiter ) );
	}

	@Override
	public final void transformPartsWith( final TreeTransformer transformer ) {
		for ( final T node : nodes ) {
			node.transformWith( transformer );
		}
	}

}
