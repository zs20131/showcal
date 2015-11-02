package com.showcal.foundation.request;

import com.xiniunet.framework.base.BaseRequest;

/**
 * Created on 2014/11/27.
 *
 * @author 吕浩
 * @version 1.0.0
 */
public class FileGetRequest extends BaseRequest {
	/**
	 * 要获取文件的URL
	 */
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
