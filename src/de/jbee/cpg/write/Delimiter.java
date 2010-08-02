package de.jbee.cpg.write;

public final class Delimiter {

    private static final class CharDelimiter implements Writable {

        private final char delimiter;

        CharDelimiter( final char delimiter ) {
            this.delimiter = delimiter;
        }

        @Override
        public void write( final Writer writer ) {
            writer.write( delimiter );
        }

    }

    public static final Writable SPACE = new CharDelimiter( ' ' );
    public static final Writable TAB = new CharDelimiter( '\t' );
    public static final Writable LINE_FEED = new CharDelimiter( '\n' );

    public static final Writable COMMA = new CharDelimiter( ',' );
    public static final Writable SEMI_COLON = new CharDelimiter( ';' );

    public static Writable character( final char delimiter ) {
        return new CharDelimiter( delimiter );
    }
}
