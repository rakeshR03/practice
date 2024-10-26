package Concept.ComparableTesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(1, "i10");
        Vehicle v2 = new Vehicle(12, "i20");
        Vehicle v3 = new Vehicle(3, "swift");
        Vehicle v4 = new Vehicle(14, "tiago");
        Vehicle v5 = new Vehicle(5, "punch");

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(v1);
        vehicleList.add(v2);
        vehicleList.add(v3);
        vehicleList.add(v4);
        vehicleList.add(v5);

        System.out.println(vehicleList);
        Collections.sort(vehicleList);
        System.out.println("After sorting: ");
        System.out.println(vehicleList);
    }
}

class Vehicle implements Comparable<Vehicle> {
    int id;
    String model;

    Vehicle(int id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return this.id - vehicle.id;
    }

    @Override
    public String toString() {
        return this.id + " " + this.model;
    }
}
