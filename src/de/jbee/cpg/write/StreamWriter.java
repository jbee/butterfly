package de.jbee.cpg.write;

import java.io.PrintStream;

public final class StreamWriter implements Writer {

    private boolean whitespac = true;
    private boolean newline = true;

    private final PrintStream stream;

    public StreamWriter( final PrintStream stream ) {
        this.stream = stream;
    }

    @Override
    public Writer assureNewline() {
        if ( !newline ) {
            stream.print( '\n' );
            newLine();
        }
        return this;
    }

    private void newLine() {
        newline = true;
        newSpace();
    }

    private void newSpace() {
        whitespac = true;
    }

    @Override
    public Writer assureWhitespace() {
        if ( !whitespac ) {
            stream.print( ' ' );
            newSpace();
        }
        return this;
    }

    @Override
    public Writer write( final char c ) {
        stream.print( c );
        updateLastChar( c );
        return this;
    }

    private void updateLastChar( final String s ) {
        if ( s != null ) {
            updateLastChar( s.charAt( s.length() - 1 ) );
        }
    }

    private void updateLastChar( final char c ) {
        newline = c == '\n';
        whitespac = newline || Character.isWhitespace( c );
    }

    private void updateLastChar( final boolean newLine ) {
        whitespac = newLine;
        newline = newLine;
    }

    @Override
    public Writer write( final char[] sequence ) {
        stream.print( sequence );
        updateLastChar( sequence[sequence.length - 1] );
        return this;
    }

    @Override
    public Writer write( final int i ) {
        stream.print( i );
        updateLastChar( false );
        return this;
    }

    @Override
    public Writer write( final long l ) {
        stream.print( l );
        updateLastChar( false );
        return this;
    }

    @Override
    public Writer write( final float f ) {
        stream.print( f );
        updateLastChar( false );
        return this;
    }

    @Override
    public Writer write( final double d ) {
        stream.print( d );
        updateLastChar( false );
        return this;
    }

    @Override
    public Writer write( final boolean b ) {
        stream.print( b );
        updateLastChar( false );
        return this;
    }

    @Override
    public Writer write( final String s ) {
        stream.print( s );
        updateLastChar( s );
        return this;
    }

    @Override
    public Writer write( final Writable w ) {
        if ( w != null ) {
            w.write( this );
        }
        return this;
    }

}
