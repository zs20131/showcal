package net.showcal.mobile.module.screen;

import net.showcal.tool.SocketSessionUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.mobile.module.screen
 *  Description:
 * ***************************************************************
 *  10/12 0012  V1.0  xiniu    New Files for net.showcal.mobile.module.screen
 * </pre>
 */
@ServerEndpoint("/chat/message/{passportId}/{userId}")
public class ShowCalMessage {
    /**
     * 打开连接
     *
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session,@PathParam(value = "passportId") Long passportId, @PathParam(value = "userId") Long userId) {
        SocketSessionUtils.put(passportId, userId, session);
        System.out.println("session : " + userId + " -- connection");
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(@PathParam(value = "passportId") Long passportId,@PathParam(value = "userId") Long userId) {
        System.out.println("session :" + userId + " -- remove");
        SocketSessionUtils.remove(passportId, userId);
    }


//    /**
//     * 接收信息
//     *
//     * @param message
//     * @param userId
//     */
//    @OnMessage
//    public void onMessage(String message,
//                          @PathParam(value = "userId") Long userId) {
//        WebSocketApi.broadCast(userId+ ">" + message);
//    }

    /**
     * 错误信息响应
     *
     * @param throwable
     */
    @OnError
    public void onError(@PathParam(value = "passportId") Long passportId,@PathParam(value = "userId") Long userId, Throwable throwable) {
        SocketSessionUtils.remove(passportId, userId);
//        System.out.println(throwable.getMessage());
    }


}
