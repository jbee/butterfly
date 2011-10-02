package de.jbee.cpg.java.ast;

public interface Node
		extends Leaf {

	void transformPartsWith( TreeTransformer transformer );
}
