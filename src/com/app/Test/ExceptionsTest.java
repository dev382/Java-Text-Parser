package com.app.Test;

public class ExceptionsTest {

    public static void throwException() {
        System.out.println();
        System.out.println("Something went wrong. Please make sure your input files are in the correct location (reference README file) and that they follow appropriate format, as shown below:");
        System.out.println();
        System.out.println("Comma-delimited file format:");
        System.out.println("LastName, FirstName, Gender, FavoriteColor, DateOfBirth");
        System.out.println("Example:");
        System.out.println("Abercrombie, Neil, Male, Tan, 2/13/1943");
        System.out.println();
        System.out.println("Pipe-delimited file format:");
        System.out.println("LastName | FirstName | MiddleInitial | Gender | FavoriteColor | DateOfBirth");
        System.out.println("Example:");
        System.out.println("Smith | Steve | D | M | Red | 3-3-1985");
        System.out.println();
        System.out.println("Space-delimited file format:");
        System.out.println("LastName FirstName MiddleInitial Gender DateOfBirth FavoriteColor");
        System.out.println("Example:");
        System.out.println("Kournikova Anna F F 6-3-1975 Red");
        System.out.println();
        System.out.println("Note that the Gender and Date of Birth must match the exact format shown above for each file.");
        System.out.println("Therefore, the Gender should include the full word (Male or Female) in the Comma-delimited file, whereas the gender should only include the initials (M or F) for the Pipe and Space delimited files");
        System.out.println("The Date of Birth should be in M/D/YYYY format in the Comma-delimited file, whereas The Date of Birth should be in M-D-YYYY format in the Pipe and Space delimited files");
        System.out.println();
    }
}

