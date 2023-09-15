package Practice.LX0915;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0915
 * @文件名称：Game
 * @代码功能：
 * @时间：2023/09/15/19:07
 */
@Data
@AllArgsConstructor // 所有字段的有参构造
@NoArgsConstructor // 无参构造
public class Game {

    private String name;
    private double star;
    private int size;
    private double money;
}
