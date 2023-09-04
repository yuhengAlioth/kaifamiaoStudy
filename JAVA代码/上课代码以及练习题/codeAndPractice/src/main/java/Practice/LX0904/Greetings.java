package Practice.LX0904;

import java.util.Date;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0904
 * @文件名称：Greetings
 * @枚举功能：问候语
 * @时间：2023/09/04/14:37
 */
public enum Greetings {
    GREETINGS();
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Greetings() {
        Date date = new Date();
        int hour = date.getHours();

        if (hour > 6 && hour <= 8){
            this.message = "早上好！";
        } else if (hour > 8 && hour <= 11) {
            this.message = "上午好！";
        } else if (hour > 11 && hour <= 13) {
            this.message = "中午好！";
        }else if (hour > 13 && hour <= 18) {
            this.message = "下午好！";
        }else if (hour > 18 && hour <= 22) {
            this.message = "晚上好！";
        }else {
            this.message = "凌晨好！";
        }
    }
}
