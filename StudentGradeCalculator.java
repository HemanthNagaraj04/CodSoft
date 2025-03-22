import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int Number_of_Subjects = scanner.nextInt();
        int[] marks = new int[Number_of_Subjects];
        int Total_Marks = 0;
        for (int i = 0; i < Number_of_Subjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " marks: ");
            marks[i] = scanner.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Enter marks between 0 to 100.");
                i--;
            } else {
                Total_Marks += marks[i];
            }
        }
        double Average_Percentage = (double) Total_Marks / Number_of_Subjects;
        String grade;
        if (Average_Percentage >= 90) {
            grade = "A+";
        } else if (Average_Percentage >= 80) {
            grade = "A";
        } else if (Average_Percentage >= 70) {
            grade = "B";
        } else if (Average_Percentage >= 60) {
            grade = "C";
        } else if (Average_Percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }
        System.out.println("------------------");
        System.out.println("      Result      ");
        System.out.println("------------------");
        System.out.println("Total Marks: " + Total_Marks);
        System.out.printf("Average Percentage: %.2f%%\n", Average_Percentage);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
