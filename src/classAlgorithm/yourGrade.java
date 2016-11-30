/**
 @Name    Chase Goodman
 @Version  0.01 AlPHA
 @Started  2015-01-08
 */
package classAlgorithm;

import java.util.Scanner;

public class yourGrade {

    public static void main(String[] args){
        System.out.println("----CS121 GRADING ALGORITHM----");
        Scanner kb = new Scanner(System.in); //Allows input
        int totalPoints, totalLabPoints; //Declares the variables

        //Gets values for the totalPoints and totalLabPoints
        System.out.print("Please enter the total points for this course: ");
        totalPoints = kb.nextInt();
        System.out.print("Please enter the total points for the lab portion of this course: ");
        totalLabPoints = kb.nextInt();

        //Gets Value for the C cut off
        int cCutOff = (totalPoints/2) + (totalLabPoints/2);

        //Gather info for Array and find the largest grade
        System.out.print("Number of students: ");
        int[] a = new int[kb.nextInt()]; //Uses the Number of students to create the length of the array
        int max = 0;
        System.out.println("Please enter a score...");
        for(int i=0; i<a.length; i++){ //A for loop to create the array
            System.out.print("Student #" + (i+1) + ": ");
            a[i]=kb.nextInt();
        }

        for(int i=0; i<a.length; i++){ //Figures out the max score of all students
            if(a[i] > max){
                max = a[i];
            }
        }

        //Makes an array with all of the students names
        System.out.println("Please enter a name of a corresponding student...");
        String studentName[] = new String[a.length];
        for(int i=0; i<a.length; i++){
            System.out.print("Student #" + (i+1) + ": ");
            studentName[i]=kb.next();
        }

        //All of the cut off grade values
        int range = max - cCutOff;
        int gRange = range / 3;
        int bCutOff = cCutOff + gRange;
        int aCutOff = bCutOff + gRange;
        //System.out.println(cCutOff); Shows you the lowest value for the C range
        //System.out.println(bCutOff); Shows you the lowest value for the B range
        //System.out.println(aCutOff); Shows you the lowest value for the A range
        String str = "";
        for(int i=0; i<a.length; i++){
            if(a[i] >= aCutOff){
                str = "A";
            }else if(a[i] < aCutOff && a[i] >= bCutOff){
                str = "B";
            }else if(a[i] < bCutOff && a[i] >= cCutOff){
                str = "C";
            }else{
                str = "F";
            }
            System.out.println(studentName[i] + "'s point total is " + a[i] + ". Which gives them a(n) " + str + ".");
        }
        kb.close();
        //End of algorithm
    }

}