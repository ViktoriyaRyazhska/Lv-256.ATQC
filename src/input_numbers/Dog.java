package input_numbers;

import java.util.Set;


 class Dog {
	
	String name;
	Integer age;
	breed br;
	
	public enum breed {
		taksa,
		haski,
		vivcharka;
	}
	
	
	
	public Dog() {
	
		name=null;
		age=0;
		
	}
	
	
	
	public String getName() {
		return name;
	}



	public Integer getAge() {
		return age;
	}



	public breed getBr() {
		return br;
	}



	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Dog))return false;
	    Dog otherMyClass = (Dog)other;
	    if(otherMyClass.name==this.name ){
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	@Override
	 public int hashCode() {
	      return 12324;
	   }
	
	@Override
	public String toString() {
		return "Name: "+name+" Breed: "+br+" Age: "+age;
	}
	

	public static void main(String[] args) {
		
	
	
	
	}
}

