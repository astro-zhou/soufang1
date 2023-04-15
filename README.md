# 搜房网项目

一个房屋租赁平台, 房地产的三级市场.

# 技术选型

* 构建系统: Maven
* 后台框架: Spring Boot 全家桶
* 前端框架： vue 3


# 附录信息

## Maven

Maven 是一个 Java 的构建系统

版本选择: 3.8.1

Maven 采用 Java 源码标准布局(src 部分)

```
.
├── README.md               # 项目源代码主文档, 包含了项目说明 技术信息 负责人(Owner)信息
├── pom.xml                 # Maven 的项目描述文件, 包含了项目信息 依赖管理 代码构建等信息, 会被 maven 读取使用
└── src                     # 项目源代码目录
├── main                    # 项目源代码主目录
│   ├── java                # 项目 java 源代码目录
│   │   └── com
│   │     └── soufang
│   │       └── Main.java
│   └── resources           # 项目资源目录
└── test                    # 项目单元测试目录
    └── java                # java 源代码单元测试目录 
    └── resources           # java 测试资源目录
```

Maven wrapper: 用于 Maven 版本管理
> 使用 `mvn wrapper:wrapper` 命令

## Spring Boot

Spring Boot 是一个来自于 Spring 的脚手架框架, 基于"约定大于配置"的理念.

版本选择: 2.7.9

## nodejs 环境

推荐安装国内源

```shell
npm install cnpm -g --registry=https://registry.npmmirror.com
```

初始化 vue:

```shell
cnpm init vue@latest
```

选择：
```
✔ Project name:  frontend
✔ Add TypeScript? … No
✔ Add JSX Support? … No
✔ Add Vue Router for Single Page Application development? … Yes
✔ Add Pinia for state management? … No
✔ Add Vitest for Unit Testing? … No
✔ Add an End-to-End Testing Solution? › No
✔ Add ESLint for code quality? … No
```

安装依赖：
> 记得 `cd frontend`

```shell
cnpm install
```

运行开发环境：

```shell
cnpm run dev
```