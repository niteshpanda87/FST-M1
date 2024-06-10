public class Car {
    String color;
    String transimission;
    int make;
    int tyres;
    int doors;

    Car() {
        tyres = 4;
        doors = 2;
    }

    public void displayCharacterstics(){
        System.out.println("Color of the car is: " + color);
        System.out.println("Transmission of the car is: " + transimission);
        System.out.println("Make of the car is: " + make);
        System.out.println("Tyres of the car is: " + tyres);
        System.out.println("Doors of the car is: " + doors);
    }
    public void accelarate(){
        System.out.println("Car is Moving Forward");
    }
    public void brake(){
        System.out.println("Car has Stopped");
    }

}
