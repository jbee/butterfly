package de.jbee.cpg.java.lang;

import java.util.HashSet;
import java.util.Set;

import de.jbee.cpg.write.Writer;

public final class Java {

    private static final String[] JAVA_LANG_1_6 =
            { "Appendable", "CharSequence", "Cloneable", "Comparable", "Iterable", "Readable", "Runnable",
                    "Thread.UncaughtExceptionHandler", "Class", "Boolean", "Byte", "Character", "Character.Subset",
                    "Character.UnicodeBlock", "Class", "ClassLoader", "Compiler", "Double", "Enum", "Float",
                    "InheritableThreadLocal", "Integer", "Long", "Math", "Number", "Object", "Package", "Process",
                    "ProcessBuilder", "Runtime", "RuntimePermission", "SecurityManager", "Short", "StackTraceElement",
                    "StrictMath", "String", "StringBuffer", "StringBuilder", "System", "Thread", "ThreadGroup",
                    "ThreadLocal", "Throwable", "Void", "Enum", "Thread.State", "Exception", "ArithmeticException",
                    "ArrayIndexOutOfBoundsException", "ArrayStoreException", "ClassCastException",
                    "ClassNotFoundException", "CloneNotSupportedException", "EnumConstantNotPresentException",
                    "Exception", "IllegalAccessException", "IllegalArgumentException", "IllegalMonitorStateException",
                    "IllegalStateException", "IllegalThreadStateException", "IndexOutOfBoundsException",
                    "InstantiationException", "InterruptedException", "NegativeArraySizeException",
                    "NoSuchFieldException", "NoSuchMethodException", "NullPointerException", "NumberFormatException",
                    "RuntimeException", "SecurityException", "StringIndexOutOfBoundsException",
                    "TypeNotPresentException", "UnsupportedOperationException", "Error", "AbstractMethodError",
                    "AssertionError", "ClassCircularityError", "ClassFormatError", "Error",
                    "ExceptionInInitializerError", "IllegalAccessError", "IncompatibleClassChangeError",
                    "InstantiationError", "InternalError", "LinkageError", "NoClassDefFoundError", "NoSuchFieldError",
                    "NoSuchMethodError", "OutOfMemoryError", "StackOverflowError", "ThreadDeath", "UnknownError",
                    "UnsatisfiedLinkError", "UnsupportedClassVersionError", "VerifyError", "VirtualMachineError",
                    "Annotation", "Deprecated", "Override", "SuppressWarnings" };

    private static final Set<String> JAVA_LANGUAGE_CLASSES = makeClassIndex( JAVA_LANG_1_6 );

    private static Set<String> makeClassIndex( final String[] classNames ) {
        final Set<String> res = new HashSet<String>( classNames.length );
        for ( final String c : classNames ) {
            res.add( c );
        }
        return res;
    }

    public static boolean isJreType( final String simpleName ) {
        return JAVA_LANGUAGE_CLASSES.contains( simpleName );
    }

    public static <T extends Enum<T> & JLKeyword> void write( final T keyword, final Writer writer ) {
        writer.assureWhitespace().write( keyword.name().toLowerCase() ).assureWhitespace();
    }

    private Java() {
        // util
    }
}
