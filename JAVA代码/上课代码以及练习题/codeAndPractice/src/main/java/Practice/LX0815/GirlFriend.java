package Practice.LX0815;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0815
 * @文件名称：GirlFriend
 * @时间：2023/08/15/19:22
 */
public class GirlFriend {
    String name;
    double height;
    double weight;
    public void wash(){
        System.out.println("女朋友帮我洗衣服");
    }
    public void cook(){
        System.out.println("女朋友给我做饭");
    }
    public GirlFriend(String name,double height,double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
        System.out.println("我女朋友叫" + name + ",身高" + height + "厘米,体重" + weight + "斤");
    }
}

