package edu.com.homework.junit;

import java.util.ArrayList;
import java.util.List;

public class CheckInt {
	private List<Integer> values = new ArrayList<>();

	public CheckInt(List<Integer> values) {
		super();
		this.values = values;
	}

	public CheckInt() {
		super();
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
	
	public Integer findMin() {
			Integer minValue = this.values.get(0);
			for (Integer value : this.values) {
				if (value < minValue) {
					minValue = value;
				}
			}
			System.out.println("The min of three is: " + minValue);	
			return minValue;
		}
	public Integer findMax() {
		Integer maxValue = this.values.get(0);
		for (Integer value : this.values) {
			if (value > maxValue) {
				maxValue = value;
			}
		}
		System.out.println("The min of three is: " + maxValue);	
		return maxValue;
	}
		
		
	

}
