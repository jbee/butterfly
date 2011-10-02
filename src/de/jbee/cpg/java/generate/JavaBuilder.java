package de.jbee.cpg.java.generate;

import de.jbee.cpg.java.ast.Annotation;
import de.jbee.cpg.java.ast.Class;
import de.jbee.cpg.java.ast.Import;
import de.jbee.cpg.java.ast.Method;
import de.jbee.cpg.java.ast.Package;
import de.jbee.cpg.java.ast.Parameter;

public interface JavaBuilder {

	void buildClass( Class cls );

	void buildPackage( Package pack );

	void buildImport( Import imp );

	void buildAnnotation( Annotation annotation );

	void buildMethod( Method method );

	void buildParameter( Parameter parameter );

}
