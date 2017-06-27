ABOUT:
_________________________________________________________________
-The application reads src/CSVFiles/input.csv, converts the CSV
 records to XML entries and prints the output to the console.
-It is assumed that the first line of the CSV file indicates the 
 column names.
-The application also contains test cases to ensure handling of 
 some edge cases such as an empty file, a missing column name and 
 an empty record in the CSV file.
 
 Note: Instead of printing the output on the console, a new 
 XML file with the output could have been created but due to 
 potential file write permission issues that has been avoided.
_________________________________________________________________

TO RUN:
_________________________________________________________________
1. Import the extracted folder/archive file into workspace
	Please ensure 'input.csv' file is present under src/CSVFiles/

2. Run the project as a java application [Main.class]
3. Run as JUnit Test
4. Output is written to the console
_________________________________________________________________

DEPENDENCIES:
_________________________________________________________________
JUnit4 library present in the build path
_________________________________________________________________

TESTING:
_________________________________________________________________
Tests.java contains 3 JUnit tests each with their separate 
input file. These files must be present for the tests to run
successfully.
_________________________________________________________________

FUTURE ENHANCEMENTS:
_________________________________________________________________
1. Ability to create an output XML file.
2. Ability to generate nested XML elements as per the input 
   structure (not applicable to CSV format input).
3. An interface to browse for input and output file locations on 
   disk.
_________________________________________________________________


