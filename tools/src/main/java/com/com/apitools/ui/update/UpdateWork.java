package com.com.apitools.ui.update;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created on 2015-07-27.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class UpdateWork implements Runnable {

    @Override
    public void run() {
        Integer v;
        List<UpdateBean> beanList;
        try {
            v = UpdateWork.getVersion();
            beanList = UpdateWork.checkVersion(v);
        } catch(Exception e) {
            throw new RuntimeException("无法连接更新服务器");
        }

        if(beanList.isEmpty()) {
            return;
        }

//        StringBuilder builder = new StringBuilder();
//        int index = 0;
//        for(UpdateBean bean : beanList) {
//            if(index > 0) {
//                builder.append("\n-----------------------\n\n");
//            }
//            builder.append("版本:").append(bean.getVersion()).append("\n")
//                    .append("更新时间:").append(DateUtil.formatDate(bean.getDate(), "yyyy-MM-dd")).append("\n")
//                    .append("更新内容:").append(bean.getSummary());
//            index++;
//        }
//        UpdateBean updateBean = beanList.get(0);
//        progressBar.setTotal(updateBean.getSize());
//        updateContent.setText(builder.toString());
//        updateButton.setText("更新(" + ByteUtil.transfer(updateBean.getSize()) + ")");
//        updateButton.setVisible(true);
        try {
            Runtime.getRuntime().exec("update.exe");
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 启动时获取自身版本号
     *
     * @return 当前版本号
     */
    public static Integer getVersion() {
        Integer version = 0;
        InputStream in = UpdateWork.class.getResourceAsStream("/version.properties");
        Properties props = new Properties();
        try {
            props.load(in);
            version = Integer.parseInt(props.getProperty("version"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * 从服务器获取比当前新的版本信息
     *
     * @param version 当前的版本号(数字)
     * @return 更新的版本信息
     */
    public static List<UpdateBean> checkVersion(int version) throws IOException {
        List<UpdateBean> result = new ArrayList<>();
        List<UpdateBean> updateBeans = UpdateWork.checkVersion();
        if(updateBeans != null && updateBeans.size() > 0) {
            for(UpdateBean bean : updateBeans) {
                if(bean.getNumber() > version) {
                    result.add(bean);
                }
            }
        }
        return result;
    }


    /**
     * 从服务器获取所有版本信息
     *
     * @return JSONArray字符串
     */
    public static List<UpdateBean> checkVersion() throws IOException {
        List<UpdateBean> result;
        String text = WebUtils.doGet("http://soft.xiniunet.com/apitools/java/version.json", null);
        result = JSON.parseArray(text, UpdateBean.class);
        return result;
    }
}
