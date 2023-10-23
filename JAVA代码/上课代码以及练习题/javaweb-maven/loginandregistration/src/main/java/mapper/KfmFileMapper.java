package mapper;

import model.KfmFile;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @作者：玉蘅
 * @项目名称：javaweb-maven
 * @包名：mapper
 * @文件名称：KfmFileMapper
 * @代码功能：对kfm_file表的增删改操作
 * @时间：2023/10/21/17:04
 */

public class KfmFileMapper {

    /**
     * 查询所有信息
     * @return
     */
    public List<KfmFile> selectAll() {
        QueryRunner queryRunner = new QueryRunner();
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);

        String sql = "select * from kfm_file";
        List<KfmFile> query = null;
        try {
            query = queryRunner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<>(KfmFile.class,processor));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return query;
    }

    /**
     * 插入上传文件的信息
     * @param fileName 文件名称
     * @param size 文件大小
     * @param createTime 上传时间
     * @param uploadIp 上传的IP
     * @param downloadLink 下载链接
     * @return true表示插入成功
     */
    public boolean insertUploadFileInfo(String name, Long size,String createTime,String uploadIp, String downloadLink){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into kfm_file(name, size, create_time, upload_ip, download_link) values (?,?,?,?,?)";
        try {
            queryRunner.update(DataSourceUtils.getConnection(), sql, name, size, createTime, uploadIp, downloadLink);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

