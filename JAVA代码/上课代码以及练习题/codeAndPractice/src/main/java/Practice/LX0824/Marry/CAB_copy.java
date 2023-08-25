package Practice.LX0824.Marry;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0824.Marry
 * @文件名称：CAB_copy
 * @代码功能：判断结婚
 * @时间：2023/08/24/22:19
 */
public class CAB_copy {
    public static void main(String[] args) {

        Person_copy peo1 = new Person_copy("田宝臣",'男',22,false);
        Person_copy peo2 = new Person_copy("聂墐宸",'女',22,false);

        System.out.println(canMarry(peo1, peo2) ? "可以结婚" : "不可以结婚");
    }

    public static boolean canMarry(Person_copy peo1,Person_copy peo2){

        boolean isAge1 = peo1.getAge() >= 22 && peo2.getAge() >=20;
        boolean isAge2 = peo1.getAge() >= 20 && peo2.getAge() >=22;

        boolean isGender1 = peo1.getGender() == '男' && peo2.getGender() == '女';
        boolean isGender2 = peo1.getGender() == '女' && peo2.getGender() == '男';

        if (!peo1.getIsMarry() && !peo2.getIsMarry()){
            if (isAge1 || isAge2){
                if (isGender1 || isGender2){
                    return true;
                }
            }
        }
        return false;
    }
}

