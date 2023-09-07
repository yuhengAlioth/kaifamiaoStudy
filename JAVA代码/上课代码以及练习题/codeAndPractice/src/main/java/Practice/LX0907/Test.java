package Practice.LX0907;

import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：Test
 * @代码功能：测试
 * @时间：2023/09/07/20:03
 */
public class Test {
    public static void main(String[] args) {
        GameRoom gameRoom = new GameRoom();
        System.out.println("玩家1：手牌" + gameRoom.getPlayer1());
        System.out.println("玩家2：手牌" + gameRoom.getPlayer2());
        System.out.println("玩家3：手牌" + gameRoom.getPlayer3());
        System.out.println("剩余底牌：" + gameRoom.getBootomCards());

    }
}

