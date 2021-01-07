# README

v1.0 - 实现了基本业务逻辑的3个单体

v1.1 - 2个feign消费者bbq和message，1个服务提供者user

v1.2 - sentinel熔断

v1.3 - gateway统一访问



## 服务

### gateway

### oauth2-server

### oauth2-resource

### oauth2-client

### bbq

### message

### user



## 其他

### 状态码约定（给自己用）

- 一般正确：200
- 一般错误：500
- User 注册成功：102
- User注册失败：103
- Oauth2注册成功：104
- Oauth2注册失败：105
- 注册成功：100



### 端口约定

- 功能服务
  - User: 9001
  - Bbq: 9011
  - Message: 9021
- 非功能服务
  - gateway: 10000
  - Oauth2-client: 10010
  - Oauth2-server: 10020
  - Oauth2-resource: 10030



### 服务名称

- bbq-consumer
- user-provider
- message-consumer
- gateway



### 接口

- 说明
    - 2020.1.4测试，和oauth相关的服务，请只启动oauth2-client，其它服务不要启动，本次测试不包含
    权限控制。

- 测试（任意的token，为了躲避网关筛选）：    
    - http://localhost:10000/oauth2-client/bbq/test?token=fsdg
    - http://localhost:10000/oauth2-client/message/test?token=fsdg
    - http://localhost:10000/oauth2-client/user/test?token=fsdg

- 接口表，bbq、message、user、其他

  | 函数               | 接口                | 请求类型 | 是否可用 |
  | ------------------ | ------------------- | -------- | -------- |
  | bbqTest（测试bbq） | /bbq/test           | GET      | 是       |
  | test               | /bbq/bbq            | GET      |          |
  | addABbq            | /bbq/bbq            | POST     |          |
  | getABbqByBbqId     | /bbq/bbq/{bbqId}    | GET      |          |
  | addBbqLike         | /bbq/bbqLike        | PUT      |          |
  | addBbqCommentLike  | /bbq/bbqcommentLike | PUT      |          |
  | addACommentForBbq  | /bbq/bbqcomment     | POST     |          |
  | addBbqImageForBbq  | /bbq/bbqimage       | POST     |          |
  |                    |                     |          |          |
  |                    |                     |          |          |

  | 函数                      | 接口                | 请求类型 | 是否可用 |
  | ------------------------- | ------------------- | -------- | -------- |
  |                           | /message/test       | GET      | 是       |
  | test                      | /message/bbq        | GET      |          |
  | getAllMessageOrderByDate  | /message/message    | GET      |          |
  | getAMessageByMessageId    | /message/single     | GET      |          |
  | addMessage                | /message/message    | POST     |          |
  | addMessageImageForMessage | /message/messageimg | POST     |          |
  |                           |                     |          |          |
  |                           |                     |          |          |
  |                           |                     |          |          |
  |                           |                     |          |          |

  | 函数       | 接口                   | 请求类型 | 是否可用 |
  | ---------- | ---------------------- | -------- | -------- |
  | userTest   | /user/test             | GET      | 是       |
  | getAlluser | /user/user             | GET      |          |
  | getAUser   | /user/getById/{userId} | GET      |          |
  |            |                        |          |          |
  |            |                        |          |          |
  |            |                        |          |          |

  | 函数     | 接口      | 请求类型 | 是否可用 |
  | -------- | --------- | -------- | -------- |
  | login    | /login    | POST     | 否       |
  | register | /register | POST     | 否       |
  |          |           |          |          |
  |          |           |          |          |
  |          |           |          |          |
  |          |           |          |          |



### 角色和权限

#### Role

- 一般查看发表：Student
  - /bbq/**
- 社团学院：Orgnization
- 管理员：Admin

#### User

- 普通学生
- 社团负责人
- 管理员

权限

### 接口


# 2020.12

## 功能

### 个人、社团、学院注册登陆

#### User

User_id

User_account

User_passward

User_email

User_name

User_detail

#### Role

#### Authority



### 表白墙

#### Bbq

Bbq_id

Bbq_message

Bbq_date

Bbq_user_id

Bbq_like

#### bbq_image

Bbq_image_id

Bbq_id

Bbq_image_url

#### bbq_comment

Bbq_comment_id

Bbq_user_id

Bbq_id

Bbq_comment_data

Bbq_comment_message

Bbq_comment_like


### 社团、学院信息平台（需要认证）

#### Message

Message_id

Message_user_id

Message_detail

Message_date

#### Message_Image

Message_image_id

Message_id

Message_image_url

# 分工

项目经理：zsh

产品经理：yjb

架构师：zx

前端工程师：czd

后端工程师：wcy



前端：czd

后端：yjb

性能测试：zsh

文档，用户手册，解决方案：zx



Spring - spring boot - spring cloud

千锋教育，李为民



Ddl1: 9

# 坑

## nacos服务注册与发现

- pom.xml添加依赖，涉及到spring boot和spring cloud alibab的版本问题

- [版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

  - ```yaml
    <!-- Spring Cloud Begin -->
    <dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    <version>2.2.3.RELEASE</version>
    </dependency>
    
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        <version>2.2.3.RELEASE</version>
    </dependency>
    
    <!-- Spring Cloud End -->
    ```

- nacos版本，和spring cloud alibaba需要对应

## 使用Feign作服务消费者

- pom.xml依赖，需要注意feign的版本和nacos的版本

- 另外，不知道什么原因，单单引入feign汇报缺少依赖的错，需要加上ribbon的依赖，最终如下：

  - ```yaml
    <!-- Spring Cloud Begin -->
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        <version>2.2.3.RELEASE</version>
    </dependency>
    
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
        <version>2.0.0.RELEASE</version>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        <version>2.0.0.RELEASE</version>
    </dependency>
    
    
    <!-- Spring Cloud End -->
    ```

    

## Sentinel熔断器

- 打开熔断器网页面板

```bash
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
```

网址：http://localhost:8080/#/dashboard/home