Eureka Server端配置
## 中小规模下，自我保护模式坑比好处多，所以关闭它
eureka.server.enableSelfPreservation=false
## 心跳阈值计算周期，如果开启自我保护模式，可以改一下这个配置
## eureka.server.renewalThresholdUpdateIntervalMs=120000

## 主动失效检测间隔,配置成5秒
eureka.server.evictionIntervalTimerInMs=5000

## 心跳间隔，5秒
eureka.instance.leaseRenewalIntervalInSeconds=5
## 没有心跳的淘汰时间，10秒
eureka.instance.leaseExpirationDurationInSeconds=10

## 禁用readOnlyCacheMap
eureka.server. useReadOnlyResponseCache=false


服务提供者和clinet配置
## 心跳间隔，5秒
eureka.instance.leaseRenewalIntervalInSeconds=5
## 没有心跳的淘汰时间，10秒
eureka.instance.leaseExpirationDurationInSeconds=10

# 定时刷新本地缓存时间
eureka.client.registryFetchIntervalSeconds=5
# ribbon缓存时间
ribbon.ServerListRefreshInterval=2000