package net.showcal.tool;

import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.tool
 *  Description:
 * ***************************************************************
 *  10/22 0022  V1.0  xiniu    New Files for net.showcal.tool
 * </pre>
 */
public class SocketSessionUtils {
    public static Map<Long, Map<Long, Session>> clients = new ConcurrentHashMap<>();

    public static void put(Long passportId, Long userId, Session session) {
        Map<Long, Session> sessionMap = clients.get(userId);
        if (sessionMap == null) {
            sessionMap = new ConcurrentHashMap<>();
        }
        sessionMap.put(passportId, session);
        clients.put(userId, sessionMap);
    }

    public static Map<Long, Session> get(Long userId) {
        return clients.get(userId);
    }

    public static void remove(Long passportId, Long userId) {
        if (clients.containsKey(userId)) {
            Map<Long, Session> sessionMap = clients.get(userId);
            sessionMap.remove(passportId);
            if (sessionMap == null || sessionMap.isEmpty()) {
                clients.remove(userId);
            }
        }

    }

    /**
     * 判断是否有连接
     *
     * @param userId
     * @return
     */
    public static boolean hasConnection(Long passportId, Long userId) {
        Map<Long, Session> sessionMap = clients.get(userId);
        if (sessionMap == null) {
            return false;
        }
        return sessionMap.containsKey(passportId);
    }

    /**
     * 广播发送消息
     *
     * @param userIds
     * @param message
     */
    public static void broadcast(List<Long> userIds, String message) {
        if (userIds != null && !userIds.isEmpty()) {
            for (Long userId : userIds) {
                Map<Long, Session> sessionMap = SocketSessionUtils.get(userId);
                if (sessionMap != null) {
                    // 获取所有的链接
                    Set<Long> passportIds = sessionMap.keySet();
                    for (Long passport : passportIds) {
                        sessionMap.get(passport).getAsyncRemote().sendText(message);
                    }
                }
            }
        }
    }
}
