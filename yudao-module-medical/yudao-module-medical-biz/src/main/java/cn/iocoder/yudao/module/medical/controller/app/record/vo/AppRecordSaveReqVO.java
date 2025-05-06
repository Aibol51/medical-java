package cn.iocoder.yudao.module.medical.controller.app.record.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "用户 APP - 健康记录新增/修改 Request VO")
@Data
public class AppRecordSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "19821")
    private Long id;

    @Schema(description = "患者姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "患者姓名不能为空")
    private String patientName;

    @Schema(description = "患者电话", example = "18999999999")
    private String patientPhone;

    @Schema(description = "性别 1:男 2:女", example = "1")
    private Integer gender;

    @Schema(description = "年龄", example = "32")
    private Integer age;

    @Schema(description = "身份证号", example = "1234567890")
    private String idCardNumber;

    @Schema(description = "主诉", example = "头晕，乏力")
    private String chiefComplaint;

    @Schema(description = "现病史", example = "症状持续三天")
    private String presentIllness;

    @Schema(description = "既往史", example = "高血压")
    private String pastHistory;

    @Schema(description = "吸烟史: 1-无, 2-有, 3-一般, 4-多, 5-已戒", example = "2")
    private Integer smokingHistory;

    @Schema(description = "饮酒史: 1-无, 2-有, 3-一般, 4-多, 5-已戒", example = "3")
    private Integer drinkingHistory;

    @Schema(description = "过敏史: 1-无, 2-有", example = "2")
    private Integer allergyHistory;

    @Schema(description = "心率(次/分)", example = "78")
    private Integer heartRate;

    @Schema(description = "血压(mmHg)", example = "130/85")
    private String bloodPressure;

    @Schema(description = "指脉氧(%)", example = "96.5")
    private Double oxygenSaturation;

    @Schema(description = "血糖(mmol/L)", example = "6.8")
    private Double bloodGlucose;

    @Schema(description = "体重(kg)", example = "72.5")
    private Double weight;

    @Schema(description = "腰围(cm)", example = "90")
    private Double waistCircumference;

    @Schema(description = "体脂数(%)", example = "23.4")
    private Double bodyFat;

    @Schema(description = "诊断", example = "轻微高度血压")
    private String diagnosis;

    @Schema(description = "饮食治疗", example = "1")
    private Integer dietTherapy;

    @Schema(description = "运动治疗", example = "2")
    private Integer exerciseTherapy;

    @Schema(description = "药物治疗", example = "1")
    private Integer medicationTherapy;

    @Schema(description = "综合治疗方案", example = "控制饮食")
    private String treatmentPlan;

    @Schema(description = "医生ID", example = "14241")
    private Long doctorId;

    @Schema(description = "关联预约ID", example = "6695")
    private Long appointmentId;

    @Schema(description = "备注信息")
    private String remarks;

    @Schema(description = "用户ID", example = "28663")
    private Long userId;

}