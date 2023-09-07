package Practice.LX0907;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0907
 * @文件名称：GameRoom
 * @代码功能：斗地主游戏房间
 * @时间：2023/09/07/19:34
 */
public class GameRoom {
    private List player1 = new ArrayList<>(); // 储存第一个玩家的卡牌列表
    private List player2 = new ArrayList<>(); // 储存第一个玩家的卡牌列表
    private List player3 = new ArrayList<>(); // 储存第一个玩家的卡牌列表
    private List cardList = new ArrayList<>(); // 所有卡牌
    private List bootomCards; // 底牌

    public GameRoom(){
        String[] colors = {"♣","♦","♠","♥"};
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        // 将普通牌放入本次卡牌中
        for (int i = 0; i < 4; i++) { // 先循环花色
            String color = colors[i];
            for (int j = 0; j < 13; j++) { // 循环13张牌
                Card card = new Card(color,numbers[j],j + 1);
                cardList.add(card);
            }
        }
        Card bigKing = new Card("","🃏",100);
        Card smallKing = new Card("","🤡",50);

        // 将牌整合
        Collections.addAll(cardList,bigKing,smallKing);
        // 打乱扑克牌
        Collections.shuffle(cardList);

        //发牌
        for (int i = 0; i < cardList.size() - 3; i += 3) {
            player1.add(cardList.get(i));
            player2.add(cardList.get(i + 1));
            player3.add(cardList.get(i + 2));
        }

        // 底牌
        bootomCards = cardList.subList(cardList.size() - 3,cardList.size());

        // 排序手牌
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

    }

    public GameRoom(List player1, List player2, List player3, List cardList, List bootomCards) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.cardList = cardList;
        this.bootomCards = bootomCards;
    }



    /**
     * 获取
     * @return player1
     */
    public List getPlayer1() {
        return player1;
    }

    /**
     * 获取
     * @return player2
     */
    public List getPlayer2() {
        return player2;
    }

    /**
     * 获取
     * @return player3
     */
    public List getPlayer3() {
        return player3;
    }

    /**
     * 获取
     * @return cardList
     */
    public List getCardList() {
        return cardList;
    }

    /**
     * 获取
     * @return bootomCards
     */
    public List getBootomCards() {
        return bootomCards;
    }


}

