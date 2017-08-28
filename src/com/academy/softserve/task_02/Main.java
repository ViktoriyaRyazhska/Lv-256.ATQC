package com.academy.softserve.task_02;

public class Main {
    public static void main(String[] args) {
        DogCollection dogCollection = new DogCollection();
        dogCollection.addDog(new Dog("b", Breed.TERIER, 5));
        dogCollection.addDog(new Dog("a", Breed.VOLF, 5));
        dogCollection.addDog(new Dog("b", Breed.VOLF, 5));
        dogCollection.addDog(new Dog("bv", Breed.VOLF, 9));
        dogCollection.addDog(new Dog("b", Breed.VOLF, 5));
        dogCollection.addDog(new Dog("c", Breed.SPANIEL, 12));
        //System.out.println(dogCollection);
        dogCollection.oldestDog();

    }
}
