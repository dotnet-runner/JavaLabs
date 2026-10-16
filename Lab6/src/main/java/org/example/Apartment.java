package org.example;

public class Apartment {
    private String address;
    private int rooms;
    private double area;


    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Apartment(String address, int rooms, double area, int number) {
        this(address, rooms, area);
        setNumber(number);
    }



































    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        if(address.isBlank())
            return;
        this.address = address;
    }

    public int getRooms() {
        return rooms;
    }
    public void setRooms(int rooms) {
        if(0 > rooms)
            return;
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        if(0 > area)
            return;
        this.area = area;
    }

    public Apartment(String address, int rooms, double area) {
        setAddress(address);
        setRooms(rooms);
        setArea(area);
    }

    public double pricePerSquareMeter(double totalPrice) {
        return Math.round(totalPrice / area * 100.0) / 100.0;
    }
}
