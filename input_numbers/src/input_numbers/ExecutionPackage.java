package input_numbers;

import java.util.ArrayList;
import java.util.List;

public class ExecutionPackage {

	public static void main(String[] args) {
		
		FloatNum f= new FloatNum();
		f.inputNumbers();
		
		IntNum i= new IntNum();
		
		for(int k=0;k<3;k++){
			i.input();
		}
		i.findBoundary();
		
	/*	List<Object> list =new ArrayList<Object>();
		list.add(i);
		for(Object j:list)
		{
			
		*/}
	}
	
	
	
	

}
