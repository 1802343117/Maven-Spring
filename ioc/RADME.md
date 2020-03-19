# Java注解配置类
https://uploader.shimo.im/f/Z2OkucHSKRcT6SMy.png!thumbnail
## 个人小结：
JdbcTemplate概念：JdbcTemplate类 提供了很多便利的方法解决诸如把数据库数据转变成基本数据类型或对象，执行写好的或可调用的数据库操作语句
要想通过 JdbcTemplate类 连接数据库，你需要给它（JdbcTemplate类）一个 DruidDataSource类型 的值。
而 DruidDataSource类 中又有提供给 JdbcTemplate类 连接数据库所需要各种属性（如：DriverClassName、Url、Username、Password）
## 代码理解为：
class JdbcTemplate { private DruidDataSource druidDataSource; ..... }
class DruidDataSource { private DriverClassName driverClassName; private Url url; ....... }
其余内容可相同方式理解，若要深入了解，可 CTRL + 鼠标左键 点击 JdbcTemplate，进入JdbcTemplate类包中学习理解（别的类包如上）
## 近期学习内容：
https://uploader.shimo.im/f/gtYdPfna8VM0mws4.png!thumbnail