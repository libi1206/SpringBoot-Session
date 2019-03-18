### Spring-Session解决Session共享问题
* 这个项目启动需要使用Nginx，在Nginx你配置8080和8081两个上游服务器，使用轮询（默认）的工作方式，然后启动的时候启动8080和8081两个应用。。来模拟多个服务器的session共享问题
* 解决这个问题只需要导入org.springframework.session:spring-session-data-redis这个包，配置Redis信息就可以实现。。还以为需要配置一大堆东西。。记录一下
* 当不使用域名（不走Nginx）访问的时候，Session也会更换