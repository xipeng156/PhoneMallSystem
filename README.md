# 网上手机商城
> 前端开发：苏坤（sukun1140@163.com）
> 后端开发：席鹏（1562107250@qq.com）
>
> 欢迎发送意见&建议到我们的邮箱

# 项目配置

- jdk：1.8
- 数据库：mysql 5.1+
- tomcat：8.5+
- 建议浏览器：chrome

# 技术覆盖

总体架构：ssm+HTML5、css、JavaScript、jquery、bootstrap、vue

# 数据库相关字段及解释


#### user

- id 主键
- user_name 用户名
- real_name 真实姓名
- password 密码
- gender 性别
- birthday 出生日期
- role 角色
- portrait_url 头像地址status 状态

#### address

- id 主键
- uid 用户id
- u_address 地址

#### goods

- id 主键
- good_id 商品id
- name 商品名
- introduce 商品介绍
- price 价格
- invalid_time 下架时间

#### order

- id 主键
- order_id 订单号
- u_id 用户id
- o_id 商品id
- total 商品总额
- status 订单状态
- address_id 订单地址 
- create_time 创建时间

#### shopcart

- id 主键
- u_id 用户id
- o_id 商品id
- total 商品总额
- create_time 创建时间
