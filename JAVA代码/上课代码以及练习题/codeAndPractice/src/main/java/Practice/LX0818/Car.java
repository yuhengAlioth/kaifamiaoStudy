package Practice.LX0818;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818
 * @文件名称：Car
 * @时间：2023/08/18/14:09
 */
public class Car extends Vehicle{
    private int numDoors; // 车门数量

    public Car(String brand, int year, int numDoors) {
        super(brand, year);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("numDoors : " + numDoors);
    }

}

