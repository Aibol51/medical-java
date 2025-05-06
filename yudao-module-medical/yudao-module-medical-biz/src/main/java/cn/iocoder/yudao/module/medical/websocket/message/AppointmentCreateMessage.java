package cn.iocoder.yudao.module.medical.websocket.message;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 预约创建 WebSocket 消息
 */
@Data
@Accessors(chain = true)
public class AppointmentCreateMessage {
    
    /**
     * 预约ID
     */
    private Long appointmentId;
    
    /**
     * 患者姓名 
     */
    private String patientName;
    
    /**
     * 预约时间
     */
    private String appointmentTime;
}