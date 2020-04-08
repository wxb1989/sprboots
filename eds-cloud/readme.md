#eds-cloud父項目的pom.xml文件中，主要做了以下几件事：
    1.配置Spring Boot的版本
    2.配置Spring Cloud的版本
    3.配置微服务的一些基本组件，如actuator、eureka、web和test。
    4.配置编码方式
    5.配置java版本
    6.配置子模块
    
 #ribbon全局设置
    ribbon:
     ReadTimeout: 6000
     ConnectTimeout: 6000
     OkToRetryOnAllOperations: true
     MaxAutoRetries: 1
     MaxAutoRetriesNextServer: 2
     
     NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #配置规则 随机
     NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RoundRobinRule #配置规则 轮询
     NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RetryRule #配置规则 重试
     NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule #配置规则 响应时间权重
 
 #ribbon局部服务设置每个fegin的调用端都可以配置一个
    service-id:    #例如eds-base                                                  # 服务ID
         ribbon:
         ConnectTimeout: 6000 # 毫秒连接超时时间
         ReadTimeout: 6000   # 毫秒逻辑处理超时时间
         OkToRetryOnAllOperations: true #是否对所有操作都进行重试
         MaxAutoRetries: 1  #对当前实例的最大重试次数(请求服务超时6s则会再请求一次)    
         MaxAutoRetriesNextServer: 1 #切换实例的最大重试次数(如果还失败就切换下个实例访问,切换一次)