package cn.iocoder.yudao.module.medical.dal.dataobject.record;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 健康记录 DO
 *
 * @author admin
 */
@TableName("medical_record")
@KeySequence("medical_record_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 患者姓名
     */
    private String patientName;
    /**
     * 患者电话
     */
    private String patientPhone;
    /**
     * 性别 1:男 2:女
     */
    private Integer gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身份证号
     */
    private String idCardNumber;
    /**
     * 主诉
     */
    private String chiefComplaint;
    /**
     * 现病史
     */
    private String presentIllness;
    /**
     * 既往史
     */
    private String pastHistory;
    /**
     * 吸烟史: 1-无, 2-有, 3-一般, 4-多, 5-已戒
     */
    private Integer smokingHistory;
    /**
     * 饮酒史: 1-无, 2-有, 3-一般, 4-多, 5-已戒
     */
    private Integer drinkingHistory;
    /**
     * 过敏史: 1-无, 2-有
     */
    private Integer allergyHistory;
    /**
     * 心率(次/分)
     */
    private Integer heartRate;
    /**
     * 血压(mmHg)
     */
    private String bloodPressure;
    /**
     * 指脉氧(%)
     */
    private Double oxygenSaturation;
    /**
     * 血糖(mmol/L)
     */
    private Double bloodGlucose;
    /**
     * 体重(kg)
     */
    private Double weight;
    /**
     * 腰围(cm)
     */
    private Double waistCircumference;
    /**
     * 体脂数(%)
     */
    private Double bodyFat;
    /**
     * 诊断
     */
    private String diagnosis;
    /**
     * 饮食治疗
     */
    private Integer dietTherapy;
    /**
     * 运动治疗
     */
    private Integer exerciseTherapy;
    /**
     * 药物治疗
     */
    private Integer medicationTherapy;
    /**
     * 综合治疗方案
     */
    private String treatmentPlan;
    /**
     * 医生ID
     */
    private Long doctorId;
    /**
     * 关联预约ID
     */
    private Long appointmentId;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 用户ID
     */
    private Long userId;

}