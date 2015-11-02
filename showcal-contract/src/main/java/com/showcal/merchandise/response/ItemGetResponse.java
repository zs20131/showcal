/**
 * @(#)ItemGetResponse.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.merchandise.response;

import com.showcal.merchandise.domain.Item;
import com.showcal.platform.domain.CommentPost;
import com.xiniunet.framework.base.BaseResponse;

import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:05.
 *
 * @author 顾志雄
 */
public class ItemGetResponse extends BaseResponse {

    /**
     * 物料表信息
     */
    private Item item;
    //是否收藏
    private Boolean isCollection = false;
    private List<CommentPost> commentPostList;
    public List<CommentPost> getCommentPostList() {
        return commentPostList;
    }

    public void setCommentPostList(List<CommentPost> commentPostList) {
        this.commentPostList = commentPostList;
    }

    public Boolean getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Boolean isCollection) {
        this.isCollection = isCollection;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
