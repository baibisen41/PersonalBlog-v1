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
        String title = "浅谈HashMap与Hashtable";
        String tag = "java";
        String summary = " HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。";
        String content = "HashMap和Hashtable的比较是Java面试中的常见问题，用来考验程序员是否能够正确使用集合类以及是否可以随机应变使用多种思路解决问题。HashMap的工作原理、ArrayList与Vector的比较以及这个问题是有关Java 集合框架的最经典的问题。Hashtable是个过时的集合类，存在于Java API中很久了。在Java 4中被重写了，实现了Map接口，所以自此以后也成了Java集合框架中的一部分。Hashtable和HashMap在Java面试中相当容易被问到，甚至成为了集合框架面试题中最常被考的问题，所以在参加任何Java面试之前，都不要忘了准备这一题。";
        String type = "1";
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
