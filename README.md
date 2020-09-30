### url
####注册：
  请求url： /register
  入参：（1）登录账号---> loginName
       （1）密码---> password
       （1）用户真实姓名---> userName
       （1）手机号---> phone
  返回参数：data------>1：表示登录成功
                     0：表示登录失败
  
登录：/denglu，

### img文件太大 无法拉取问题解决方法
error: RPC failed; curl 56 OpenSSL SSL_read: Connection was reset, errno 10054
  1、打开gitcmd
  2、设置拉取大小
     git config --global http.postBuffer 524288000
  3、查看git配置
     git config --list
  4、重试拉取


#### user

- id 主键
- user_name 用户名
- real_name 真实姓名
- password 密码
- gender 性别
- birthday 出生日期
- role 角色
- portrait_url 头像地址
- status 状态

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
