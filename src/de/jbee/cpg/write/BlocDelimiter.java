package de.jbee.cpg.write;

import java.util.EnumMap;

public final class BlocDelimiter<E extends Enum<E>> {

    private final Writable fallback;
    private final EnumMap<E, Writable> before;
    private final EnumMap<E, Writable> after;

    public BlocDelimiter( final Writable fallback, final Class<E> keyType ) {
        this.fallback = fallback;
        this.before = new EnumMap<E, Writable>( keyType );
        this.after = new EnumMap<E, Writable>( keyType );
    }

    public Writable before( final E type ) {
        return withFallbackOnNull( before.get( type ) );
    }

    public Writable after( final E type ) {
        return withFallbackOnNull( after.get( type ) );
    }

    private Writable withFallbackOnNull( final Writable w ) {
        return w == null
            ? fallback
            : w;
    }
}
