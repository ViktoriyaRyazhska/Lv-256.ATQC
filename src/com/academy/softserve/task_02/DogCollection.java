package com.academy.softserve.task_02;

import java.util.ArrayList;
import java.util.List;

public class DogCollection {
    List<Dog> dogList = new ArrayList();

    public List<Dog> getDogList() {
        return dogList;
    }

    public void setDogList(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public String toString() {
        return "DogCollection{" +
                "arrayList=" + dogList +
                '}';
    }

    public void addDog(Dog dog) {
        boolean exist = true;
        for (int i = 0; i < dogList.size(); i++) {
            if (dogList.get(i).getName().equals(dog.getName())) {
                System.out.println("Dog with name \"" + dog.getName() + "\" already exist");
                exist = false;
            }
        }
        if (exist == true) {
            dogList.add(dog);
            System.out.println("Element " + dog.toString() + " add");

        }
    }
    void oldestDog(){
        Dog oldestDog=dogList.get(0);
        for (int i = 0; i < dogList.size(); i++) {
            if (dogList.get(i).getAge()>oldestDog.getAge()){
                oldestDog=dogList.get(i);
            }
        }
        System.out.println("Oldest dog: "+oldestDog.toString());
    }
}
