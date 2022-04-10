package com.app.Main;

public class StringFormatter {

    // helper function to format each string in 'list' (From TextParser class) to the correct output format:
    // last name, first name, gender, date of birth, favorite color
    public static String formatString(String[] arr, boolean isCommaDelimited, boolean isPipeDelimited, boolean isSpaceDelimited) {

        StringBuilder sb = new StringBuilder();
        boolean isGender = isCommaDelimited ? true : false;
        boolean isDate = false;

        for (int i = 0 ; i < arr.length; i++) {

            if (arr[i].equals("|")) continue;

            else if (arr[i].length() == 1 && !isGender) {
                isGender = true;
                continue;
            }

            else if (arr[i].equals("M") || arr[i].equals("Male")) {
                sb.append("Male").append(" ");
                continue;
            }

            else if (arr[i].equals("F") || arr[i].equals("Female")) {
                sb.append("Female").append(" ");
                continue;
            }

            else if ((isCommaDelimited && i == 3) || (isPipeDelimited && i == 8)) {
                String temp = arr[arr.length - 1];
                arr[arr.length - 1] = arr[i];
                arr[i] = temp;
                isDate = true;
            }

            if (isDate || (isSpaceDelimited && i == 4)) {
                String dateStr = arr[i].replace('-', '/');
                sb.append(dateStr).append(" ");
                isDate = false;
                continue;
            }

            if (i == arr.length - 1) sb.append(arr[i]);
            else sb.append(arr[i]).append(" ");
        }

        return sb.toString();
    }
}
