package cn.aliothstar.entity;

import lombok.Data;

/**
 * @作者：玉蘅
 * @项目名称：javaweb
 * @包名：cn.aliothstar.entity
 * @文件名称：UploadLog
 * @代码功能：上传文件日志表
 * @时间：2023/10/18/19:12
 */
@Data
public class UploadLog {
    private int id;
    private String ip;
    private int port;
    private String file_name;
    private String file_type;
    private String file_size;
    private String file_upload_time;
    private String link;
}

