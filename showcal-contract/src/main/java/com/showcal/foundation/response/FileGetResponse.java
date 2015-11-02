package com.showcal.foundation.response;

import com.xiniunet.framework.base.BaseResponse;

/**
 * Created on 2014/11/27.
 *
 * @author 吕浩
 * @version 1.0.0
 */
public class FileGetResponse extends BaseResponse {
	/**
	 * 字节数组
	 */
	private byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
