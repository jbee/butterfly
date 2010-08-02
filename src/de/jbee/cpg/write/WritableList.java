/*
 * $Id$
 * 
 * Created on 04.08.2009 by Jan Bernitt (jan.bernitt@gmx.de)
 */
package de.jbee.cpg.write;

import java.util.Iterator;

final class WritableList implements Writable {

    private final Iterable<? extends Writable> list;
    private final Writable delimiter;

    WritableList( final Iterable<? extends Writable> list, final Writable delimiter ) {
        this.list = list;
        this.delimiter = delimiter;
    }

    @Override
    public void write( final Writer writer ) {
        for ( final Iterator<? extends Writable> iter = list.iterator(); iter.hasNext(); ) {
            writer.write( iter.next() );
            if ( iter.hasNext() ) {
                writer.write( delimiter );
            }
        }
    }

}