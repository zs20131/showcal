import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Server;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

/**
 * 使用Jetty运行调试Web应用, 在Console输入回车快速重新加载应用.
 */
public class QuickStartServer {

    public static final int PORT = 80;
    public static final String CONTEXT = "/";
    public static final String ANTX_PROPERTIES = "conf/dev.env.properties";
//	public static final String[] TLD_JAR_NAMES = new String[] { "sitemesh", "spring-webmvc", "shiro-web",
//			"springside-core" };

    public static void main(String[] args) throws Exception {
        // 设定Spring的profile
        System.setProperty("spring.profiles.active", "development");
        System.setProperty("productionMode", "true");
        //读取antx.properties
        File antx = new File(ANTX_PROPERTIES);
        if (!antx.exists()) {
            antx = new File("src/main", ANTX_PROPERTIES);
        }
        if (antx.exists() && antx.isFile()) {
            Properties p = new Properties();
            FileInputStream in = new FileInputStream(antx);
            p.load(in);
            IOUtils.closeQuietly(in);
            for (Map.Entry<Object, Object> entry : p.entrySet()) {
                System.getProperties().put(entry.getKey(), entry.getValue());
            }
        } else {
            System.setProperty("omp.loggingLevel", "warn");
            System.setProperty("omp.loggingRoot", "d:/logs");
            System.setProperty("productionMode", "false");
        }


        // 启动Jetty
        Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
//		JettyFactory.setTldJarNames(server, TLD_JAR_NAMES);
//        initSSL();
        try {
            server.start();


            System.out.println("Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("Hit Enter to reload the application quickly");

            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }


    private static void initSSL() throws Exception {
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                        + session.getPeerHost());
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new XTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class XTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}
