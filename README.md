### url
注册：/register
登录：/login

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
