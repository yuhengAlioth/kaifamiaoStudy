package Practice.LX0904;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0904
 * @文件名称：WenHou
 * @枚举功能：根据时间显示问候语
 * @时间：2023/09/04/14:05
 */
public enum WenHou {
    ZS("早上好"),
    SW("上午好"),
    ZW("中午好"),
    XW("下午好"),
    WS("晚上好");
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    WenHou(String message) {
        this.message = message;
    }
}
