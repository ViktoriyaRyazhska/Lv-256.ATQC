

/**
 * TaskBook
 * Task 178b  
 * ��� ��������� ����� n, a_1...a_n. ��������� ������� ����� a_k  ����������� a_1...a_n ������� 3 � ��������� 5.
 * 
 * @author Khrystyna Terletska
 *
 **/

import java.util.HashSet;
import java.util.Set;

public class Task178b {
	public void resolve() {
		// ��������� Set � ������ � ����� �����
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(3);
		numbers.add(4);
		numbers.add(9);
		numbers.add(12);
		numbers.add(16);
		numbers.add(34);
		numbers.add(36);
		numbers.add(37);
		numbers.add(38);
		numbers.add(39);
		numbers.add(64);

		checkNumber(numbers); // ��������� ����� checkNumber � �������� � ����� Set � �������
	}

	public int checkNumber(Set<Integer> numbers) {

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
