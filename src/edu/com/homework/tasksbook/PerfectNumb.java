package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumb {
	private Integer value;

	public PerfectNumb() {
	}

	public PerfectNumb(Integer value) {
		if (value > 0) {
			this.value = value;
		}
	}

	public List<Integer> perfectNumbers() {
		List<Integer> perfectValues = new ArrayList<>();
		for (int i = 1; i < this.value; i++) {
			int sum = 0;
			for (int n = 1; n < i; n++) {
				if (i % n == 0)
					sum += n;
			}
			if (i == sum) {
				perfectValues.add(i);
			}
		}

		return perfectValues;

	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		if (value > 0) {
			this.value = value;
		}
	}

}
