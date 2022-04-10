# Java Text File Parser

Text file parser application built with Java. This app takes comma-delimited, pipe-delimited, and space-delimited text files as input and prints out a space-delimited output to the command line or console based on 3 different sorting conditions. 

## Images

> #### Text File Parser

![Capture](https://user-images.githubusercontent.com/75185644/159086768-107c4b02-cc65-48ea-a5c3-2f954c955633.PNG)


## Functionalities

- Takes comma-delimited, pipe-delimited, and space-delimited text files and prints out a space-delimited output based on 3 different sorting conditions.

- The input folder should always contain 3 text files ('.txt' extension) named 'comma', 'pipe' and 'space'. The contents within each file may be modified for different test cases, or they can also be empty (but the text file should still exist in the input folder).

- If a text file is not empty, it should meet the following criteria:

  * Comma-delimited file format: "LastName, FirstName, Gender, FavoriteColor, DateOfBirth"
  *        Example: "Abercrombie, Neil, Male, Tan, 2/13/1943"

  * Pipe-delimited file format: "LastName | FirstName | MiddleInitial | Gender | FavoriteColor | DateOfBirth"
  *        Example: "Smith | Steve | D | M | Red | 3-3-1985"

  * Space-delimited file format: "LastName FirstName MiddleInitial Gender DateOfBirth FavoriteColor"
  *        Example: "Kournikova Anna F F 6-3-1975 Red"

- Note that the Gender and Date of Birth must match the exact format shown above for each file. Therefore, the Gender should include the full word (Male or Female) in the Comma-delimited file, whereas the gender should only include the initials (M or F) for the Pipe and Space delimited files. The Date of Birth should be in M/D/YYYY format in the Comma-delimited file, whereas The Date of Birth should be in M-D-YYYY format in the Pipe and Space delimited files.

- The output will be printed in the following format: "last name first name gender date of birth favorite color"

  * Example:
  *      input: "Bonk | Radek | S | M | Green | 6-3-1975"     
  *      output: "Bonk Radek Male 6/3/1975 Green"

- There will be 3 different outputs which will be sorted according to the following conditions:

  * Output 1: Sort 1 - by gender (females before males) then by last name ascending
  * Output 2: Sort 2 - by birthdate, ascending then by last name ascending
  * Output 3: Sort 3 - by last name, descending

## Technologies Used

- Java OpenJDK, Version 17.0.1
- IntelliJ IDEA 2021.2.3 (Ultimate Edition), Build #IU-212.5457.46
- Command Line Interface: Ubuntu 20.04 (WSL)
- JUnit 5.7.0

## Getting Started

### Clone or download this repository

```sh
git clone https://github.com/dev382/Java-Text-Parser.git
```

### Run the app from your IDE

- Open the project folder 'textParser' in IntelliJ IDEA and the application will be automatically built by the IDE.
- Make sure the input folder exists at this location or the app will not run. To try different test cases, simply edit any of the text files in the input folder.
- Go to the 'TextParser' class (src ==> com.app ==> Main), make sure the class is selected and click 'Run'.
- The three outputs should now be printed in the IntelliJ IDEA console.

### Run the app from the command line

- After running the app from IntelliJ IDEA, an 'out' folder will be created at the root of the project folder.
- From the command line, navigate to 'out' ==> 'production' ==> 'textParser'
- Copy the input folder and paste it at this location or the app will not run from the command line. To try different test cases, simply edit any of the text files in the input folder.
- Type in the following command to run the app:

```
java com.app.Main.TextParser
```

- The three outputs should now be printed in the command line.

### Running Unit Tests

- Open the project folder 'textParser' in IntelliJ IDEA.
- Make sure IntelliJ IDEA has automatically installed JUnit 5.7.0.
- Make sure the input folder exists at this location or the unit tests will not run. To try different test cases, simply edit any of the text files in the input folder.
- Go to the 'TextParserTest' class (src ==> com.app ==> Test), make sure the class is selected and click 'Run'.
- This will make the following checks

  * The first check will verify if the number of input lines in each text file matches the size of the Array List 'list' (which stores each input line as a separate string, unformatted).
  * The second check will verify if the 2nd element in the Array List 'strings' (which stores every input line with the correct output format) has the correct format and matches the 2nd line of input from all the input files.
  * The third, fourth and fifth checks will verify if some elements of the 3 sorted Array Lists (which store the output strings for sorting conditions 1, 2 and 3) match those of Output 1, 2 and 3.

- If there are any unit test errors these will be shown in the IntelliJ IDEA console.
- If trying out other unit test cases, just make sure to update the expected output (depending on your test case) to avoid any false unit test errors.













