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

- 测试（任意的token，为了躲避筛选）：http://localhost:10000/oauth2-client{接口}?token=fsdg

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