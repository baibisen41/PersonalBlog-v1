import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

/**
 * User: baibisen
 * Date: 2018/5/6
 */
public class PbBlogEditTest extends BaseTest {

    private final static Logger LOG = LoggerFactory.getLogger(PbBlogEditTest.class);
    private final static String dbUrl = "jdbc:mysql://localhost:3306/db_personalblog?useUnicossssde=true&characterEncoding=UTF-8";
    private final static String dbName = "root";
    private final static String dbPwd = "root";

    private Connection dbConn() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOG.info("驱动加载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.info("jdbc连接失败");
        }
        return connection;
    }

    private String getUserSql() {
        String id = UUID.randomUUID().toString().replace("-", "");
        String name = "baibisen";
        String password = UUID.randomUUID().toString().replace("-", "");
        String status = "1";
        String ip = "127.0.0.1";
        String sql = "INSERT INTO pb_user (id,name,password,status,ip,create_date) VALUES (\"" + id + "\",\"" + name + "\",\"" + password + "\",\"" + status + "\",\"" + ip + "\",CURRENT_TIMESTAMP)";
        LOG.info(sql);
        return sql;
    }

    private String getBlogSql() {
        String id = UUID.randomUUID().toString().replace("-", "");
        String userId = "e7d29c4eb93042f394194cb17498a785";
        String title = "比特币一季度价格腰斩过半，加密货币市场已死？";
        String tag = "资讯";
        String summary = "据CoinMarketCap数据显示，自年初以来，比特币价格已经从高点17533美元一度暴跌至6121美元，跌幅超过65%，其蒸发的市值几乎是特斯拉市值的三倍，约为Twitter市值的5.5倍。与此同时，看比特币脸色行事的其他加密货币日子也不好过，市场总市值已经蒸发近5000亿美元。";
        String content = "在市场自然调整的基础上，种种利空消息的轮番轰炸进一步加剧了下跌力度。但就目前而言，加密货币投资者更关注的是，本轮“熊市”何时见底？对于那些赌上全部资产的投机者而言，这个问题尤为重要，币价的涨跌决定着他们的所有情绪。但我们也知道，市场发展取决于多种因素，没有人能够做到百分百精准的预测。“熊市”的到来，是一次去除浮躁，让价值、理性回归的过程。对于坚持价值投资的人来说，在长远的趋势面前，短期的价格波动并不算什么。更重要的是，在泡沫破灭的同时，能够发现那些真正有价值的项目。";
        String type = "3";
        String status = "1";
        String sql = "INSERT INTO pb_blog (id,user_id,title,tag,thumb_pic,summary,content,type,status,create_date) VALUES (\"" + id + "\",\"" + userId + "\",\"" + title + "\",\"" + tag + "\",\"\",\"" + summary + "\",\"" + content + "\",\"" + type + "\",\"" + status + "\",CURRENT_TIMESTAMP)";
        LOG.info(sql);
        return sql;
    }

    private String getPvSql() {
        String id = "42f37b9c59c44c2c97ef89cdc3436e9f";
        Integer blogPv = 1;
        String sql = "INSERT INTO pb_blog_pv (id,blog_pv,create_date) VALUES (\"" + id + "\",\"" + blogPv + "\",CURRENT_TIMESTAMP)";
        LOG.info(sql);
        return sql;
    }

    private void insert() {
        Statement stmt = null;
        try {
            stmt = dbConn().createStatement();
            // String sql = getBlogSql();
            String sql = getBlogSql();
            stmt.executeUpdate(sql);
            LOG.info("插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (dbConn().createStatement() != null) {
                    dbConn().createStatement().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PbBlogEditTest().insert();
    }
}
