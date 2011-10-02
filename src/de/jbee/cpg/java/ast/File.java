package de.jbee.cpg.java.ast;

import de.jbee.cpg.write.Writer;

public final class File
		implements Node {

	private final Package pkg;
	private final Imports imports;
	private final Declaration declaration;
	private final Fields fields;
	private final Methods methods;
	private final Files members;

	public File( final Package pkg, final Imports imports, final Declaration declaration,
			final Fields fields, final Methods methods, final Files members ) {
		this.pkg = pkg;
		this.imports = imports;
		this.declaration = declaration;
		this.fields = fields;
		this.methods = methods;
		this.members = members;
	}

	@Override
	public void write( final Writer writer ) {
		writer.assureNewline();
		writer.write( pkg ).write( imports );
		writer.write( declaration ).write( '{' ).assureNewline();
		writer.write( members ).write( fields ).write( methods );
		writer.write( '}' );
	}

	@Override
	public void transformWith( final TreeTransformer transformer ) {
		transformer.processFile( this );
	}

	@Override
	public void transformPartsWith( final TreeTransformer transformer ) {
		pkg.transformWith( transformer );
		imports.transformWith( transformer );
		declaration.transformWith( transformer );
		members.transformWith( transformer );
		fields.transformWith( transformer );
		methods.transformWith( transformer );
	}

	//public File movedTo( final Package pkg ) {

}
