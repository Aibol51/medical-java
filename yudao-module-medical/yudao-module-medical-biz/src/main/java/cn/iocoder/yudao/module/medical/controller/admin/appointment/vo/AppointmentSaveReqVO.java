package cn.iocoder.yudao.module.medical.controller.admin.appointment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 预约新增/修改 Request VO")
@Data
public class AppointmentSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "26332")
    private Long id;

    @Schema(description = "患者姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "患者姓名不能为空")
    private String patientName;

    @Schema(description = "患者电话", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "患者电话不能为空")
    private String patientPhone;

    @Schema(description = "预约时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "预约时间不能为空")
    private LocalDateTime appointmentTime;

    @Schema(description = "症状描述")
    private String symptom;

    @Schema(description = "预约状态 1:待确认 2:已确认 3:已完成 4:已过期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "预约状态 1:待确认 2:已确认 3:已完成 4:已过期不能为空")
    private Integer status;

    @Schema(description = "预约用户ID", example = "16309")
    private Long userId;

    @Schema(description = "主治医生ID", example = "12532")
    private Long doctorId;

}