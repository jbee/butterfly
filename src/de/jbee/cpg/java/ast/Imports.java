package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Delimiter;
import de.jbee.cpg.write.Writer;

public final class Imports extends Nodes<Import> {

    // sollten einfache type-namen verwalten - d-h sie sind der scope und definieren, wann eine einfacher typ die selbe instanz ist
    // typen werden also über imports erzeugt!

    public Imports( final Import... imports ) {
        super( imports );
    }

    @Override
    public void write( final Writer writer ) {
        writer.write( childNodes( Delimiter.LINE_FEED ) );
    }

    @Override
    public void constructBy( final JavaTreeWalker walker ) {
        walker.processImports( this );
    }

}
