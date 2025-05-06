package cn.iocoder.yudao.module.medical.dal.dataobject.appointment;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 预约 DO
 *
 * @author admin
 */
@TableName("medical_appointment")
@KeySequence("medical_appointment_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDO extends BaseDO {

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
     * 预约时间
     */
    private LocalDateTime appointmentTime;
    /**
     * 症状描述
     */
    private String symptom;
    /**
     * 预约状态 1:待确认 2:已确认 3:已完成 4:已过期
     */
    private Integer status;
    /**
     * 预约用户ID
     */
    private Long userId;
    /**
     * 主治医生ID
     */
    private Long doctorId;

}