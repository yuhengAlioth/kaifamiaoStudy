package model;

import lombok.Data;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：model
 * @文件名称：KfmFile
 * @代码功能：数据库kfm_file表的实体类
 * @时间：2023/10/21/9:25
 */
@Data
public class KfmFile {
    private int id; // 编号
    private String name; // 文件名称
    private Long size; // 文件大小
    private String createTime; // 上传时间
    private String uploadIp; // 上传者IP
    private String downloadLink; // 下载链接
}

