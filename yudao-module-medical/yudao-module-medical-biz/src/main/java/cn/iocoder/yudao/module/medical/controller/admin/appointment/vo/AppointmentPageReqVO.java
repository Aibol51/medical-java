package cn.iocoder.yudao.module.medical.controller.admin.appointment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 预约分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppointmentPageReqVO extends PageParam {

    @Schema(description = "患者姓名", example = "赵六")
    private String patientName;

    @Schema(description = "患者电话")
    private String patientPhone;

    @Schema(description = "预约时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] appointmentTime;

    @Schema(description = "预约状态 1:待确认 2:已确认 3:已完成 4:已过期", example = "2")
    private Integer status;

    @Schema(description = "预约用户ID", example = "16309")
    private Long userId;

    @Schema(description = "主治医生ID", example = "12532")
    private Long doctorId;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}