package cn.iocoder.yudao.module.medical.controller.app.record.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "用户 APP - 健康记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "19821")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "患者姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("患者姓名")
    private String patientName;

    @Schema(description = "患者电话", example = "18999999999")
    @ExcelProperty("患者电话")
    private String patientPhone;

    @Schema(description = "性别 1:男 2:女", example = "1")
    @ExcelProperty("性别 1:男 2:女")
    private Integer gender;

    @Schema(description = "年龄", example = "32")
    @ExcelProperty("年龄")
    private Integer age;

    @Schema(description = "身份证号", example = "1234567890")
    @ExcelProperty("身份证号")
    private String idCardNumber;

    @Schema(description = "主诉", example = "头晕，乏力")
    @ExcelProperty("主诉")
    private String chiefComplaint;

    @Schema(description = "现病史", example = "症状持续三天")
    @ExcelProperty("现病史")
    private String presentIllness;

    @Schema(description = "既往史", example = "高血压")
    @ExcelProperty("既往史")
    private String pastHistory;

    @Schema(description = "吸烟史: 1-无, 2-有, 3-一般, 4-多, 5-已戒", example = "2")
    @ExcelProperty("吸烟史: 1-无, 2-有, 3-一般, 4-多, 5-已戒")
    private Integer smokingHistory;

    @Schema(description = "饮酒史: 1-无, 2-有, 3-一般, 4-多, 5-已戒", example = "3")
    @ExcelProperty("饮酒史: 1-无, 2-有, 3-一般, 4-多, 5-已戒")
    private Integer drinkingHistory;

    @Schema(description = "过敏史: 1-无, 2-有", example = "2")
    @ExcelProperty("过敏史: 1-无, 2-有")
    private Integer allergyHistory;

    @Schema(description = "心率(次/分)", example = "78")
    @ExcelProperty("心率(次/分)")
    private Integer heartRate;

    @Schema(description = "血压(mmHg)", example = "130/85")
    @ExcelProperty("血压(mmHg)")
    private String bloodPressure;

    @Schema(description = "指脉氧(%)", example = "96.5")
    @ExcelProperty("指脉氧(%)")
    private Double oxygenSaturation;

    @Schema(description = "血糖(mmol/L)", example = "6.8")
    @ExcelProperty("血糖(mmol/L)")
    private Double bloodGlucose;

    @Schema(description = "体重(kg)", example = "72.5")
    @ExcelProperty("体重(kg)")
    private Double weight;

    @Schema(description = "腰围(cm)", example = "90")
    @ExcelProperty("腰围(cm)")
    private Double waistCircumference;

    @Schema(description = "体脂数(%)", example = "23.4")
    @ExcelProperty("体脂数(%)")
    private Double bodyFat;

    @Schema(description = "诊断", example = "轻微高度血压")
    @ExcelProperty("诊断")
    private String diagnosis;

    @Schema(description = "饮食治疗", example = "1")
    @ExcelProperty("饮食治疗")
    private Integer dietTherapy;

    @Schema(description = "运动治疗", example = "2")
    @ExcelProperty("运动治疗")
    private Integer exerciseTherapy;

    @Schema(description = "药物治疗", example = "1")
    @ExcelProperty("药物治疗")
    private Integer medicationTherapy;

    @Schema(description = "综合治疗方案", example = "控制饮食")
    @ExcelProperty("综合治疗方案")
    private String treatmentPlan;

    @Schema(description = "医生ID", example = "14241")
    @ExcelProperty("医生ID")
    private Long doctorId;

    @Schema(description = "关联预约ID", example = "6695")
    @ExcelProperty("关联预约ID")
    private Long appointmentId;

    @Schema(description = "备注信息")
    @ExcelProperty("备注信息")
    private String remarks;

    @Schema(description = "用户ID", example = "28663")
    @ExcelProperty("用户ID")
    private Long userId;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}