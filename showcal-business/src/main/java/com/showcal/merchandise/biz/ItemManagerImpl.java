/**
 * @(#)ItemManagerImpl.java Copyright (c) 2014-2014  苏州犀牛网络科技有限公司 版权所有
 * xiniunet. All rights reserved.
 * <p/>
 * This software is the confidential and proprietary
 * information of  xiniunet.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with xiniunet.
 */
package com.showcal.merchandise.biz;

import com.showcal.cms.dal.ArticleStatisticsMapper;
import com.showcal.cms.domain.ApproveResultEnum;
import com.showcal.cms.domain.Article;
import com.showcal.cms.domain.CollectionEnum;
import com.showcal.cms.domain.StatisticsTypeEnum;
import com.showcal.cms.po.ArticlePO;
import com.showcal.cms.po.ArticleStatisticsPO;
import com.showcal.cms.request.*;
import com.showcal.cms.response.ArticleChangeOrderResponse;
import com.showcal.cms.response.ArticleGetResponse;
import com.showcal.cms.svc.Message;
import com.showcal.foundation.request.FilePathGetRequest;
import com.showcal.foundation.request.IdsGetRequest;
import com.showcal.foundation.response.FilePathGetResponse;
import com.showcal.foundation.service.FoundationService;
import com.showcal.merchandise.dal.ItemDetailMapper;
import com.showcal.merchandise.dal.ItemEcommerceMapper;
import com.showcal.merchandise.dal.ItemMapper;
import com.showcal.merchandise.dal.ItemPictureMapper;
import com.showcal.merchandise.domain.*;
import com.showcal.merchandise.po.ItemDetailPO;
import com.showcal.merchandise.po.ItemEcommercePO;
import com.showcal.merchandise.po.ItemPO;
import com.showcal.merchandise.po.ItemPicturePO;
import com.showcal.merchandise.request.*;
import com.showcal.merchandise.response.*;
import com.showcal.platform.biz.CommentPostManager;
import com.showcal.platform.biz.SysUserManager;
import com.showcal.platform.dal.CollectionMapper;
import com.showcal.platform.domain.CommentPost;
import com.showcal.platform.domain.SysUser;
import com.showcal.platform.po.CollectionPO;
import com.showcal.platform.request.CollectionCreateRequest;
import com.showcal.platform.request.CollectionFindRequest;
import com.showcal.platform.request.CommentPostFindRequest;
import com.showcal.platform.request.SysUserGetRequest;
import com.showcal.platform.response.CommentPostFindResponse;
import com.showcal.platform.response.SysUserGetResponse;
import com.showcal.service.domain.SexEnum;
import com.xiniunet.framework.base.BaseManagerImpl;
import com.xiniunet.framework.base.BaseResponse;
import com.xiniunet.framework.exception.ErrorType;
import com.xiniunet.framework.security.Passport;
import com.xiniunet.framework.util.excel.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 顾志雄 on 2015-09-24 09:54:06.
 *
 * @author 顾志雄
 */
@Transactional
@Service("MerchandiseItemManager")
public class ItemManagerImpl extends BaseManagerImpl implements ItemManager {

    @Autowired
    private FoundationService foundationService;

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemDetailMapper itemDetailMapper;
    @Autowired
    private ItemEcommerceMapper itemEcommerceMapper;
    @Autowired
    private ItemPictureManager itemPictureManager;
    @Autowired
    private ClazzManager clazzManager;
    @Autowired
    private ArticleStatisticsMapper statisticsMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private CommentPostManager commentPostManager;
    @Autowired
    private SysUserManager sysUserManager;
    @Autowired
    private ItemPictureMapper itemPictureMapper;


