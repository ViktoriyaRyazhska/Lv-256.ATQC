package com.academy.softserve.task_06_test_Khrystyna;

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

        Task178b task178b = new Task178b();
        try {
            task178b.getNaturalNumberCount(numbers); // ��������� ����� checkNumber � �������� � ����� Set � �������
        } catch (IllegalArgumentException e) {
            System.out.println("");
        }
    }

    public int getNaturalNumberCount(Set<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("You didn't entered value. Please enter digital value greater than 0");
        }
        System.out.println("Determine the number of sequence members that are multiples of 3 and not multiple 5");

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