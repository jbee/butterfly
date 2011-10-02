package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JavaKeyword;

public interface TreeTransformer {

	/*
	 * TODO check ob es nicht besser ist, wenn man nur 2/3 process methoden hat - für blätter und
	 * nodes mit einem zusätzlichem parameter des typs das kann man dann in transformer dynamischer
	 * programmieren - man hätte ein satz von transformationen, die man auf kompatiblität prüft und
	 * im zweifel dann anwendet.
	 */

	/*
	 * Leafs
	 */
	void processKeyword( JavaKeyword k );

	void processIdentifier( Identifier i );

	/*
	 * Nodes
	 */
	void processModifier( Modifier m );

	void processAnnotation( Annotation a );

	void processArray( Array a );

	void processGeneric( Generic g );

	void processImport( Import i );

	void processFile( File c );

	void processField( Field f );

	void processMethod( Method m );

	void processParameter( Parameter p );

	void processPackage( Package p );

	void processPrimitive( Primitive p );

	void processClass( Class c );

	void processInterface( Interface i );

	void processDeclaration( Declaration d );

	void processEnum( Enum e );

	/*
	 * Collection-Nodes
	 */

	void processAnnotations( Annotations annotations );

	void processFiles( Files interfaces );

	void processImports( Imports imports );

	void processFields( Fields fields );

	void processMethods( Methods methods );

	void processParameters( Parameters parameters );

	void processGenerics( Generics generics );
}
