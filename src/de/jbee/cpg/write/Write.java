package de.jbee.cpg.write;

public final class Write {

    private Write() {
        // util
    }

    /**
     * Used to avoid null checks when nothing should be written.
     */
    public static final Writable NOTHING = new Nothing();

    public static Writable list( final Iterable<? extends Writable> list, final Writable delimiter ) {
        return new WritableList( list, delimiter );
    }

    private static final class Nothing implements Writable {

        @Override
        public void write( final Writer writer ) {
            // simply do nothing as it's name said
        }

        @Override
        public String toString() {
            return "[" + getClass().getSimpleName() + "]";
        }

    }

    public static Writable nothingWhenNullElse( final Writable w ) {
        return w == null
            ? NOTHING
            : w;
    }
}
