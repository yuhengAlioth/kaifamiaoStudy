package Practice.LX0816;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：GeometryCalculator
 * @时间：2023/08/16/19:27
 */
public class GeometryCalculator {
    // 几何图形计算器 设计一个几何图形计算器，可以计算圆的面积和矩形的面积。创建名为 GeometryCalculator 的类，
    //包含以下实例方法：
    //calculateCircleArea(double radius) ：计算并返回圆的面积
    //calculateRectangleArea(double width, double height) ：计算并返回矩形的面积
    //完成计算圆的面积以及计算矩形的面积等功能。
    private double radius;
    private double width;
    private double height;

    public double getRadius(){
        return radius;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void calculateCircleArea(double radius){
        System.out.println(radius * radius * Math.PI);
    }
    public void calculateRectangleArea(double width, double height){
        System.out.println(width * height);
    }

    public static void main(String[] args) {
        GeometryCalculator js = new GeometryCalculator();
        js.calculateCircleArea(2);
        js.calculateRectangleArea(5,6);
    }
}

