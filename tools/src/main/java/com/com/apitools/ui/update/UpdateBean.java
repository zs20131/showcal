package com.com.apitools.ui.update;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2015-07-27.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class UpdateBean implements Serializable {
    /**
     * 版本号(1,2,3...)
     */
    private Integer number;

    /**
     * 版本名称(1.0.0)
     */
    private String version;

    /**
     * 版本升级说明
     */
    private String summary;

    /**
     * 发布日期
     */
    private Date date;

    /**
     * 新版本下载路径
     */
    private String url;

    /**
     * 新版本大小(字节)
     */
    private int size;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
