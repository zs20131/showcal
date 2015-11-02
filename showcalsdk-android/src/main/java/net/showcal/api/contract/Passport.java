package net.showcal.api.contract;


import java.io.Serializable;
import java.util.Date;

/**
 * 护照类
 * Created by june on 2014/7/22.
 */
public class Passport extends BasePO implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 承租人ID
     */
    private Long tenantId;
    /**
     * 承租人靓号
     */
    private Long tenantNumber;
    /**
     * 承租人名称
     */
    private String tenantName;
    /**
     * 承租人LOGO的URL
     */
    private String logo;

    /**
     * 管理员ID
     */
    private Long adminId;

    /**
     * 拥有者ID
     */
    private Long ownerId;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户的头像
     */
    private String avatar;
    /**
     * 员工ID
     */
    private Long employeeId;
    /**
     * 工号
     */
    private String employeeNumber;
    /**
     * 员工的照片
     */
    private String photo;
    /**
     * 领用日期
     */
    private Date issueTime;
    /**
     * 过期时间
     */
    private Date expireTime;
    /**
     * 注销时间
     */
    private Date revokeTime;
    /**
     * 注销类型
     */
    private String revokeType;
    /**
     * 领用IP
     */
    private String issueIP;
    /**
     * 领用设备
     */
    private Long issueClient;

    /**
     * 护照类型
     */
    private PassportTypeEnum type;

    public Passport() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public Date getRevokeTime() {
        return revokeTime;
    }

    public void setRevokeTime(Date revokeTime) {
        this.revokeTime = revokeTime;
    }

    public String getRevokeType() {
        return revokeType;
    }

    public void setRevokeType(String revokeType) {
        this.revokeType = revokeType;
    }

    public String getIssueIP() {
        return issueIP;
    }

    public void setIssueIP(String issueIP) {
        this.issueIP = issueIP;
    }

    public Long getIssueClient() {
        return issueClient;
    }

    public void setIssueClient(Long issueClient) {
        this.issueClient = issueClient;
    }

    public Long getTenantNumber() {
        return tenantNumber;
    }

    public void setTenantNumber(Long tenantNumber) {
        this.tenantNumber = tenantNumber;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public PassportTypeEnum getType() {
        return type;
    }

    public void setType(PassportTypeEnum type) {
        this.type = type;
    }
}
