package com.app.Main;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TextParser {

    public static void main(String[] args) {
        try {
            parseText();
        } catch (Exception e) {
            Exceptions.throwException();
        }
    }

    public static void parseText() throws Exception {
        List<String> list = new ArrayList<>(); // stores every line of input from all text files as strings
        List<String> strings = new ArrayList<>(); // stores every string in 'list' with the correct output format

        // Buffer characters from each of the input files
        BufferedReader brComma = new BufferedReader(new FileReader("input/comma.txt"));
        BufferedReader brPipe = new BufferedReader(new FileReader("input/pipe.txt"));
        BufferedReader brSpace = new BufferedReader(new FileReader("input/space.txt"));

        // helper function to process the buffered characters from each file
        processInput(brComma, list, strings, true, false, false);
        processInput(brPipe, list, strings, false, true, false);
        processInput(brSpace, list, strings, false, false, true);

        List<String> sort1List = new ArrayList<>(strings); // Array list to handle the 'Sort 1' condition
        List<String> sort2List = new ArrayList<>(strings); // Array list to handle the 'Sort 2' condition
        List<String> sort3List = new ArrayList<>(strings); // Array list to handle the 'Sort 3' condition

        Collections.sort(sort1List, (a, b) -> { // sorts by gender (females before males) then by last name ascending
            int genderIndexA = a.indexOf(" ", a.indexOf(" ") + 1) + 1;
            int genderIndexB = b.indexOf(" ", b.indexOf(" ") + 1) + 1;
            char genderA = a.charAt(genderIndexA);
            char genderB = b.charAt(genderIndexB);

            if ((genderA == 'M' && genderB == 'M') || (genderA == 'F' && genderB == 'F')) {
                return a.compareTo(b);
            }
            else if (genderA == 'F' && genderB == 'M') return -1;
            else if (genderA == 'M' && genderB == 'F') return 1;
            else return 0;
        });

        Collections.sort(sort2List, (a, b) -> { // sort by birthdate, ascending then by last name ascending
            int dateIndexA = a.lastIndexOf(" ", a.lastIndexOf(" ") - 1) + 1;
            int dateIndexB = b.lastIndexOf(" ", b.lastIndexOf(" ") - 1) + 1;
            String strDateA = a.substring(dateIndexA, a.lastIndexOf(" "));
            String strDateB = b.substring(dateIndexB, b.lastIndexOf(" "));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy", Locale.ENGLISH);
            LocalDate dateA = LocalDate.parse(strDateA, formatter);
            LocalDate dateB = LocalDate.parse(strDateB, formatter);

            int comparator = dateA.compareTo(dateB);
            if (comparator != 0) return comparator;
            else return a.compareTo(b);
        });

        Collections.sort(sort3List, (a, b) -> { // sort by last name, descending
            int comparator = a.compareTo(b);
            if (comparator > 0) return -1;
            else return 1;
        });

        System.out.println();
        System.out.println("Output 1:");
        for (String st: sort1List) { // print output 1
            System.out.println(st);
        }

        System.out.println();
        System.out.println("Output 2:");
        for (String st: sort2List) { // print output 2
            System.out.println(st);
        }

        System.out.println();
        System.out.println("Output 3:");
        for (String st: sort3List) { // print output 3
            System.out.println(st);
        }
        System.out.println();
    }

    // processes all buffered characters to build a string for each line of input and then formats them to match the output format
    public static void processInput(BufferedReader br, List<String> list, List<String> strings, boolean isCommaDelimited,
                                    boolean isPipeDelimited, boolean isSpaceDelimited) throws IOException {

        String str;

        while ((str = br.readLine()) != null) { // Holds true until there are no characters left in the current file
            list.add(str); // store every line of input from current file being processed in the Array List 'list' (unformatted)
        }

        for (String st: list) { // formats each string in 'list' and stores it in the 'strings' Array list
            String[] arr = isCommaDelimited ? st.split(", ") : isPipeDelimited ? st.split(" | ") : st.split(" ");
            String validStr = StringFormatter.formatString(arr, isCommaDelimited, isPipeDelimited, isSpaceDelimited);
            strings.add(validStr);
        }

        list.clear();
    }
}
