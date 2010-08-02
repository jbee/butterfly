package de.jbee.cpg.write;

public interface Writer {

    Writer write( char c );

    Writer write( char[] sequence );

    Writer write( int i );

    Writer write( long l );

    Writer write( float f );

    Writer write( double d );

    Writer write( boolean b );

    Writer write( String s );

    Writer write( Writable w );

    Writer assureWhitespace();

    Writer assureNewline();

}
