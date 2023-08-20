package Practice.LX0818;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818
 * @文件名称：Motorcycle
 * @时间：2023/08/18/14:11
 */
public class Motorcycle extends Vehicle {
    private boolean hasSideCar; // 是否有边
    public Motorcycle(String brand, int year, boolean hasSideCar) {
        super(brand, year);
        this.hasSideCar = hasSideCar;
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("是否有边车？" + (hasSideCar ? "有" : "没有"));
    }
}

