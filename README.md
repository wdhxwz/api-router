# api-router
api路由分发组件，适用于有接口编号等类似概念的服务。封装公共的分发逻辑，使相关人员更专注于业务开发

## 背景

对于业务系统而言，需要向外提供多个服务，此时，一般可以有以下两种选择

1）每个服务单独一个`URL`，这种情况的优点是每个服务的参数类型是可控的(能知道具体参数的类型，并能借助`JSR-303`检验框架进行数据校验)；缺点就是服务方和调用方需要维护对个`URL`地址。

2）向外只提供一个`URL`，内部具体执行的服务，通过入参来标识，如通过`apiNo`标识需要调用的具体服务或者是将`apiNo`作为`URL`路劲的一部分，即`baseUrl/service/{apiNo}`；一般情况每个服务需要的参数都不一样，因此无法定义一个统一的类来标识，这种情况下，可以使用`map`来接收入参。并且只需要维护一个`url`地址,但内部的参数检验需要作额外的序列化工作。

## 综合方案

结合上面的两种方案，提出一种居中的方案：对外只提供一个服务`URL`，统一入参格式为：

```
{
  "head":{
    "apiNo":"api001",
    "version":"V1.0.1",
    ......
  },
  "bady":{
  ......
  }
}

```
