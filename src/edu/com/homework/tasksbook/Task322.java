package edu.com.homework.tasksbook;
/**
 * TaskBook
 * Task 322  
 * Find the number with the  maximum sum of dividers in range from 1 to 10000
 * 
 * @author Petro Hlukhovets'kyi
 *
 */
public class Task322 {

	public String MaxSum() {
		Integer maxS = 0;
		Integer maxN = 0;
		for (int i = 1; i <= 10000; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum > maxS) {
				maxS = sum;
				maxN = i;
			}
		}
		return "Number with the biggest sum of dividers is:" + maxN + "\nSum of its dividers is:" + maxS;
	}

}
