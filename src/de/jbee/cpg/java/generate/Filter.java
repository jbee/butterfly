package de.jbee.cpg.java.generate;

import de.jbee.cpg.java.ast.Node;

public interface Filter<T extends Node> {

	void allows();
}
