package com.eaz.path;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JIVL
 */
public class PathConceptTest {

    public static void main (String args[]) {
        
        String strLinuxPath = "/home/uploads/nhmr/auditTrailExample.pdf";
        String strWindowspath = "C:\\home\\uploads\\nhmr\\auditTrailExample.pdf";
        
        Path path = Paths.get(strLinuxPath);
        
        System.out.println("\tFile.separator ==> " + File.separator);
        
        System.out.println("*** Linux path");
        System.out.println("\tpath.getFileName() ==> " + path.getFileName().toString());
        System.out.println("\tpath.getRoot() ==> " + path.getRoot().toString());
        System.out.println("\tpath.getParent() ==> " + path.getParent().toString());
        
        path = Paths.get(strWindowspath);
        System.out.println("*** Windows path");
        System.out.println("\tpath.getFileName() ==> " + path.getFileName().toString());
        System.out.println("\tpath.getRoot() ==> " + (path.getRoot() != null ? path.getRoot().toString() : "null"));
        System.out.println("\tpath.getParent() ==> " + path.getParent().toString());
    }
}
