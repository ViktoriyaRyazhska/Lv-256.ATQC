package homework_classes;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import homework_classes.Dog.breed;


public class DogCollectionTest {

	@Test
	public void TestAddDog(){
		DogCollection dog = new DogCollection();
		dog.AddDog("brovko", breed.vivcharka, 3);
		
		Set<Dog> Doges=new HashSet<Dog>() ;
		Dog d =new Dog();
		d.name="brovko";
		d.br=breed.vivcharka;
		d.age=3;
		Doges.add(d);
		
		
		Assert.assertEquals(Doges, dog.Dogs);
		
	}
	
	@Test
	public void TestGetTheOldest(){
		DogCollection dog = new DogCollection();
		Dog d =new Dog();
		d.name="brovko";
		d.br=breed.vivcharka;
		d.age=3;
		dog.Dogs.add(d);

		Dog d1 =new Dog();
		d.name="brovko_oldest";
		d.br=breed.vivcharka;
		d.age=4;
		dog.Dogs.add(d1);
		
		Assert.assertEquals("The oldest dog is: brovko_oldest. It's breed is: vivcharka", dog.GetTheOldest());
	}
	
	@Test
	public void TestNoDuplicates(){
		DogCollection dog = new DogCollection();
		dog.AddDog("brovko", breed.vivcharka, 3);
		dog.AddDog("brovko", breed.vivcharka, 4);
		
		Assert.assertEquals(1, dog.Dogs.size());
	}
	
}
