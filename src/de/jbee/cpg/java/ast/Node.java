package de.jbee.cpg.java.ast;

public interface Node extends Leaf {

    void constructParts( JavaTreeWalker walker );
}
