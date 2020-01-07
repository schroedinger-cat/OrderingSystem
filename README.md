# 外卖订餐系统

**项⽬框架:**
+ SpringCloud+SpringMVC+SpringFramework+Mybatis+Thymeleaf+Layui 

**数据存储:** 
+ Mysql8.3

**实现功能:** 
+ 1.客户端针对普通用户，功能包括用户登陆、用户退出、菜品订购、我的订单
+ 2.管理员登陆、管理员退出、添加菜品、查询菜品、修改菜品、删除菜品、订单处理、添加用户、查询用户、删除用户。

**模块划分:**
+ 1.account 提供账户服务：用户和管理的登录退出。
+ 2.menu 提供菜品服务：添加菜品、删除菜品、修改菜品、查询菜品。
+ 3.order 提供订单服务：添加订单、查询订单、删除订单、处理订单。
+ 4.user 提供用户服务：添加用户、查询用户、删除用户。
+ 5.client  分离出一个服务消费者，调用以上四个服务提供者，服务消费者包含了客户端的前端页面和后台接口、后台管理系统的前端页面和后台接口。用户 / 管理员直接访问的资源都保存在服务消费者中，服务消费者根据具体的需求调用四个服务提供者的业务逻辑，通过 Feign 实现负载均衡。
+ 6.configserver四个服务提供者和一个服务消费者都需要在注册中心进行注册，同时可以使用配置中心来对配置文件进行统一集中管理。
+ 7.eurekaserver 注册中心
![](src/main/resources/static/img/model.png)

**需要修改的地方:** 
+ [account-dev.yml](configserver/src/main/resources/shared/account-dev.yml) 
+ [menu-dev.yml](configserver/src/main/resources/shared/menu-dev.yml)
+ [order-dev.yml](configserver/src/main/resources/shared/order-dev.yml)
+ [user-dev.yml](configserver/src/main/resources/shared/user-dev.yml)
+ *数据库名称:*
+ *用户名:*
+ *密码*

````yml
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/****?characterEncoding=utf-8
        username: ****
        password: ****

````
**创建数据库**
+ 执行 [/resources/static](src/main/resources/static/)下的.sql文件

