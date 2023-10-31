package com.kfm.first.entity;

/**
 * @作者：玉蘅
 * @项目名称：first
 * @包名：com.kfm.first.entity
 * @文件名称：Page
 * @代码功能：
 * @时间：2023/10/30/16:19
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库查询分页
 */
@Data
public class Page<T> implements Serializable {
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 当前表的总数
     */
    private long total;
    /**
     * 上一页的页码
     */
    private int prevNum;
    // 页数
    private int pageCount;
    /**
     * 下一页的页码
     */
    private int nextNum;

    /**
     * 是否存在上一页
     */
    private boolean hasPrev;
    /**
     * 是否存在下一页
     */
    private boolean hasNext;

    /**
     * 所有的页码信息
     */
    private int[] pageNumbers;

    private List<T> data;


    public Page(int pageNum, int pageSize, long total, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }


    public int getPrevNum() {
        return this.pageNum - 1;
    }

    public int getNextNum() {
        return this.pageNum + 1;
    }

    public int getPageCount() {
        return (int)(Math.ceil((double) this.total / this.pageSize));
    }

    public boolean getHasPrev() {
        // 如果是第一页就没有前一页
        return this.pageNum != 1 ;
    }

    public boolean getHasNext() {
        return this.pageNum != this.getPageCount();
    }

    public int[] getPageNumbers() {
        // 1,2,3,4,5
        int[] numbers = new int[getPageCount()];
        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = i;
        }
        return numbers;
    }


}
