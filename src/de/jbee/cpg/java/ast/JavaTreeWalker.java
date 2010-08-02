package de.jbee.cpg.java.ast;

import de.jbee.cpg.java.lang.JLKeyword;

public interface JavaTreeWalker {

    /*
     * Leafs
     */
    void processKeyword( JLKeyword k );

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
