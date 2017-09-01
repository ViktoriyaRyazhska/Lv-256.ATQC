package edu.com.homework.tasksbook;

// Два натуральних числа називаються дружніми якщо кожне з них рівне сумі всіх дільників другого, окрім 
//сапмого цього числа. Знайдіть всі пари дружніх чисел, які лежать в діапазоеі між 200 та 300
public class Task560 {
	public void resolve() {
		System.out.println("Task: Two natural numbers are called friendly if every one of them equals sum"
				+ "of all deviders of the second one, not including this number. Find all pairs"
				+ "of friendly numbers between limit of 200 and 300");
		System.out.println();
		System.out.print( "This program shows you that in range between 200 and 300 only ");
		int i;
		int j;
		for (i = 200; i <= 300; i++) {
			int divider1 = 1;
			int sum1 = 0;
			while (divider1 < i) {
				if (i % divider1 == 0) {
					sum1 += divider1;
					divider1++;
				} else
					divider1++;
			}
			for (j = i + 1; j <= 300; j++) {
				int divider2 = 1;
				int sum2 = 0;
				while (divider2 < j) {
					if (j % divider2 == 0) {
						sum2 += divider2;
						divider2++;
					} else
						divider2++;
				}

				if (sum1 == j && sum2 == i)
					System.out.print(i + " and "+ j + " are friendly numbers.");
			}
		}
		return;
	}
}