/**
 * @(#)QuestionFindResponse.java
 *
 * Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 *
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.service.response;

import com.showcal.service.domain.Question;
import com.xiniunet.framework.base.BaseFindResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 顾志雄 on 2015-09-15 13:46:55.
 * @author 顾志雄
 */
public class QuestionFindResponse extends BaseFindResponse<Question> {

    private List<Map<Long,String>> maps=new ArrayList<>();

    public List<Map<Long, String>> getMaps() {
        return maps;
    }

    public void setMaps(List<Map<Long, String>> maps) {
        this.maps = maps;
    }
}
