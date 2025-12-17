package com.yuko;

/**
 * Клас-модель для представлення одного запису вилову з бази даних.
 */
public class CatchEntry {
    private int id;
    private String fisherman;
    private String fish;
    private double weight;
    private String caughtAt;

    public CatchEntry(int id, String fisherman, String fish, double weight, String caughtAt) {
        this.id = id;
        this.fisherman = fisherman;
        this.fish = fish;
        this.weight = weight;
        this.caughtAt = caughtAt;
    }

    // Геттери (необхідні для автоматичного перетворення в JSON фреймворком Jackson)
    public int getId() { return id; }
    public String getFisherman() { return fisherman; }
    public String getFish() { return fish; }
    public double getWeight() { return weight; }
    public String getCaughtAt() { return caughtAt; }

    // Сеттери (не обов'язково, але можна додати)
    public void setId(int id) { this.id = id; }
    public void setFisherman(String fisherman) { this.fisherman = fisherman; }
    public void setFish(String fish) { this.fish = fish; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setCaughtAt(String caughtAt) { this.caughtAt = caughtAt; }
}