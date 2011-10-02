package de.jbee.cpg.write;

import java.util.Iterator;

public final class Write {

	/**
	 * Used to avoid null checks when nothing should be written.
	 */
	public static final Writable NOTHING = new Nothing();

	public static Writable list( final Iterable<? extends Writable> list, final Writable delimiter ) {
		return new WritableList( list, delimiter );
	}

	public static Writable nothingWhenNullElse( final Writable w ) {
		return w == null
			? NOTHING
			: w;
	}

	public static Writable character( char c ) {
		return new WritableChar( c );
	}

	private Write() {
		// util
	}

	static final class WritableChar
			implements Writable {

		private final char character;

		WritableChar( final char character ) {
			this.character = character;
		}

		@Override
		public void write( final Writer writer ) {
			writer.write( character );
		}

	}

	static final class Nothing
			implements Writable {

		@Override
		public String toString() {
			return "[" + getClass().getSimpleName() + "]";
		}

		@Override
		public void write( final Writer writer ) {
			// simply do nothing as it's name said
		}

	}

	static final class WritableList
			implements Writable {

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
}
