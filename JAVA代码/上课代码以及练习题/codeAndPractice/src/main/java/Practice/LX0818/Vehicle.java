package Practice.LX0818;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818
 * @文件名称：Vehicle
 * @时间：2023/08/18/14:03
 */
public class Vehicle {
    private String brand; // 品牌
    private  int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("brand : " + brand);
        System.out.println("year : " + year);
    }
}

