---
url: https://blog.csdn.net/zhouzhiwengang/article/details/124361332
title: IDEA 搭建 SpringBoot 项目：SpringBoot + MyBatis + Druid +MyBatis-Generator_在奋斗的大道的博客 - CSDN 博客
date: 2023-01-03 16:39:40
tag: 
summary: 
---
今天第一次使用 IDEA 开发工具，搭建 SpringBoot 项目，记录下重点步骤。

1、IDEA 创建基于 Maven 管理的 Java 项目。

![](https://img-blog.csdnimg.cn/43b7fe864b3343dbaad008e2be552030.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5Zyo5aWL5paX55qE5aSn6YGT,size_20,color_FFFFFF,t_70,g_se,x_16)

2、pom.xml 文件添加

jar 包依赖：SpringBoot 版本、MyBatis、MySQL8 驱动和 Alibaba Druid 数据库连接池。

插件依赖：添加 maven 插件和 MyBatis-Generator 代码生产工具。

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.2.2.RELEASE</version>
    </parent>
 
    <groupId>org.zzg</groupId>
    <artifactId>SmartHouse</artifactId>
    <version>1.0-SNAPSHOT</version>
 
    <properties>
        <java.version>1.8</java.version>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
 
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
 
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
 
        <!--springboot 与 mybatis 集成 -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        <!-- 数据库连接池druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
        </dependency>
        <!--mysql 驱动程序 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.12</version>
        </dependency>
 
    </dependencies>
 
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.6.6</version>
            </plugin>
            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.3.5</version>
                <configuration>
                    <configurationFile>src/main/resources/mybatis-generator/mybatis-generator-cfg.xml
                    </configurationFile>
                    <verbose>true</verbose>
                    <overwrite>true</overwrite>
                </configuration>
                <executions>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.mybatis.generator</groupId>
                        <artifactId>mybatis-generator-core</artifactId>
                        <version>1.3.5</version>
                    </dependency>
                    <!--mysql 驱动程序 -->
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                        <version>8.0.12</version>
                    </dependency>
                </dependencies>
            </plugin>
 
        </plugins>
    </build>
 
 
</project>
```

 3、添加 application.properties 配置文件，主要包含如下配置：项目端口、项目名称设置、数据库连接、druid 连接配置参数、mybatis 扫描配置和日志输出级别设置。

```
server.prot=8080
server.servlet.context-path=/smartHouse
# 数据库连接配置
spring.datasource.url=jdbc:mysql://localhost:3306/house?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
# druid 配置
# 初始化时建立物理连接的个数
spring.datasource.druid.initial-size=5
# 最大连接池数量
spring.datasource.druid.max-active=30
# 最小连接池数量
spring.datasource.druid.min-idle=5
# 获取连接时最大等待时间，单位毫秒
spring.datasource.druid.max-wait=60000
# 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
spring.datasource.druid.time-between-eviction-runs-millis=60000
# 连接保持空闲而不被驱逐的最小时间
spring.datasource.druid.min-evictable-idle-time-millis=300000
# 用来检测连接是否有效的sql，要求是一个查询语句
spring.datasource.druid.validation-query=SELECT 1 FROM DUAL
# 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
spring.datasource.druid.test-while-idle=true
# 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
spring.datasource.druid.test-on-borrow=false
# 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
spring.datasource.druid.test-on-return=false
# 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
spring.datasource.druid.pool-prepared-statements=true
# 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
spring.datasource.druid.max-pool-prepared-statement-per-connection-size=50
# 配置监控统计拦截的filters，去掉后监控界面sql无法统计
spring.datasource.druid.filters=stat,wall
# 通过connectProperties属性来打开mergeSql功能；慢SQL记录
spring.datasource.druid.connection-properties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
# 合并多个DruidDataSource的监控数据
spring.datasource.druid.use-global-data-source-stat=true
# mybatis 配置
mybatis.mapper-locations=classpath:mapper/*.xml
mybatis.type-aliases-package=com.zzg.model
# 日志记录输出配置
logging.level.com.zzg.mapper=debug
```

温馨提示：目前 Springboot 中默认支持的连接池有 dbcp,dbcp2, tomcat, hikari 三种连接池。由于 Druid 暂时不在 Springboot 中的直接支持，所以需要通过配置文件直接指定加载连接池类型或者自定义配置对象设置连接池。

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
 
    <!--defaultModelType="flat" 大数据字段，不分表 -->
    <context id="Mysql" targetRuntime="MyBatis3Simple" defaultModelType="flat">
        <property name="autoDelimitKeywords" value="true"/>
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>
        <property name="javaFileEncoding" value="utf-8"/>
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
        <plugin type="org.mybatis.generator.plugins.ToStringPlugin"/>
 
        <!-- 注释 -->
        <commentGenerator>
            <property name="suppressAllComments" value="true"/><!-- 是否取消注释 -->
            <property name="suppressDate" value="true"/> <!-- 是否生成注释代时间戳-->
        </commentGenerator>
 
        <!--数据库链接地址账号密码-->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://127.0.0.1:3306/house?serverTimezone=UTC"
                        userId="root"
                        password="123456">
        </jdbcConnection>
 
        <!-- 类型转换 -->
        <javaTypeResolver>
            <!-- 是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.） -->
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>
 
        <!--生成Model类存放位置-->
        <javaModelGenerator targetPackage="com.zzg.model" targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>
 
        <!-- 生成mapxml文件 -->
        <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>
 
        <!-- 生成mapxml对应client，也就是接口dao -->
        <javaClientGenerator targetPackage="com.zzg.mapper" targetProject="src/main/java" type="XMLMAPPER">
            <property name="enableSubPackages" value="false"/>
        </javaClientGenerator>
 
        <table tableName="house_user" domainObjectName="User" enableCountByExample="false"
               enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false"
               selectByExampleQueryId="false">
        </table>
 
    </context>
</generatorConfiguration>
```

4、在项目的 resource 目录下，新增 mybatis-generator 文件夹主要用于存放 mybatis-generator-cfg.xml 代码生成配置文件。

```
package com.zzg;
 
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
/**
 * 1.0.0	默认：1.0.0
 * zzg	作者信息，可在通用配置里修改作者信息
 * 2022/04/19	日期信息，格式可在通用配置中修改
 * 应用程序开始	注释信息
 **/
@SpringBootApplication
@MapperScan("com.zzg.mapper")
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
```

5、执行 MyBatis-Generator 代码生成插件。

![](https://img-blog.csdnimg.cn/50a5bc4b3595425d9003e66e6bbbc1ea.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5Zyo5aWL5paX55qE5aSn6YGT,size_20,color_FFFFFF,t_70,g_se,x_16)

选中需要执行代码生成的项目，按照截图标记的顺序执行：1->2->3->4->5

**执行效果展示：**

![](https://img-blog.csdnimg.cn/a883bd1d87504da985cd71f64f086255.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5Zyo5aWL5paX55qE5aSn6YGT,size_18,color_FFFFFF,t_70,g_se,x_16)

 6、编写 SpringBoot 程序入口和 Controller 实现

SpringBoot 程序入口主要实现：1、添加 SpringBoot 程序标记 @SpringBootApplication.

                                                  2、扫描 Mapper 接口。

```
package com.zzg.controller;
 
import com.zzg.mapper.UserMapper;
import com.zzg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
 
@RestController
public class FirstController {
    @Autowired
    private UserMapper mapper;
 
    @RequestMapping("/hello")
    public String get() {
        List<User> list = mapper.selectAll();
        return "Hello Spring Boot!";
    }
}
```

FirstController：主要实现 Mapper 接口调用。

```
package com.zzg.controller;
 
import com.zzg.mapper.UserMapper;
import com.zzg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;
 
 
@RestController
public class FirstController {
    @Autowired
    private UserMapper mapper;
 
    @RequestMapping("/hello")
    public String get() {
        List<User> list = mapper.selectAll();
        return "Hello Spring Boot!";
    }
}
```