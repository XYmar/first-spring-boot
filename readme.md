# 数据库相关配置（Spring-data-jpa）
1. 数据库配置文件(resource/application.properties)


# 实体类 entity
1. 创建角色实体类
2. 添加注解
   - @Entity: 用于与数据库对应起来，生成对应的数据库表；
   - @Data: lombok的注解，用于根据我们定义的属性生成对应的get set方法，以及toString(),hashCode()方法。避免手写麻烦。
   - @Id: 对此实体类的ID加上此注解注明。
  ```
@Entity
@Data
public class RoleEntity {

    @Id
    private String id;

    private String name;


}
  ```
3. 创建用户实体类，并实现UserDetails接口。添加对应属性（可从GitHub仓库复制）。

  ```
    implements UserDetails 
  ```
4. 实现接口的getAuthorities（）方法，（可从GitHub仓库复制）。
   - 根据角色生成权限信息。
   - 规范是 ROLE_...

# 仓储类  repository
1. 用于定义接口，处理与数据库之间的操作
2. 继承JpaRepository类，传递的参数
   - 第一个参数： 传递实体类类型；
   - 第二个参数： 此实体类的主键类型。
```
    @Repository
    public interface UserRepository extends JpaRepository<UserEntity, String> {
        UserEntity findAllByUsername(String username);
    }
```
3. 添加注解@Repository
   

# service  
1. 作用： 注入仓储类，并调用仓储类中定义的方法，处理数据库逻辑。
           定义增删改查等方法。
2. 创建UserVice
   - 实现UserDetailsService接口并实现其中的方法。
3. 添加注解
   - @Service
   - @Slf4j: 日志相关
   
#RunApplication
1. 系统运行时即执行此类的run();
2. 添加注解
   
# OAuth2配置文件
## AuthorizationServerConfig文件
主要用来配置OAuth2的授权认证服务器，为授权的Client发放JWT Token
## ResourceServerConfig文件
主要用来配置，OAuth2协议中的资源持有方，应该如何检测、解析收到的Token
## WebSecurityConfig文件
用来向外界暴露AuthenticationManager

- AuthenticationManager：用来向外界暴露Spring安全相关实现的接口，如配置过滤器、token生成、校验等。