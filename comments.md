### 完成度：
* 缺少专门查看group的api

__Details:__
- \- StudentController.java:37 bug，新增学员无法进行分组操作

### 知识点：
* 了解下restful最佳实践
* 了解下三层架构

__Details:__

- \- StudentController.java:27 根据restful实践，资源名一般是复数
- \- StudentController.java:28 根据restful实践，POST方法一般返回创建的内容或者Id
- \- StudentController.java:29 POST方法返回的状态码，是201
- \- StudentController.java:29 如果不是有自定义返回的需求，ResponseEntity一般可省略
- \- StudentService.java:14 数据存储相关的操作，不属于service的职责，应该抽取repository层做

### 工程实践：
__Details:__
+ \+ StudentService.java:17 有意识抽取变量
- \- StudentController.java:32 group相关的接口，单独抽取一个controller来做，与students不是操作的一个资源
- \- StudentService.java:57 这种自增id的方式，线程不安全，试试AtomicInteger