    /**
     * 根据Id获取物料表
     *
     * @param request  获取物料表请求
     * @param passport 用户护照
     * @return 获取物料表应答
     */
    @Override
    public ItemGetResponse get(ItemGetRequest request, Passport passport) {
        ItemPO entity = itemMapper.getById(request.getId(), passport);
        ItemGetResponse response = new ItemGetResponse();
        if (entity != null) {
            Item item = this.getMapper().map(entity, Item.class);
            if (item.getClassId() != null) {
                ClazzGetRequest clazzGetRequest = new ClazzGetRequest();
                clazzGetRequest.setId(item.getClassId());
                ClazzGetResponse clazzGetResponse = clazzManager.get(clazzGetRequest, passport);
                if (clazzGetResponse.getClazz() != null) {
                    item.setCategoryName(clazzGetResponse.getClazz().getName());
                }
            }
            if (item.getPictureId() != null) {
                FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                filePathGetRequest.setId(item.getPictureId());
                FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                item.setAvatarurl(filePathGetResponse.getUrl());
            }
            ItemEcommercePO itemEcommercePO = itemEcommerceMapper.getById(request.getId(), passport);
            if (itemEcommercePO != null) {
                item.setOriginalPrice(itemEcommercePO.getOriginalPrice());
                item.setCurrentPrice(itemEcommercePO.getCurrentPrice());
            }
            ItemDetailPO itemDetailPO = itemDetailMapper.getById(request.getId(), passport);
            if (itemDetailPO != null) {
                item.setContext(itemDetailPO.getText());
            }
            ItemPictureFindRequest itemPictureFindRequest = new ItemPictureFindRequest();
            itemPictureFindRequest.setItemId(request.getId());
            ItemPictureFindResponse itemPictureFindResponse = itemPictureManager.find(itemPictureFindRequest, passport);
            if (itemPictureFindResponse.getResult().size() > 0) {
                List<ItemPicture> itemPictures=new ArrayList<>();
                for (ItemPicture itemPicture : itemPictureFindResponse.getResult()) {
                    if (itemPicture.getPictureId() != null) {
                        FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                        filePathGetRequest.setId(itemPicture.getPictureId());
                        FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                        itemPicture.setAvatarurl(filePathGetResponse.getUrl());
                    }
                    itemPictures.add(itemPicture);
                }
                item.setItemPictureList(itemPictures);
            }
//            CollectionFindRequest collectionFindRequest = new CollectionFindRequest();
//            collectionFindRequest.setObjectId(request.getId());
//            collectionFindRequest.setUserId(passport.getUserId());
//            collectionFindRequest.setType(CollectionEnum.SHOP.name());
//            collectionFindRequest.setPageSize(0);
//            List<CollectionPO> collectionPOs = collectionMapper.find(collectionFindRequest, passport);
//            if (collectionPOs.size() == 1) {
//                response.setIsCollection(true);
//            }
            ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
            articleStatisticsCollectRequest.setArticleId(entity.getId());
            articleStatisticsCollectRequest.setType(StatisticsTypeEnum.LINK);
            articleStatisticsCollectRequest.setUserId(passport.getUserId());
            articleStatisticsCollectRequest.setPageSize(0);
            List<ArticleStatisticsPO> articleStatisticses = statisticsMapper.find(articleStatisticsCollectRequest, passport);
            if (articleStatisticses.size() == 1) {
                response.setIsCollection(true);
            }
            //更新点击数
            ArticleStatisticsCollectRequest collectRequest = new ArticleStatisticsCollectRequest();
            collectRequest.setType(StatisticsTypeEnum.SHOP_READ);
            collectRequest.setUserId(passport.getUserId());
            collectRequest.setArticleId(request.getId());
            collectRequest.setPageSize(0);
            List<ArticleStatisticsPO> statics = statisticsMapper.find(collectRequest, passport);
            if (statics.size() == 0) {
                long id = foundationService.getNewId();
                ArticleStatisticsCreateRequest articleStatisticsCreateRequest = new ArticleStatisticsCreateRequest();
                articleStatisticsCreateRequest.setArticleId(request.getId());
                articleStatisticsCreateRequest.setType(StatisticsTypeEnum.SHOP_READ.name());
                articleStatisticsCreateRequest.setUserId(passport.getUserId());
                articleStatisticsCreateRequest.setUserName(passport.getUserName());
                ArticleStatisticsPO articleStatisticsPO = this.getMapper().map(articleStatisticsCreateRequest, ArticleStatisticsPO.class);
                articleStatisticsPO.setId(id);
                if (1 == statisticsMapper.insert(articleStatisticsPO, passport)) {
                    entity.setCountRead(entity.getCountRead() + 1);
                    ItemUpdateRequest itemUpdateRequest = this.getMapper().map(entity, ItemUpdateRequest.class);
                    this.update(itemUpdateRequest, passport);
                }
            }
            //获取此文章下的评论
            CommentPostFindRequest commentPostFindRequest = new CommentPostFindRequest();
            commentPostFindRequest.setThreadId(request.getId());
            // commentPostFindRequest.setParentId(request.getId());
            commentPostFindRequest.setPageSize(0);
            CommentPostFindResponse commentPostFindResponse = commentPostManager.find(commentPostFindRequest, passport);
//            for (CommentPost commentPost : commentPostFindResponse.getResult()) {
//                CommentPostFindRequest commentPostFindRequest1 = new CommentPostFindRequest();
//                commentPostFindRequest1.setBusinessId(request.getId());
//                commentPostFindRequest1.setParentId(commentPost.getId());
//                commentPostFindRequest.setPageSize(0);
//                commentPostLsit.add(commentPost);
//                CommentPostFindResponse commentPostFindResponse1 = commentPostManager.find(commentPostFindRequest, passport);
//                for (CommentPost commentPost1 : commentPostFindResponse1.getResult()) {
//                    commentPostLsit.add(commentPost1);
//                }
            //  }
            List<CommentPost>commentPosts=new ArrayList<>();
            for (CommentPost commentPost : commentPostFindResponse.getResult()) {
                if (commentPost.getUserId() != null) {
                    SysUserGetRequest sysUserGetRequest = new SysUserGetRequest();
                    sysUserGetRequest.setId(commentPost.getUserId());
                    SysUserGetResponse sysUserGetResponse = sysUserManager.get(sysUserGetRequest, passport);
                    SysUser user = sysUserGetResponse.getSysUser();
                    if (user != null) {
                        commentPost.setUserName(user.getNickName());
                        if (user.getAvatarId() != null&& user.getAvatarId().intValue()!=0) {
                            FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                            filePathGetRequest.setId(user.getAvatarId());
                            FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                            commentPost.setAvatarurl(filePathGetResponse.getUrl());
                        } else {
                            if(user.getSex()!=null) {
                                if (user.getSex().equals(SexEnum.FEMALE)) {
                                    commentPost.setAvatarurl("../images/girl.png");
                                } else if (user.getSex().equals(SexEnum.MALE)) {
                                    commentPost.setAvatarurl("../images/boy.png");
                                }
                            }
                            else{
                                commentPost.setAvatarurl("../images/girl.png");
                            }

                        }
                    }
                }
                commentPosts.add(commentPost);
            }
            if (commentPostFindResponse.getResult().size() > 0) {
                response.setCommentPostList(commentPosts);
            }
            response.setItem(item);
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_GET_FAILURE);
        }
        return response;
    }


    /**
     * 模糊查询物料表
     *
     * @param request  模糊查询物料表请求
     * @param passport 用户护照
     * @return 模糊查询物料表应答
     */
    @Override
    public ItemSearchResponse search(ItemSearchRequest request, Passport passport) {
        ItemSearchResponse response = new ItemSearchResponse();
        List<Item> modelList = new ArrayList<>();
        Long count = itemMapper.searchCount(request, passport);

        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }

            //通过关键字查询出用户集合
            List<ItemPO> entityList = itemMapper.search(request, passport);

            for (ItemPO entity : entityList) {
                Item item = this.getMapper().map(entity, Item.class);
                if (item.getClassId() != null) {
                    ClazzGetRequest clazzGetRequest = new ClazzGetRequest();
                    clazzGetRequest.setId(item.getClassId());
                    ClazzGetResponse clazzGetResponse = clazzManager.get(clazzGetRequest, passport);
                    if (clazzGetResponse.getClazz() != null) {
                        item.setCategoryName(clazzGetResponse.getClazz().getName());
                    }
                }
                modelList.add(item);
            }
        }

        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 高级查询物料表
     *
     * @param request  高级查询物料表请求
     * @param passport 用户护照
     * @return 高级查询应答
     */
    @Override
    public ItemFindResponse find(ItemFindRequest request, Passport passport) {
        ItemFindResponse response = new ItemFindResponse();
        List<Item> modelList = new ArrayList<>();
        Long count = itemMapper.findCount(request, passport);
        if (count > 0) {
            // 处理分页参数
            if (request.getPageSize() > 0) {
                //如果输入的页码大于实际的分页数，将页码设置为最后一页的页码
                int lastPageNumber = (int) ((count - 1) / request.getPageSize() + 1);
                if (request.getPageNumber() > lastPageNumber) {
                    request.setPageNumber(lastPageNumber);
                }
            }


            List<ItemPO> entityList = itemMapper.find(request, passport);
            for (ItemPO entity : entityList) {
                Item item = this.getMapper().map(entity, Item.class);
                if (item.getClassId() != null) {
                    ClazzGetRequest clazzGetRequest = new ClazzGetRequest();
                    clazzGetRequest.setId(item.getClassId());
                    ClazzGetResponse clazzGetResponse = clazzManager.get(clazzGetRequest, passport);
                    if (clazzGetResponse.getClazz() != null) {
                        item.setCategoryName(clazzGetResponse.getClazz().getName());
                    }
                }
                if (item.getPictureId() != null) {
                    FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
                    filePathGetRequest.setId(item.getPictureId());
                    FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
                    item.setAvatarurl(filePathGetResponse.getUrl());
                }
                ItemEcommercePO itemEcommercePO = itemEcommerceMapper.getById(item.getId(), passport);
                if (itemEcommercePO != null) {
                    item.setOriginalPrice(itemEcommercePO.getOriginalPrice());
                    item.setCurrentPrice(itemEcommercePO.getCurrentPrice());
                }
                ItemDetailPO itemDetailPO = itemDetailMapper.getById(item.getId(), passport);
                if (itemDetailPO != null) {
                    item.setContext(itemDetailPO.getText());
                }
//                ItemPictureFindRequest itemPictureFindRequest = new ItemPictureFindRequest();
//                itemPictureFindRequest.setItemId(item.getId());
//                ItemPictureFindResponse itemPictureFindResponse = itemPictureManager.find(itemPictureFindRequest, passport);
//               for(ItemPicture itemPicture:itemPictureFindResponse.getResult()) {
//                   if (itemPicture.getPictureId() != null) {
//                       FilePathGetRequest filePathGetRequest = new FilePathGetRequest();
//                       filePathGetRequest.setId(item.getPictureId());
//                       FilePathGetResponse filePathGetResponse = foundationService.getFilePath(filePathGetRequest, passport);
//                       itemPicture.setAvatarurl(filePathGetResponse.getUrl());
//                   }
//               }
//                item.setItemPictureList(itemPictureFindResponse.getResult());
                modelList.add(item);
            }

        }
        response.setTotalCount(count);
        response.setResult(modelList);
        return response;
    }

    /**
     * 获取所有物料表列表
     *
     * @param request  获取所有物料表列表请求
     * @param passport 用户护照
     * @return 获取所有物料表列表应答
     */
    @Override
    public ItemGetAllListResponse getAllList(ItemGetAllListRequest request, Passport passport) {
        ItemGetAllListResponse response = new ItemGetAllListResponse();


        List<ItemPO> entityList = itemMapper.getAllList(request, passport);


        List<Item> modelList = new ArrayList<>();
        for (ItemPO entity : entityList) {
            Item item = this.getMapper().map(entity, Item.class);
            modelList.add(item);
        }

        response.setResult(modelList);

        response.setTotalCount(modelList.size());
        return response;
    }


    /**
     * 创建物料表
     *
     * @param request  创建物料表请求
     * @param passport 用户护照
     * @return 创建物料表应答
     */
    @Override
    public ItemCreateResponse create(ItemCreateRequest request, Passport passport) {
        ItemPO entity = this.getMapper().map(request, ItemPO.class);
        ItemCreateResponse response = new ItemCreateResponse();

    /* 先检查关键数据是否有重复，在检查通过后才能做插入操作 */
        checkValidate(entity, passport, response);

        if (1 == itemMapper.insert(entity, passport)) {
            response.setId(request.getId());
            if (request.getItemDetailCreateRequest() != null) {
                ItemDetailCreateRequest itemDetailCreateRequest = request.getItemDetailCreateRequest();
                ItemDetailPO itemDetailPO = this.getMapper().map(itemDetailCreateRequest, ItemDetailPO.class);
                itemDetailPO.setId(request.getId());
                if (1 != itemDetailMapper.insert(itemDetailPO, passport)) {
                    response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
                }
            }
            if (request.getItemEcommerceCreateRequest() != null) {
                ItemEcommerceCreateRequest itemEcommerceCreateRequest = request.getItemEcommerceCreateRequest();
                ItemEcommercePO itemEcommercePO = this.getMapper().map(itemEcommerceCreateRequest, ItemEcommercePO.class);
                itemEcommercePO.setId(request.getId());
                if (1 != itemEcommerceMapper.insert(itemEcommercePO, passport)) {
                    response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
                }
            }
//            if (request.getItemPictureCreateRequest() != null) {
//                for(ItemPictureCreateRequest itemPictureCreateRequest:request.getItemPictureCreateRequest()){
//                    itemPictureCreateRequest.setItemId(request.getId());
//                    itemPictureManager.create(itemPictureCreateRequest, passport);
//                }
//            }
        } else {
            response.addError(ErrorType.EXPECTATION_NULL, Message.COMMON_CREATE_FAILURE);
        }
        return response;
    }


    /**
     * 更新物料表
     *
     * @param request  更新物料表请求
     * @param passport 用户护照
     * @return 更新物料表应答
     */
    @Override
    public ItemUpdateResponse update(ItemUpdateRequest request, Passport passport) {
        ItemPO entity = this.getMapper().map(request, ItemPO.class);

        ItemUpdateResponse response = new ItemUpdateResponse();
        Long result = itemMapper.update(entity, passport);
        if (result != 1) {
            response.addError(ErrorType.BUSINESS_ERROR, Message.COMMON_UPDATE_FAILURE);
            return response;
        }
        if (request.getUpdate()) {
            ItemDetailPO itemDetailPO = itemDetailMapper.getById(request.getId(), passport);
            itemDetailPO.setText(request.getContext());
            itemDetailMapper.update(itemDetailPO, passport);
            ItemEcommercePO itemEcommercePO = itemEcommerceMapper.getById(request.getId(), passport);
            itemEcommercePO.setOriginalPrice(request.getOriginalPrice());
            itemEcommercePO.setCurrentPrice(request.getCurrentPrice());
            itemEcommerceMapper.update(itemEcommercePO, passport);
//            for (ItemPicture itemPicture : request.getItemPictureList()) {
//                ItemPicturePO itemPicturePO = itemPictureMapper.getById(itemPicture.getId(), passport);
//                itemPicturePO.setPictureId(itemPicture.getPictureId());
//                itemPictureMapper.update(itemPicturePO,passport);
//            }
        }
        response.setResult(result);
        return response;
    }


    /**
     * 删除物料表
     *
     * @param request  删除物料表请求
     * @param passport 用户护照
     * @return 删除物料表应答
     */
    @Override
    public ItemDeleteResponse delete(ItemDeleteRequest request, Passport passport) {
        ItemDeleteResponse response = new ItemDeleteResponse();
        Long result = itemMapper.delete(request.getId(), passport);
        //删除行详情
        itemDetailMapper.delete(request.getId(), passport);
        //删除属性
        itemEcommerceMapper.delete(request.getId(), passport);

        //删除图片
        ItemPictureFindRequest itemPictureFindRequest = new ItemPictureFindRequest();
        itemPictureFindRequest.setItemId(request.getId());
        ItemPictureFindResponse itemPictureFindResponse = itemPictureManager.find(itemPictureFindRequest, passport);
        for (ItemPicture itemPicture : itemPictureFindResponse.getResult()) {
            ItemPictureDeleteRequest itemPictureDeleteRequest = new ItemPictureDeleteRequest();
            itemPictureDeleteRequest.setId(itemPicture.getId());
            ItemPictureDeleteResponse itemPictureDeleteResponse = itemPictureManager.delete(itemPictureDeleteRequest, passport);
        }
        response.setResult(result);
        return response;
    }


    /**
     * 作废物料表
     *
     * @param request  作废物料表请求
     * @param passport 用户护照
     * @return 作废物料表应答
     */
    @Override
    public ItemInactiveResponse inactive(ItemInactiveRequest request, Passport passport) {
        ItemInactiveResponse response = new ItemInactiveResponse();
        Long result = itemMapper.inactive(request.getId(), passport);
        response.setResult(result);
        return response;
    }


    /**
     * 激活物料表
     *
     * @param request  激活物料表请求
     * @param passport 用户护照
     * @return 激活物料表应答
     */
    @Override
    public ItemActiveResponse active(ItemActiveRequest request, Passport passport) {
        ItemActiveResponse response = new ItemActiveResponse();
        Long result = itemMapper.active(request.getId(), passport);
        response.setResult(result);
        return response;
    }

    /**
     * 审核文章
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ItemApproveResponse approve(ItemApproveRequest request, Passport passport) {
        ItemApproveResponse articleApproveResponse = new ItemApproveResponse();
        ItemPO item = itemMapper.getById(request.getId(), passport);
        if (item != null) {
            item.setApproveResult(ApproveResultEnum.AGREE.name());
            item.setApproveTime(new Date());
            item.setIsApproved(true);
            item.setApproveUserName(passport.getUserName());
            item.setApproveUserId(passport.getUserId());
            ItemUpdateRequest articleUpdateRequest = this.getMapper().map(item, ItemUpdateRequest.class);
            ItemUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
            articleApproveResponse.setResult(articleUpdateResponse.getResult());
        }
        return articleApproveResponse;
    }

    /**
     * 取消发布
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ItemCancelResponse cancel(ItemCancelRequest request, Passport passport) {
        ItemCancelResponse itemCancelResponse = new ItemCancelResponse();
        ItemPO item = itemMapper.getById(request.getId(), passport);
        if (item != null) {
            item.setIsApproved(false);
            item.setApproveTime(null);
            item.setApproveResult(ApproveResultEnum.DISAGREE.name());
            ItemUpdateRequest articleUpdateRequest = this.getMapper().map(item, ItemUpdateRequest.class);
            ItemUpdateResponse articleUpdateResponse = this.update(articleUpdateRequest, passport);
            itemCancelResponse.setResult(articleUpdateResponse.getResult());
        }
        return itemCancelResponse;
    }

    /**
     * 导入物料表
     *
     * @param request  导入物料表请求
     * @param passport 用户护照
     * @return 导入物料表应答
     */
    @Override
    public ItemListImportResponse importList(ItemListImportRequest request, Passport passport) {
        DataTable<ItemImport> dataTable = request.getDataTable();

        List<ItemPO> importList = new ArrayList<>();            //需要创建的对象的集合

        List<Long> result = new LinkedList<>();                    //存储ID的集合
        List<ItemImport> beanList = request.getList();            //取出导入对象的集合
        ItemListImportResponse response = new ItemListImportResponse();//最终的返回结果

    /* 批量获取ID */
        IdsGetRequest idsGetRequest = new IdsGetRequest();
        idsGetRequest.setCount(beanList.size());
        List<Long> ids = foundationService.getNewIds(idsGetRequest).getIds();

        int index = 0;
        for (ItemImport importBean : beanList) {
            // 设置
            ItemPO entity = this.getMapper().map(importBean, ItemPO.class);


            importList.add(entity);
            result.add(ids.get(index));         //将取到的ID放入返回结果中
            entity.setId(ids.get(index));       //设置ID

            index++;
        }

        if (!dataTable.hasError()) {
            if (importList.size() > 0) {
                itemMapper.insertBatch(importList, passport);
            }
        } else {
            // response.setDataTable(dataTable);
            response.addErrors(dataTable.getErrorList());
        }

        response.setList(result);
        return response;

    }

    @Override
    public ItemCollectionResponse clickCollection(ItemCollectionRequest request, Passport passport) {
        ItemCollectionResponse response = new ItemCollectionResponse();
        if (request.getIsCollection() != null) {
            if (request.getIsCollection()) {
                long id = foundationService.getNewId();
                ArticleStatisticsCreateRequest articleStatisticsCreateRequest = new ArticleStatisticsCreateRequest();
                articleStatisticsCreateRequest.setArticleId(request.getId());
                articleStatisticsCreateRequest.setType(StatisticsTypeEnum.LINK.name());
                articleStatisticsCreateRequest.setUserId(passport.getUserId());
                articleStatisticsCreateRequest.setUserName(passport.getUserName());
                ArticleStatisticsPO articleStatisticsPO = this.getMapper().map(articleStatisticsCreateRequest, ArticleStatisticsPO.class);
                articleStatisticsPO.setId(id);
                if (1 == statisticsMapper.insert(articleStatisticsPO, passport)) {
                        ItemPO itemPO=itemMapper.getById(request.getId(), passport);
                        if (itemPO != null) {
                            if (itemPO.getCountConnection() == null) {
                                itemPO.setCountConnection(0);
                            }
                            itemPO.setCountConnection(itemPO.getCountConnection() + 1);
                            itemMapper.update(itemPO, passport);
                        }
                }
                response.setSuccess(true);

            } else {
                //取消赞
                ArticleStatisticsCollectRequest articleStatisticsCollectRequest = new ArticleStatisticsCollectRequest();
                articleStatisticsCollectRequest.setArticleId(request.getId());
                articleStatisticsCollectRequest.setUserId(passport.getUserId());
                articleStatisticsCollectRequest.setType(StatisticsTypeEnum.LINK);
                articleStatisticsCollectRequest.setPageSize(0);
                List<ArticleStatisticsPO> articleStatisticses = statisticsMapper.find(articleStatisticsCollectRequest, passport);
                if (articleStatisticses.size() == 1) {
                    if (1 == statisticsMapper.delete(articleStatisticses.get(0).getId(), passport)) {
                        response.setSuccess(true);
                    } else {
                        response.addError(ErrorType.BUSINESS_ERROR, "取消赞失败！");
                        return response;
                    }
                } else {
                    response.addError(ErrorType.BUSINESS_ERROR, "数据错误！");
                    return response;
                }

                    ItemPO itemPO=itemMapper.getById(request.getId(), passport);
                    if (itemPO != null) {
                        if (itemPO.getCountConnection() == null) {
                            itemPO.setCountConnection(0);
                        }
                        itemPO.setCountConnection(itemPO.getCountConnection() -1);
                        itemMapper.update(itemPO, passport);
                    }


            }

        }
        return response;
    }

    /**
     * 改变文章排序权重
     *
     * @param request
     * @param passport
     * @return
     */
    @Override
    public ItemChangeOrderResponse changeOrder(ItemChangeOrderRequest request, Passport passport) {
        ItemChangeOrderResponse itemChangeOrderResponse = new ItemChangeOrderResponse();
        ItemGetRequest itemGetRequest = new ItemGetRequest();
        itemGetRequest.setId(request.getId());
        ItemGetResponse itemGetResponse = this.get(itemGetRequest, passport);
        Item item = itemGetResponse.getItem();
        if (item != null) {
            item.setOrderSort(request.getOrderSort());
            ItemUpdateRequest ItemUpdateRequest = this.getMapper().map(itemGetResponse.getItem(), ItemUpdateRequest.class);
            this.update(ItemUpdateRequest, passport);
        }
        return itemChangeOrderResponse;
    }

    /**
     * 验证对象
     *
     * @param item     物料表
     * @param passport 用户护照
     */
    private void checkValidate(ItemPO item, Passport passport, BaseResponse response) {
        // TODO

    }


}
