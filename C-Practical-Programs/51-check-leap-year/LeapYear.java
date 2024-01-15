
/* LOGIC
 * 
 * -> if year is either
 *  -> divisible by 4 or 100 or 400 
 * 
 * -> then it is a leap year
 */
public class LeapYear {
    public static boolean isLeapYear(int year){
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0)){ return true; }
      return false;
   
    }    

    public static void main(String[] args) {
        int year = 2024;
        String ans = isLeapYear(year) ? "Yes":"No";
        System.out.println("is "+year + " a leap year? ->" + ans );
    }
}
