package edu.com.homework.tasksbook;

/**
 * TaskBook
 * Task 178b  
 * ��� ��������� ����� n, a_1...a_n. ��������� ������� ����� a_k  ����������� a_1...a_n ������� 3 � ��������� 5.
 * 
 * @author Khrystyna Terletska
 *
 **/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task178b {
	public void resolve() {
		Task178b task = new Task178b();
		System.out.println("Determine the number of sequence members that are multiples of 3 and not multiple 5");
		System.out.println("Please enter the numbers (When you type 'quit' word counting numbers to stop)");

		Scanner scan = new Scanner(System.in);
		Set<Integer> numbers = new HashSet<Integer>();

		// ������� ����� ��� ���� ��� ����� �� �� ��������� ��� � ������ �� ��� �
		boolean shouldStopReading = false;
		// ���� �� �������� ������� �� �������
		while (!shouldStopReading) {
			try {
				// ������ �������� �����
				String text = scan.next();
				// ���������� �� ��� ����� ����� ����� quit
				if (text.equals("quit")) {
					shouldStopReading = true; // ������� �������� ����� � ��� ��� �������� ����������, �� � ��� ����
												// ���� �� �������� false �� �� ����� �������
				} else {
					// ���������� �������� ����� � ���� ��������
					int number = Integer.parseInt(text);
					// ������ ������� ���������� ����� � ��������
					numbers.add(number);
				}
			} catch (Exception e) {
				System.out.println("Incorrect input value");
			}
		}

		int result = task.getNaturalNumberCount(numbers);
	}

	public int getNaturalNumberCount(Set<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("You didn't entered value. Please enter digital value greater than 0");
		}
		int totalCount = 0; // ��������� ����� totalCount, ��� ���� ������������ ������� �����, ��
		// ������������ �����

		for (int n : numbers) {
			int value = n; // ���������� �� �������� �� ������� � �������� �������

			if ((value % 3 == 0) && !(value % 5 == 0)) {

				System.out.println("Value is - " + value);

				totalCount = totalCount + 1; // �������� �������� ��������, �� ������������ �����
			}

		}
		System.out.println("Total count " + totalCount);

		return totalCount;
	}
}
