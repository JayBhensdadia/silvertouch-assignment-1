import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class MonthCalander {
    public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Month between 1 and 12 : ");
		int m = input.nextInt();
		System.out.print("Enter a Full Year : ");
		int y = input.nextInt();
		display_Month(y, m);
	}
 
	static void display_Month(int y, int m)
	{
		// get particular month of given year
		YearMonth ym = YearMonth.of(y, m);
		System.out.println("\n---------------------------");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("---------------------------");

		//date variable
		int cou = 1;

		//day of the week
		int day = LocalDate.of(y, m, 1).getDayOfWeek().getValue();

		//leave space in week until the 1st date of month starts
		if (day != 7){
			for (int i = 0; i < day; i++, cou++)
			{
				System.out.printf("%-4s", "");
			}
		}
			
 
		//print date iteratively
		for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, cou++){

			System.out.printf("%-4d", i);

			//go to new line after every 7 entries
			if (cou % 7 == 0)
			{
				System.out.println();
			}
		}		
		System.out.println("\n---------------------------");
    }    
}
