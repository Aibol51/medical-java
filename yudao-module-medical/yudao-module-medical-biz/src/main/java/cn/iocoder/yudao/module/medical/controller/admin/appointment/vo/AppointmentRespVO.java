package cn.iocoder.yudao.module.medical.controller.admin.appointment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 预约 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppointmentRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "26332")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "患者姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("患者姓名")
    private String patientName;

    @Schema(description = "患者电话", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("患者电话")
    private String patientPhone;

    @Schema(description = "预约时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("预约时间")
    private LocalDateTime appointmentTime;

    @Schema(description = "症状描述")
    @ExcelProperty("症状描述")
    private String symptom;

    @Schema(description = "预约状态 1:待确认 2:已确认 3:已完成 4:已过期", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("预约状态 1:待确认 2:已确认 3:已完成 4:已过期")
    private Integer status;

    @Schema(description = "预约用户ID", example = "16309")
    @ExcelProperty("预约用户ID")
    private Long userId;

    @Schema(description = "主治医生ID", example = "12532")
    @ExcelProperty("主治医生ID")
    private Long doctorId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}