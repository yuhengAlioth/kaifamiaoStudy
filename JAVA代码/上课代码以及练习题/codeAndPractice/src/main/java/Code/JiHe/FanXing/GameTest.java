package Code.JiHe.FanXing;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.FanXing
 * @文件名称：GameTest
 * @代码功能：测试泛型
 * @时间：2023/09/08/11:13
 */
public class GameTest {
    public static void main(String[] args) {
        ArrayList<Game> gameList = new ArrayList<>();
        Game game1 = new Game("永杰无间",99);
        Game game2 = new Game("刺客信条",199);
        Game game3 = new Game("大多数",20);
        gameList.add(game1);
        gameList.add(game2);
        gameList.add(game3);


        Comparator<Game> gameComparator = new Comparator<Game>() {
            @Override
            public int compare(Game o1, Game o2) {
                return o1.compareTo(o2);
            }
        };
        gameList.sort(gameComparator);
        System.out.println(gameList);
    }
}

