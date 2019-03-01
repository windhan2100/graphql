package com.hanchao.graphql.graphql.config.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author hanliwei
 * @create 2019-01-15 15:07
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("jdbc.driver"));
        config.setJdbcUrl(env.getProperty("jdbc.url"));
        config.setUsername(env.getProperty("jdbc.username"));
        config.setPassword(env.getProperty("jdbc.password"));
        /**
         * 连接池中允许的最大连接数。缺省值：10；推荐的公式：((core_count * 2) + effective_spindle_count)
         */
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        /**
         * 等待连接池分配连接的最大时长（毫秒），超过这个时长还没可用的连接则发生SQLException， 缺省:30秒
         */
        config.setConnectionTimeout(5 * 1000L);
        /**
         * 一个连接idle状态的最大时长（毫秒），超时则被释放（retired），缺省:10分钟
         */
        config.setIdleTimeout(3 * 60 * 1000L);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("beehive_statistic");
        return new HikariDataSource(config);
    }
}
