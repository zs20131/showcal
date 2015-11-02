package net.showcal.api.contract;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * Created on 2014/04/03.
 * @author 沈振家
 * @version 0.1.0
 */
public class BasePO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long rowVersion;
    private Boolean isDeleted;
    private Long createdBy;
    private Timestamp creationTime;
    private Long lastUpdatedBy;
    private Timestamp lastUpdateTime;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
    }
}
