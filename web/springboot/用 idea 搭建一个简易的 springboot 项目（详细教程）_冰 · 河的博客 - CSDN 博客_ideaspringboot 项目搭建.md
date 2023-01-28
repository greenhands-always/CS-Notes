---
url: https://blog.csdn.net/m0_45161766/article/details/123639583
title: 用 idea 搭建一个简易的 springboot 项目（详细教程）_冰 · 河的博客 - CSDN 博客_ideaspringboot 项目搭建
date: 2023-01-03 16:59:01
tag: 
summary: 
---
一、创建项目

1.File->new->project；  

![](https://img-blog.csdnimg.cn/0f8e13039a3a47c5b5bb9289bf6d7493.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 选择 “Spring Initializr”，点击 next；（jdk1.8 默认即可）  

![](https://img-blog.csdnimg.cn/fb4968e30adc466a876998e614df3efa.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

3. 完善项目信息，组名可不做修改，项目名可做修改；最终建的项目名为：test，src->main->java 下包名会是：com->example->test；点击 next；

![](https://img-blog.csdnimg.cn/19f1dbb33a1e4af3af336c065fb840a3.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

4.Web 下勾选 Spring Web Start，（网上创建 springboot 项目多是勾选 Web 选项，而较高版本的 Springboot 没有此选项，勾选 Spring Web Start 即可，2.1.8 版本是 Spring Web）；Template Englines 勾选 Thymeleaf；SQL 勾选：MySQL Driver，JDBC API 和 MyBatis Framework 三项；点击 next；  

![](https://img-blog.csdnimg.cn/a465c978ae1b4f0c86800153627a8541.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

5. 选择项目路径，点击 finish；打开新的窗口；

![](https://img-blog.csdnimg.cn/2cfa8c6d43bf40b08a7a83affac4d5ef.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

![](https://img-blog.csdnimg.cn/ab08decfe94749919e94a0814529c70f.png)

6. 刚创建好的项目目录结构

![](https://img-blog.csdnimg.cn/70a26f43584241f0a24ad54751c5806b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

7. 点击右侧的 Maven，点击设置（扳手图标）进行项目 Maven 仓库的配置；

![](https://img-blog.csdnimg.cn/bf45ad470a2c4f589a8c4264f21f6b0a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_17,color_FFFFFF,t_70,g_se,x_16)

8.（1）选择本地 Maven 路径；（2）勾选配置文件后边的选项，然后修改为本地 Maven 的配置文件，它会根据配置文件直接找到本地仓库位置；  

![](https://img-blog.csdnimg.cn/23008f61f68f4668bf0c2a6a9a478f0f.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

9. 配置完后，如果没有自动导包，可以点击左上角重新导包按钮，或者呢个下载按钮，选择下载所有源文件和文档

![](https://img-blog.csdnimg.cn/8b398688389443e2af463bf1d4e3a5f0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_17,color_FFFFFF,t_70,g_se,x_16)

10. 在 templates 文件下新建 index.html 页面，作为启动的初始页面；  

![](https://img-blog.csdnimg.cn/5ade4a475fab491292294a4668186217.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hello</title>
</head>
<body>
    你好！初学者，我是SpringBoot的简单启动页面！
</body>
</html>
```

11. 在 com.example.test 下新建 controller 文件夹，在 controller 文件夹下建一个简单的 helloController 类；（Controller 类要添加 @Controller 注解，项目启动时，SpringBoot 会自动扫描加载 Controller）  

![](https://img-blog.csdnimg.cn/607695ff2cd84d3cb0b793669d6ce0f3.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

```
package com.example.test.controller;
 
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloController {
 
    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }
}
```

12. 在 resources 文件夹下 application 中先配置 DataSource 基本信息，application 文件有两种文件格式，一种是以. properties 为后缀，一种是以. yml 为后缀的，两种配置方式略有差别，详情可参考这个网址：https://blog.csdn.net/qq_29648651/article/details/78503853；在这我是用. yml 后缀的文件格式。右键 application 文件选择 Refact，选择 Rename，将后缀改为 yml；

![](https://img-blog.csdnimg.cn/6c1b7066de7e4bc3856be42d0b94fec6.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

```
spring:
 datasource:
 name: test  #数据库名
 url: jdbc:mysql://localhost:3306/test #url
 username: root  #用户名
 password: 123456  #密码
 driver-class-name: com.mysql.jdbc.Driver  #数据库链接驱动
```

13. 运行项目启动类 TestApplication.java

![](https://img-blog.csdnimg.cn/80c756d53bdf472ab61b3ad585102cac.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

可以发现上面有一个 WARN 警告，那是因为还没有配置编写 MyBatis 的相关文件，下面会进行详解；

```
2019-08-02 09:14:27.473  WARN 9120 --- [           main] o.m.s.mapper.ClassPathMapperScanner      : No MyBatis mapper was found in '[com.example.test]' package. Please check your configuration.
```

14. 在浏览器中输入 localhost:8080, 回车显示初始的 index 界面；到这项目的初步搭建已经完成，下面可以下一些简单的业务逻辑，比如从数据库获取信息，登录之类的简单功能；

![](https://img-blog.csdnimg.cn/595e177355dc47479d937e73b5b168dc.png)

15. 在进行下一步编写时，我们先来链接一下数据库；点击右侧的 Database，点 “加号”，新建数据库链接；

![](https://img-blog.csdnimg.cn/d4f8e522a05d4181a414272b021e5ff2.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_15,color_FFFFFF,t_70,g_se,x_16)

16. 填写数据库相关信息，点击 Test Connection；

![](https://img-blog.csdnimg.cn/7ddc2d0437a44980915f79da52898483.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

17. 如果链接失败可能是驱动的问题，点击左上角的小扳手，进入数据库设置界面  

![](https://img-blog.csdnimg.cn/7c1fdeb4650f466aa2bab8aaede8901e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

18. 连接成功后，显示数据库信息，user 表的基本信息也显示了，下面就照这个来了；

![](https://img-blog.csdnimg.cn/e3521812d2f6493d8fbfd9f4f1dbf590.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_16,color_FFFFFF,t_70,g_se,x_16)

19.SpringBoot 项目大概分为四层：

（1）DAO 层：包括 XxxMapper.java(数据库访问接口类)，XxxMapper.xml(数据库链接实现)；（这个命名，有人喜欢用 Dao 命名，有人喜欢用 Mapper，看个人习惯了吧）

（2）Bean 层：也叫 model 层，模型层，entity 层，实体层，就是数据库表的映射实体类，存放 POJO 对象；

（3）Service 层：也叫服务层，业务层，包括 XxxService.java(业务接口类)，XxxServiceImpl.java（业务实现类）；（可以在 service 文件夹下新建 impl 文件放业务实现类，也可以把业务实现类单独放一个文件夹下，更清晰）

（4）Web 层：就是 Controller 层，实现与 web 前端的交互。

依照上面四层，创建目录结构如下：

![](https://img-blog.csdnimg.cn/d295e23ff6a943efb5c3c62e4e85b8dc.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_14,color_FFFFFF,t_70,g_se,x_16)

20. 代码展示：

（1）在 application 配置文件中添加 MyBatis 配置：

```
spring:
 datasource:
 name: test  #数据库名
 url: jdbc:mysql://localhost:3306/test #url
 username: root  #用户名
 password: 123456  #密码
 driver-class-name: com.mysql.jdbc.Driver  #数据库链接驱动
 
 
mybatis:
 mapper-locations: classpath:mapper/*.xml  #配置映射文件
 type-aliases-package: com.example.test.bean #配置实体类
```

（2）pom.xml 文件配置信息（备注：这个文件以前没有，2019/12/9 日粉丝发现的，这个里面也添加了单元测试所需的配置，记得要重新导一下 Maven 包哦）

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.6.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>test</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>test</name>
    <description>Demo project for Spring Boot</description>
 
    <properties>
        <java.version>1.8</java.version>
    </properties>
 
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <!--thymeleaf模板引擎配置-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <!--Web依赖-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--MyBatis配置-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.0</version>
        </dependency>
        <!--MySQL数据库配置-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.41</version>
            <scope>runtime</scope>
        </dependency>
        <!--单元测试配置-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
 
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
 
</project>
```

(3)Bean 实体类，依据数据库表，生成 set 和 get 方法；

```
package com.example.test.bean;
 
public class UserBean {
    private int id;
    private String name;
    private String password;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
```

（4）DAO 层访问数据库接口文件：

```
package com.example.test.mapper;
 
import com.example.test.bean.UserBean;
 
public interface UserMapper {
 
    UserBean getInfo(String name,String password);
 
}
```

（5）DAO 层访问数据库实现文件（需在 resource 包下创建 mapper 文件夹，然后再创建一个 UserMapper.xml. 在 application 配置文件中 mybatis:mapper-locations: 对应的就是该文件地址），注意标签的 namespace 属性要填写 访问数据库接口类文件路径：

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.example.test.mapper.UserMapper">
 
    <select id="getInfo" parameterType="String" resultType="com.example.test.bean.UserBean">
        SELECT * FROM user WHERE name = #{name} AND password = #{password}
    </select>
 
</mapper>
```

（6）Service 层业务接口类编写：

```
package com.example.test.service;
 
import com.example.test.bean.UserBean;
 
public interface UserService {
 
    UserBean loginIn(String name,String password);
 
}
```

（7）Service 层业务实现类编写，注意要注解 @Service，注入 DAO：

```
package com.example.test.serviceImpl;
 
import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class UserServiceImpl implements UserService {
 
    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;
 
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }
}
```

（8）项目启动类要添加注解 @MapperScan 项目启动时扫描 mapper 接口，否则会报错找不到 mapper 文件：

package com.example.test;

```
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
@MapperScan("com.example.test.mapper")
public class TestApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
 
}
```

（9）编写测试类，看是否能成功 访问数据库，获取数据库信息：

package com.example.test;

```
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
 
    @Autowired
    UserService userService;
 
    @Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("a","a");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }
 
}
```

（10） controller 层，注意添加 @controller 注解，注入 Service 服务：

```
package com.example.test.controller;
 
import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
    //将Service注入Web层
    @Autowired
    UserService userService;
 
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
 
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserBean userBean = userService.loginIn(name,password);
        if(userBean!=null){
            return "success";
        }else {
            return "error";
        }
    }
 
 
 
}
```

（11）html 文件：

login.html

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
    <form role="form" action = "/loginIn" method="post">
        账号：<input type="text" id="name" name = "name"> <br>
        密码：<input type="password" id = "password" name = "password"> <br>
        <input type="submit" id = "login" value = "login">
    </form>
 
</body>
</html>
```

success.html

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>success</title>
</head>
<body>
    <h1>登录成功！</h1>
</body>
</html>
```

error.html

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>error</title>
</head>
<body>
    <h1>登录失败！</h1>
</body>
</html>
```

21. 先运行测试类，看是否成功获取数据库信息：  

![](https://img-blog.csdnimg.cn/812713c0f6b1423887e4c28a0cd578cd.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

22. 同时发现一条警告信息，是数据库连接的 jar 包问题：

```
2019-08-02 11:25:04.150  WARN 16868 --- [           main] com.zaxxer.hikari.util.DriverDataSource  : Registered driver with driverClassName=com.mysql.jdbc.Driver was not found, trying direct instantiation.
```

打开 pom.xml 文件，发现配置文件中未指定数据库连接的 jar 包的版本号，用 version 标签引入

`<version>5.1.41</version>`  

![](https://img-blog.csdnimg.cn/f8419a126a0749668733b84daaf98be3.png)

![](https://img-blog.csdnimg.cn/53b5e06f63d24f26a3782e0fcfb8b780.png)

重新运行测试类，WARN 警告消除

![](https://img-blog.csdnimg.cn/c12b26f2ff354e06a6b46bf3e7c16036.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

23. 运行 TestApplication.java 文件，启动项目，无任何 WARN 警告信息，进入浏览器输入 localhost:8080/login

![](https://img-blog.csdnimg.cn/841c4aca9c87447ba66318f3f730f9f0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_20,color_FFFFFF,t_70,g_se,x_16)

![](https://img-blog.csdnimg.cn/8618b4e5ebf444aca49cc47021326f52.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_17,color_FFFFFF,t_70,g_se,x_16)

![](https://img-blog.csdnimg.cn/7514217cab8445d0b77949419da3dcbf.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5YawwrfmsrM=,size_17,color_FFFFFF,t_70,g_se,x_16)

项目到这里就算完美结束了。

项目源码放在 GitHub 上，可以下载参考：[https://github.com/redesperado/SpringBoot.git](https://github.com/redesperado/SpringBoot.git)

有一个基于本项目添加增删改查功能的项目，仅供参考：[https://github.com/redesperado/test1.git](https://github.com/redesperado/test1.git)

附一个微服务项目搭建过程，有想学的可以参考一下

IDEA 基于 springboot 采用 Dubbo+zookeeper+Redis 搭建微服务项目 - 详细教程：[https://blog.csdn.net/baidu_39298625/article/details/108330298](https://blog.csdn.net/baidu_39298625/article/details/108330298)

大家如果在创建过程 中遇到什么问题，可以在下边提供的链接中看看，这些是我在创建项目过程遇到的问题，希望可以帮到大家：

1. 启动报错：Error starting ApplicationContext. To display the conditions report re-run your application with ‘debug’ enabled.

[https://blog.csdn.net/baidu_39298625/article/details/98261102](https://blog.csdn.net/baidu_39298625/article/details/98261102)

2.mapper.xml 文件数据库字段报红

[https://blog.csdn.net/baidu_39298625/article/details/98265845](https://blog.csdn.net/baidu_39298625/article/details/98265845)

3. 项目正常启动，访问默认 index 页面时 404

[https://blog.csdn.net/baidu_39298625/article/details/98501840](https://blog.csdn.net/baidu_39298625/article/details/98501840)

4.  链接 MySQL 数据库报错：java.sql.SQLException: The server time zone value ‘�й���׼ʱ��’ is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.

[https://blog.csdn.net/baidu_39298625/article/details/100915264](https://blog.csdn.net/baidu_39298625/article/details/100915264)

5. 中文用户名登录失败，无报错信息

[https://blog.csdn.net/baidu_39298625/article/details/103494461](https://blog.csdn.net/baidu_39298625/article/details/103494461)