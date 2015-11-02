package net.showcal.api.request.mobile;

import net.showcal.api.ApiRuleException;
import net.showcal.api.XiniuRequest;
import net.showcal.api.internal.util.XiniuHashMap;
import net.showcal.api.internal.util.RequestCheckUtils;
import net.showcal.api.domain.mobile.*;
import java.util.Map;
import net.showcal.api.response.mobile.ArticlePostResponse;


/**
* <p/>
* <pre>
 * ***************************************************************
 *  Copyright (c) 2014 –苏州犀牛网络科技有限公司
    *  Title: net.showcal.mobile.helper.MobileHelperImpl
    *  Description: mobile Request
    *  @since
    *  @author 顾志雄
    * ***************************************************************
 * </pre>
*/
public class ArticlePostRequest implements XiniuRequest<ArticlePostResponse> {
    private XiniuHashMap udfParams = new XiniuHashMap();
    /**
     * 获取API名称
     */
    @Override
    public String getApiMethodName() {
        return "mobile.article.post";
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 封面图片ID
     */
    private Long coverId;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 文章内容
     */
    private String articlebody;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public Long getCoverId(){
        return coverId;
    }

    public void setCoverId(Long coverId){
        this.coverId=coverId;
    }

    public String getSummary(){
        return summary;
    }

    public void setSummary(String summary){
        this.summary=summary;
    }

    public String getArticlebody(){
        return articlebody;
    }

    public void setArticlebody(String articlebody){
        this.articlebody=articlebody;
    }

    @Override
    public Map<String, String> getTextParams() {
        XiniuHashMap txtParams = new XiniuHashMap();
                txtParams.put("title", this.title);
                txtParams.put("coverId", this.coverId);
                txtParams.put("summary", this.summary);
                txtParams.put("articlebody", this.articlebody);
        if(this.udfParams != null) {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    @Override
    public Long getTimestamp() {
    return null;
    }

    @Override
    public void setTimestamp(Long timestamp) {

    }

    @Override
    public Class getResponseClass() {
        return ArticlePostResponse.class;
    }

    @Override
    public void check() throws ApiRuleException {
    }

    @Override
    public Map<String, String> getHeaderMap() {
        return null;
    }

    @Override
    public void putOtherTextParam(String key, String value) {
        this.udfParams.put(key,value);
    }
}