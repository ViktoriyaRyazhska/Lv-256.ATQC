package input_numbers;


import java.awt.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class IntNum  {

	private Integer MaxNumber;
	private Integer MinNumber;
	Set<Integer> numberset;
	
	public IntNum(){
		numberset= new HashSet<Integer>();
		
	}
	
	public int getMax(){
		return MaxNumber;
	}
	
	public int getMin(){
		return MinNumber;
	}
	
	public void input(){
		
		Integer temp=null;
		
		try {
			System.out.println("Enter number: ");
			Scanner scanner = new Scanner(System.in);
			temp = scanner.nextInt();
			numberset.add(temp);
		} catch (Exception e) {
			System.out.println("Input error");
		}
		
		if(MinNumber==null){
			MinNumber=temp;
		}
		
		if(MaxNumber==null){
			MaxNumber=temp;
		}
	
	}
	
	public void findBoundary(){
		
		if(numberset.isEmpty()){
			System.out.println("No numbers were input");
		}
		
		for(Integer i:numberset){
			if(i<=MinNumber){
				MinNumber=i;
			}
			
			if(i>=MaxNumber){
				MaxNumber=i;
			}
		}
	
	}
	
	
}
