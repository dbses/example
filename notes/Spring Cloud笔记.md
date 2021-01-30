# 01 | Spring Cloud Gateway：新一代API网关服务

> 作者：MacroZheng
> 链接：https://juejin.im/post/5db6eed6518825644076d0b6
> 来源：掘金
> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

**两种不同的配置路由方式**

1. 使用 yml 配置

   ```yml
   server:
     port: 9201
   service-url:
     user-service: http://localhost:8201
   spring:
     cloud:
       gateway:
         routes:
           - id: path_route #路由的ID
             uri: ${service-url.user-service}/user/{id} #匹配后路由地址
             predicates: # 断言，路径相匹配的进行路由
               - Path=/user/{id}
   ```

2. 使用Java Bean配置

   ```java
   /**
    * Created by macro on 2019/9/24.
    */
   @Configuration
   public class GatewayConfig {
   
       @Bean
       public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
           return builder.routes()
                   .route("path_route2", 
                          r -> r.path("/user/getByUsername").uri("http://localhost:8201/user/getByUsername")
                         )
                   .build();
       }
   }
   ```

**API 网关支持的功能**

   - 路由

     可以定制不同的路由策略，包括：

     - 指定时间前后匹配
     - 指定时间区间匹配
     - 带指定 Cookie 匹配
     - 带指定请求头匹配
     - 指定 Host 匹配
     - 请求方法匹配（GET/POST）
     - 指定路径匹配
     - 带指定查询参数匹配
     - 指定请求 ip 匹配
     - 权重匹配

   - 过滤

     可通过实现不同的过滤器，比如：

     - 去除指定数量的路径前缀
     - 增加路径前缀
     - Hystrix 过滤器以实现服务**降级**
     - RequestRateLimiter 过滤器以实现**限流**
     - Retry GatewayFilter 以实现**重试**
     
- 动态路由

- 负载均衡

