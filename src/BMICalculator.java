import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Converts and colculates user's BMI based on height and weight
 * @version 11/16/2022
 * @author 23truitt
 */
public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE:this method myst properly handle bad data
     * @param inches user's height in inches
     * @param pounds user's weight in pounds
     * @return User's BMI weight(kg)/height(m)^2 a double
     */
    public static double computeBMI(int inches, int pounds) {
        double kgs, meters;
        meters = inches * 0.0254;
        kgs = pounds * 0.454;
        if(kgs > 0 && inches > 0)
            return kgs / Math.pow(meters, 2);
        else
            return 0.00;
    }

    /** Uses a Scanner to prompt the user for info, process the feet/inches conversion
     * Calls the computeBMI method
     * Prints the correct information
     */
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String userin;
       int inches, pounds;
       while(true) {
           try {
               System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
               userin = in.nextLine();
               if(userin.equals("0"))
                   break;
               inches = Integer.parseInt(userin.substring(0, userin.indexOf("'"))) * 12;
               inches += Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));
               System.out.print("Enter your weight in pounds: ");
               userin = in.nextLine();
               pounds = Integer.parseInt(userin);
               DecimalFormat bmiDecimal = new DecimalFormat("0.00");
               System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + bmiDecimal.format(computeBMI(inches, pounds)) + " kg/m^2");
               System.out.print("Would you like to know what this number means? (Enter Yes to continue or No to end): ");
               userin = in.nextLine();
               if(userin.equals("No"))
                   break;
               System.out.println("Underweight = <18.5");
               System.out.println("Normal weight = 18.5–24.9");
               System.out.println("Overweight = 25–29.9");
               System.out.println("Obesity = BMI of 30 or greater");
               System.out.println("Thanks for using my BMI Calculator.");
               break;

           }
           catch (Exception e) {
               System.out.println("There was an error, see here: " + e);
           }
       }
    }
}