package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

import java.util.List;

/**
 * Created on 2014/11/3.
 *
 * @author 吕浩
 * @version 1.0.0
 */
public class AttachmentUpdateBusinessRequest extends BaseRequest {
	private Long businessId;
	private List<Long> ids;

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
