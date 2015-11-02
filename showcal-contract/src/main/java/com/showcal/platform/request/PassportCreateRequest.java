package com.showcal.platform.request;

import com.xiniunet.framework.base.BaseRequest;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * Created by DEV001 on 2014/8/5.
 */
public class PassportCreateRequest extends BaseRequest {
    /**
     * 承租人ID
     */
//    @NotNull(message = "承租人ID不能为空")
//    @Min(value = 1,message = "承租人ID不合法")
    private long tenantId;

    /**
     * 用户ID
     */
    private long userId;
    /**
     * 领用日期
     */
    private Date issueTime;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 领用IP
     */
    @Length(min = 0, max = 50,message = "领用IP长度不合法")
    private String issueIP;
    /**
     * 领用设备
     */
    private long issueClient;

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getIssueIP() {
        return issueIP;
    }

    public void setIssueIP(String issueIP) {
        this.issueIP = issueIP;
    }

    public long getIssueClient() {
        return issueClient;
    }

    public void setIssueClient(long issueClient) {
        this.issueClient = issueClient;
    }
}
