import java.util.Scanner;

public class GradeCalculator
{
    public static String determineGrade(double avgPercentage)
    {
        if(avgPercentage == 100)
        {
            return "O";
        }
        else if (avgPercentage >= 90) 
        {
            return "A+";
        } 
        else if (avgPercentage >= 80) 
        {
            return "A";
        } 
        else if (avgPercentage >= 70) 
        {
            return "B+";
        } 
        else if (avgPercentage >= 60) 
        {
            return "B";
        } 
        else if (avgPercentage >= 50) 
        {
            return "C+";
        } 
        else if (avgPercentage >= 40) 
        {
            return "C";
        } 
        else if (avgPercentage >= 30) 
        {
            return "D";
        } 
        else 
        {
            return "Fail";
        }
    }
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int subjectCount = inputScanner.nextInt();
        int cumulativeMarks = 0;
        System.out.println("Enter marks obtained in each subject (out of 100):");
        for (int i = 1; i <= subjectCount; i++)
        {
            System.out.print("Subject " + i + ": ");
            int marks = inputScanner.nextInt();
            cumulativeMarks += marks;
        }
        double averagePercentage = (double) cumulativeMarks / subjectCount;
        String grade = determineGrade(averagePercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + cumulativeMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        inputScanner.close();
    }
}