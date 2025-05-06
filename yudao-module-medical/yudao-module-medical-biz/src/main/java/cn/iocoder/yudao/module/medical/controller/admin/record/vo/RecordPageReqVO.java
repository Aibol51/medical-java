package cn.iocoder.yudao.module.medical.controller.admin.record.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 健康记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecordPageReqVO extends PageParam {

    @Schema(description = "患者姓名", example = "李四")
    private String patientName;

    @Schema(description = "患者电话", example = "18999999999")
    private String patientPhone;

    @Schema(description = "医生ID", example = "14241")
    private Long doctorId;

    @Schema(description = "用户ID", example = "28663")
    private Long userId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}