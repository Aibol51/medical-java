# 医疗模块（yudao-module-medical）项目说明文档
## 1. 模块概述
医疗模块（yudao-module-medical）是一个诊所业务管理系统，主要用于管理诊所相关的业务流程，包括药品管理、预约管理、健康记录管理、专家管理、服务管理等功能。该模块采用标准的分层架构设计，遵循 RuoYi-Vue-Pro 框架的开发规范。
2. 模块结构
/yudao-module-medical
├── yudao-module-medical-api        # API 模块，暴露给其它模块调用
└── yudao-module-medical-biz        # 业务实现模块
    ├── src/main/java
    │   └── cn/iocoder/yudao/module/medical
    │       ├── controller          # 控制器层
    │       │   ├── admin           # 管理后台接口
    │       │   └── app             # 用户 APP 接口
    │       ├── service             # 服务层
    │       ├── dal                 # 数据访问层
    │       │   ├── dataobject      # 数据对象
    │       │   └── mysql           # MySQL 操作
    │       └── websocket           # WebSocket 相关
    └── src/main/resources          # 资源文件

## 3. 核心功能模块
### 3.1 预约管理（Appointment）
预约管理模块负责处理患者的预约请求，包括预约创建、确认、完成和过期等状态管理。

主要功能：

- 患者预约创建与管理
- 预约状态流转（待确认、已确认、已完成、已过期）
- WebSocket 实时通知管理员新预约
- 按条件查询预约记录
核心数据模型：

- 预约信息（AppointmentDO）：包含患者姓名、电话、预约时间、症状描述、状态等
### 3.2 健康记录管理（Record）
健康记录模块用于管理患者的诊疗记录，包含详细的健康数据和诊断信息。

主要功能：

- 创建和管理患者健康记录
- 记录患者基本信息、症状、诊断和治疗方案
- 关联预约和医生信息
- 按条件查询健康记录
核心数据模型：

- 健康记录（RecordDO）：包含患者基本信息、生命体征、诊断结果、治疗方案等
### 3.3 药品管理（Drug）
药品管理模块用于管理诊所的药品信息，支持多语言。

主要功能：

- 药品信息的增删改查
- 药品库存管理
- 多语言支持（中文、英文、俄语、哈萨克语）
核心数据模型：

- 药品信息（DrugDO）：包含药品名称（多语言）、描述（多语言）、图片路径、库存数量、状态等
### 3.4 专家管理（Expert）
专家管理模块用于管理诊所的医生和专家信息。

主要功能：

- 专家信息查询
- 按岗位筛选专家
- 专家状态管理
核心数据模型：

- 专家信息（ExpertDO）：包含专家基本信息、岗位、状态等
### 3.5 服务管理（Service）
服务管理模块用于管理诊所提供的医疗服务项目，支持多语言。

主要功能：

- 服务项目的增删改查
- 多语言支持（中文、英文、俄语、哈萨克语）
核心数据模型：

- 服务信息（ServiceDO）：包含服务名称（多语言）、描述（多语言）、状态等
## 4. 接口说明
### 4.1 管理后台接口（Admin API）
管理后台接口主要供诊所管理人员和医生使用，路径前缀为 /admin 。

主要接口：

- 预约管理接口： /admin/appointment/**
- 健康记录管理接口： /admin/record/**
- 药品管理接口： /admin/drug/**
- 专家管理接口： /admin/expert/**
- 服务管理接口： /admin/service/**
### 4.2 用户 APP 接口（App API）
用户 APP 接口主要供患者使用，路径前缀为 /app 。

主要接口：

- 预约接口： /app/appointment/**
- 健康记录接口： /app/record/**
- 药品查询接口： /app/drug/**
- 专家查询接口： /app/expert/**
- 服务查询接口： /app/service/**
## 5. 技术特性
### 5.1 实时通知
系统使用 WebSocket 技术实现实时通知功能，当有新的预约创建时，会实时通知管理员。

### 5.2 数据库设计
数据库表名统一以 medical_ 前缀开头，例如：

- medical_appointment ：预约表
- medical_record ：健康记录表
- medical_drug ：药品表
- medical_service ：服务表
## 6. 集成与依赖
医疗模块集成在 RuoYi-Vue-Pro 框架中，主要依赖以下模块：

- 系统模块（yudao-module-system）：用户、角色、权限管理
- Web 框架（yudao-spring-boot-starter-web）：Web 开发支持
- 安全框架（yudao-spring-boot-starter-security）：认证与授权
- MyBatis 框架（yudao-spring-boot-starter-mybatis）：数据库访问
- Redis 缓存（yudao-spring-boot-starter-redis）：缓存支持
- WebSocket（yudao-spring-boot-starter-websocket）：实时通信
## 7. 部署说明
医疗模块已在 yudao-server 的 pom.xml 中配置，默认会随系统一起启动。如需单独部署或调试，可参考 RuoYi-Vue-Pro 框架的部署文档。

## 8. 注意事项
1. 数据库表名统一以 medical_ 开头
2. Controller URL 统一以 /medical/ 开头
3. 多语言字段命名规范：以语言代码作为后缀，如 nameZh 、 nameEn 等
4. 状态字段使用整数表示，具体含义见代码注释