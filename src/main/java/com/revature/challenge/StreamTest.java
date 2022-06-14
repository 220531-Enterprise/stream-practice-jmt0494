package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {
	
    public static void main(String[] args) {
    	
    	/*
    	 * ============== Don't alter the code between lines 24 - 42 ==============
    	 */
 
        Student student1 = new Student(
            "Bob",
            20,
            new Address("1234"),
            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
 
        Student student2 = new Student(
            "Alice",
            20,
            new Address("1235"),
            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
 
        Student student3 = new Student(
            "Wally",
            20,
            new Address("1236"),
            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
 
        List<Student> students = Arrays.asList(student1, student2, student3);
        
    	/*
    	 *========== Don't alter the code above (lines 24 - 42) ===============
    	 */
        
        /***************************************************************************
         (1) Get the student with the name "Bob" and print his name to the console.
             If "Bob" does not exist, print "No student found".
     	     HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        Optional<Student> possibleBob = students.stream()
        		.filter(s -> s.getName().equals("Bob"))
        		.findFirst();

        System.out.println(possibleBob.isPresent() ? possibleBob.get().getName() : "No Student Found");
        
        
        /***************************************************************************
         (2) Get the student with matching address "1235" and print their name to the console.
             If the address does not exist, print "No student found".
             HINT: Store students.stream()...etc to an Optional<Student> in the case that the student
             doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
        ****************************************************************************/

        
        Optional<Student> s1 = students.stream()
        		.filter(s -> s.getAddress().getZipcode().equals("1235"))
        		.findFirst();
        
        System.out.println(s1.isPresent() ? s1.get().getName() : "No Student Found");

        
        
        
        
        /****************************************************************************
         (3) Get all the students that have the mobile number "3333" and print their
             names to the console.
        *****************************************************************************/

        
        List<Student> studentsWith3333 = students.stream()
        		.filter(s -> s.getMobileNumbers()
        				.stream()
        				.anyMatch(num -> num.getNumber().equals("3333")))
        		.collect(Collectors.toList());
        
        studentsWith3333.forEach(s -> System.out.println(s.getName()));

        
        
        
        
        /***************************************************************************
         (4) Get all student having both mobile numbers "1233" and "1234" and print their
             names to the console.
         ***************************************************************************/

        
        List<Student> studentsWith123 = students.stream()
        		.filter(s -> s.getMobileNumbers()
        				.stream()
        				.anyMatch(num -> num.getNumber().equals("1233")))
        		.filter(s -> s.getMobileNumbers() 
        				.stream()
        				.anyMatch(num -> num.getNumber().equals("1234")))
        		.collect(Collectors.toList());
        
        studentsWith123.forEach(s -> System.out.println(s.getName()));
        
        
        /***************************************************************************
	     (5) Create a List<Student> from the tmpStudents List. Call it studentList.
	         Hint: Use Collectors.toList(). Print it to the console. 
	         Resource: https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
        ****************************************************************************/
        TempStudent tmpStud1 = new TempStudent(
            "Bob1",
            201,
            new Address("12341"),
            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
 
        TempStudent tmpStud2 = new TempStudent(
            "Alice1",
            202,
            new Address("12351"),
            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
 
        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        
        // Code your Solution here, don't touch the code above
        
        List<Student> studentList = tmpStudents.stream()
        		.map(ts -> new Student(ts.name, ts.age, ts.address, ts.mobileNumbers))
        		.collect(Collectors.toList());
        System.out.println(studentList);
        
        
 
        /***************************************************************************
         (6) Convert the List<Student> called studentList that you made in question (5) to 
             List<String> of just their names. Call this new list "studentNames". 
             Print it to the console.
        ****************************************************************************/

        
        List<String> studentNames = studentList.stream()
        		.map(s -> s.getName())
        		.collect(Collectors.toList());
        System.out.println(studentNames);
        
        
        
        
        /***************************************************************************
          (7) Convert List<Students> to a single String called name with just their names.
          	  Print that String to the console.
        ****************************************************************************/

        
        String name = studentNames.stream()
        		.collect(Collectors.joining(" "));
        System.out.println(name);

        
        
        
        
        /****************************************************************************
         (8) Change all the Strings within the List<String> nameList to Upper Case.
             Print it to the screen.
        *****************************************************************************/
        List<String> nameList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        // Code your Solution here, don't touch the code above

        List<String> nameListUpperCase = nameList.stream()
        		.map(n -> n.toUpperCase())
        		.collect(Collectors.toList());
        
        System.out.println(nameListUpperCase);
        
        
        /****************************************************************************
         (9) Sort List<String> namesList by natural order.
             Hint: Research .sorted() method https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
         *****************************************************************************/
        List<String> namesList =
            Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");
 
        List<String> namesListSorted = namesList.stream()
        		.sorted()
        		.collect(Collectors.toList());
        System.out.println(namesListSorted);
 
    }
    
    
}






