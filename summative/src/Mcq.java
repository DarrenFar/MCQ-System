import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Mcq {
    static Scanner input = new Scanner(System.in);
    static int userChoice;
    static Student stud = new Student();
    public static void participant(){
        // take user input for a name
        System.out.print("Enter your name : ");
        stud.setName(input.nextLine());
    }

    public static void mcqChoice() throws FileNotFoundException {
        // Read the folder and loop through each one to list the mcq sets
        File folder = new File("MCQ set");
        String[] list = folder.list();
        System.out.println("Choose your Multiple Choice Question Set. The Options are : ");
        for (int i = 0; i < Objects.requireNonNull(list).length ; i++){
            System.out.println((i + 1)+ ". " + list[i].replace(".csv", " "));
        }
        // take user input for the index of the folder and subtract it by 1 because index starts with 0
        System.out.print("Choose the corresponding number: ");
        userChoice = input.nextInt() - 1;
        System.out.println(" ");
        String choice = "MCQ set/" + list[userChoice];
        System.out.println("you've chosen "+ list[userChoice].replace(".csv", " "));
        //Run the theQuestions() method with String choice taken as its parameter
        theQuestions(choice);
    }

    public static void theQuestions(String Filepath) throws FileNotFoundException {
            // Read the file using scanner
            File mcqFile = new File(Filepath);
            Scanner mcq1 = new Scanner(mcqFile);
            // use a while loop to display all the questions
            while (mcq1.hasNextLine()) {
                String nextLine = mcq1.nextLine();
                // use ";" as a splitting point in the csv file
                String[] array = nextLine.split(";");
                // print out all the array that includes the questions and choice that is split by ";"
                System.out.print(array[0] + " ");
                System.out.println(array[1]);
                System.out.println(array[2]);
                System.out.println(array[3]);
                System.out.println(array[4]);
                System.out.println(array[5]);
                System.out.print("Your answer: ");
                String ans = input.next();
                //Find out if the user input is correct or not. If it is correct then up the score if it is wrong then up the wrong answer
                if (Objects.equals(ans, array[6])) {
                    Student.score++;
                    System.out.println("Your answer is correct");
                    Student.numberOfQuestions++;
                    System.out.println(" ");
                } else {
                    System.out.println("Wrong Answer. The correct answer is " + array[7]);
                    Student.wrongAns++;
                    Student.numberOfQuestions++;
                    System.out.println(" ");
                }
            }
    }

    public static void calculateScore(){
        // calculate the score of the student with % weightage, score and wrong answer
        System.out.println(stud.getName() + ", you answered " + Student.score + " questions right, " + Student.wrongAns + " questions wrong for a total of " + (Student.score+Student.wrongAns) + " Questions");
        System.out.println("you scored " + ((Student.score / Student.numberOfQuestions)*100) + "%");
    }
}

