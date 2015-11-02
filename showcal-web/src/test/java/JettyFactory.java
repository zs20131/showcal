/**
 * Copyright (c) 2005-2012 springside.org.cn
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */

import org.eclipse.jetty.server.*;
//import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * 创建Jetty Server的工厂类.
 *
 * @author calvin
 */
public class JettyFactory {

    private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
    private static final String DEFAULT_PARENTWEBAPP_PATH = "web/src/main/webapp";
    private static final String WINDOWS_WEBDEFAULT_PATH = "jetty/webdefault-windows.xml";

    /**
     * 创建用于开发运行调试的Jetty Server, 以src/main/webapp为Web应用目录.
     */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server();
        server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
        // 设置在JVM退出时关闭Jetty的钩子。
        server.setStopAtShutdown(true);

//        SelectChannelConnector connector = new SelectChannelConnector();
        HttpConfiguration config = new HttpConfiguration();
        ServerConnector connector = new ServerConnector(server,new HttpConnectionFactory(config));
        connector.setReuseAddress(true);
        connector.setIdleTimeout(30000);
        connector.setPort(port);
//        // 解决Windows下重复启动Jetty居然不报告端口冲突的问题.
//        connector.setReuseAddress(false);
//        server.setConnectors(new Connector[]{connector});
        File ctxPath = new File(DEFAULT_WEBAPP_PATH);
        if (!ctxPath.exists() || !ctxPath.isDirectory()) {
            ctxPath = new File(DEFAULT_PARENTWEBAPP_PATH);
        }
        WebAppContext webContext = new WebAppContext(ctxPath.getPath(), contextPath);
        // 修改webdefault.xml，解决Windows下Jetty Lock住静态文件的问题.
        webContext.setDefaultsDescriptor(WINDOWS_WEBDEFAULT_PATH);
        server.setHandler(webContext);

        return server;
    }

    /**
     * 设置除jstl-*.jar外其他含tld文件的jar包的名称.
     * jar名称不需要版本号，如sitemesh, shiro-web
     */
    public static void setTldJarNames(Server server, String... jarNames) {
        /*WebAppContext context = (WebAppContext) server.getHandler();
		List<String> jarNameExprssions = Lists.newArrayList(".*//*jstl-[^/]*\\.jar$", ".*//*.*taglibs[^/]*\\.jar$");
		for (String jarName : jarNames) {
			jarNameExprssions.add(".*//*" + jarName + "-[^/]*\\.jar$");
		}

		context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
				StringUtils.join(jarNameExprssions, '|'));
*/
    }

    /**
     * 快速重新启动application，重载target/classes与target/test-classes.
     */
    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        File target = new File("web/target/classes");
        if (!target.exists()) {
            target = new File("target/classes");
        }
        classLoader.addClassPath(target.getPath());
//		classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("Application reloaded");
    }
}
