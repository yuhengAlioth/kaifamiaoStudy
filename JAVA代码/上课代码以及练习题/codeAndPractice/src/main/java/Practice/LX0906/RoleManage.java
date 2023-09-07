package Practice.LX0906;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0906
 * @文件名称：RoleManage
 * @代码功能：角色管理类
 * @时间：2023/09/06/15:23
 */
public class RoleManage {
    private final ArrayList arrayList = new ArrayList();

    public RoleManage() {
        addRole(new Role("魈","风",5,1,90));
        addRole(new Role("枫原万叶","风",5,0,90));
        addRole(new Role("胡桃","火",5,1,89));
        addRole(new Role("夜兰","水",5,1,89));
        addRole(new Role("雷电将军","雷",5,0,89));
        addRole(new Role("纳西妲","草",5,1,89));
        addRole(new Role("神里凌华","冰",5,0,90));
        addRole(new Role("行秋","水",4,6,89));
    }

    public void addRole(Role role) {
        arrayList.add(role);
    }

    public void showAll() {
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
        arrayList.forEach(obj -> System.out.println(obj));
    }
    public void gradeSort(){
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Role r1 = (Role) o1;
                Role r2 = (Role) o2;
                return r1.getGrade() - r2.getGrade();
            }
        });
    }
    public void lifeSort(){
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Role r1 = (Role) o1;
                Role r2 = (Role) o2;
                return r1.getLife() - r2.getLife();
            }
        });
    }
    public void removeGrade(int num){
        // 获取每一个对象，然后获取他的level属性判断是否小于level 小于就删除
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Role role = (Role)iterator.next();
            if (role.getGrade() < num) {
                iterator.remove();
            }
        }
    }

}

