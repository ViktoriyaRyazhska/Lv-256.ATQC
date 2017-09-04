package com.academy.softserve.task_06_test_Khrystyna;
/**
 * TaskBook
 * Task 178w
 * Äàí³ íàòóðàëüí³ ÷èñëà n, a_1...a_n. Âèçíà÷èòè ê³ëüê³ñòü ÷ëåí³â a_k  ïîñë³äîâíîñò³ a_1...a_n, ÿê³ º êâàäðàòàìè ïàðíèõ ÷èñåë.
 *
 * @author Khrystyna Terletska
 *
 */

import java.util.HashSet;
import java.util.Set;

public class Task178w {
    public void resolve() {
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
        Task178w task178w = new Task178w();
        try {
            task178w.getNaturalNumberCount(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNaturalNumberCount(Set<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("You didn't entered value. Please enter digital value greater than 0");
        }
        System.out.println("Determine the number of members of a sequence that are squares of even numbers");

        int totalCount = 0;

        for (int n : numbers) {
            int value = n;

            if (Math.sqrt(value) % 2 == 0) {

                System.out.println("Value is - " + value);
                totalCount++;
            }
        }
        System.out.println("Total count " + totalCount);
        return totalCount;
    }
}