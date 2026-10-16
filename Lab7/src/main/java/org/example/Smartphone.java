package org.example;

public class Smartphone {
    private String model;
    private int memory;
    private double cameraMP;
    private static int totalPhones;
    private static int totalMemory;

    public static int getTotalPhones() {
        return totalPhones;
    }
    public static int getTotalMemory() {
        return totalMemory;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        if(model.isBlank())
            return;
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        if(0 > memory)
            return;
        totalMemory += memory - this.memory;
        this.memory = memory;
    }

    public double getCameraMP() {
        return cameraMP;
    }
    public void setCameraMP(double cameraMP) {
        if(0 > cameraMP)
            return;
        this.cameraMP = cameraMP;
    }

    public Smartphone(String model, int memory, double cameraMP) {
        setModel(model);
        setMemory(memory);
        setCameraMP(cameraMP);
        totalPhones++;
    }

    public static double getAverageMemory() {
        return (getTotalMemory() * 1.0) / getTotalPhones();
    }
    public static void printStatistic() {
        System.out.printf("Всего телефонов: %d, всего памяти: %d, среднее количество памяти в телефоне: %.2f", getTotalPhones(), getTotalMemory(), getAverageMemory());
    }
}
