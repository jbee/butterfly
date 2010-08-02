package de.jbee.cpg.java.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.jbee.cpg.write.Writable;
import de.jbee.cpg.write.Write;

public abstract class Nodes<T extends Node> implements Node {

    private final List<T> nodes;

    protected Nodes( final T[] nodes ) {
        this.nodes = new ArrayList<T>( Arrays.asList( nodes ) );
    }

    protected final Writable childNodes( final Writable delimiter ) {
        return Write.list( nodes, delimiter );
    }

    @Override
    public final void constructParts( final JavaTreeWalker walker ) {
        for ( final T node : nodes ) {
            node.constructBy( walker );
        }
    }

}
