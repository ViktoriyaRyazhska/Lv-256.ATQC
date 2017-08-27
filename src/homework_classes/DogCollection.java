package homework_classes;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import homework_classes.Dog.breed;

public class DogCollection {
	
	
	public Set<Dog> Dogs;
	
	public DogCollection() {
		
		Dogs = new HashSet<Dog>() ;
	}
	
	public void AddDog(String name, breed b, Integer age) {
		Dog doge=new Dog();
		if(name!=null & age>0){
			doge.name=name;
			doge.br=b;
			doge.age=age;
			Dogs.add(doge);
		}
		
		else {
			System.out.println("Bad input");
		}
			
	}
	
	public String GetTheOldest() {
		Dog doge = new Dog();
		
		for(Dog d:Dogs){
			if(d.age>doge.age){
				doge=d;
			}
		}
		if(doge.name!=null) {
			return "The oldest dog is: "+doge.getName()+". It's breed is: "+doge.getBr()  ;
		}
		else {
			return "No dogs was found";
		}
		
	}

	public static void main(String[] args) {
		
		DogCollection d= new DogCollection();
		
		d.AddDog("Brovko",breed.haski,5);
		d.AddDog("HotDog",breed.taksa,3);
		d.AddDog("Gavkalo",breed.vivcharka,4);
		d.AddDog("Brovko",breed.haski,2);
		
		System.out.println(d.Dogs.toString());
		System.out.println(d.GetTheOldest());
	}

}
