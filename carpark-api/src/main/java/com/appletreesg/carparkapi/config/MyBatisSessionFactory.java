package com.appletreesg.carparkapi.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: zhihua.su
 * @date: 2019-07-30
 * @time: 16:04
 */

@Slf4j
@Configuration
public class MyBatisSessionFactory {
    @Bean
    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis/mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            log.error("error get sql session factory");
            return null;
        }
    }
}
