package day17;

import java.util.Scanner;

public class Calendar {
	/**
	 * Method to find the starting of the day
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	public static int startDay(int month,int day, int year) {
		int y= year - (14-month)/12;
		int x= y + y/4 - y/100 + y/400;
		int m = month + 12 * ((14 - month) /12) -2;
		int d = (day + x + (31*m))/12%7;
		return d;
	}
	
	/**
	 * Method to check if the year is leap year
	 * @param year
	 * @return
	 */
	public static boolean isleap(int year) {
		if ((year%4==0)&& (year % 100 !=0)) {
			return true;
		}
		if(year % 400==0) {
			return false;
		}
		return false;
	}
	
	/**
	 * main function to initialize the month and days in the year
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the month and year");
		int month = sc.nextInt();
		int year = sc.nextInt();
		/**
		 * initializing the months
		 */
		String[] months= {"0","january", "february", "March","april","may","june","july","august","september","october","november","december"};
		/**
		 * initialize no of days for particular month
		 */
		int[] days = {
				0,31,28,31,30,31,30,31,31,30,31,30,31
		};
		
		if(month == 2 && isleap(year)) {
			days[month]=29;
		}
		/**
		 * calculating the starting day.
		 */
		int d= startDay(month,1,year);
		
		System.out.println(months[month] +" "+year);
		System.out.println("s m t w t f s");
		
		for(int i =0; i<d-1; i++) {
			System.out.print("  ");
		}
		for(int i=1; i<=days[month]; i++) {
			System.out.print(i+" ");
			if(((i+d-1)%7 == 0) || (i == days[month])){
				System.out.println("");
			}
		}	
		sc.close();
	}

}
