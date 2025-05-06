package cn.iocoder.yudao.module.medical.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
public interface ErrorCodeConstants {
    // TODO 待办：请将下面的错误码复制到 yudao-module-medical-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！
// ========== 药品 1-023-000-000 补充编号 ==========
    ErrorCode DRUG_NOT_EXISTS = new ErrorCode(1_023_000_000, "药品不存在");

    // ========== 轮播图 1-023-100-000 ==========
    ErrorCode SWIPER_NOT_EXISTS = new ErrorCode(1_023_100_000, "轮播图不存在");

    // ========== 新闻 1-023-200-000 ==========
    ErrorCode NEWS_NOT_EXISTS = new ErrorCode(1_023_200_000, "新闻不存在");

    // ========== 服务 1-023-300-000 ==========
    ErrorCode SERVICE_NOT_EXISTS = new ErrorCode(1_023_300_000, "服务不存在");

    // ========== 专家 1-023-400-000 ==========
    ErrorCode EXPERT_NOT_EXISTS = new ErrorCode(1_023_400_000, "专家不存在");

    // ========== 预约 1-023-500-000 ==========
    ErrorCode APPOINTMENT_NOT_EXISTS = new ErrorCode(1_023_500_000, "预约不存在");

    // ========== 健康记录 1-023-600-000 ==========
    ErrorCode RECORD_NOT_EXISTS = new ErrorCode(1_023_600_000, "健康记录不存在");
}
