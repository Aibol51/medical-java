package cn.iocoder.yudao.module.medical.service.appointment;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.websocket.core.sender.WebSocketMessageSender;
import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.AppAppointmentPageReqVO;
import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.AppAppointmentSaveReqVO;
import cn.iocoder.yudao.module.medical.websocket.message.AppointmentCreateMessage;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.appointment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.appointment.AppointmentMapper;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;
import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 预约 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    @Resource
    private WebSocketMessageSender webSocketMessageSender;

    @Override
    public Long createAppointment(AppointmentSaveReqVO createReqVO) {
        // 插入
        AppointmentDO appointment = BeanUtils.toBean(createReqVO, AppointmentDO.class);
        appointmentMapper.insert(appointment);
        // 返回
        return appointment.getId();
    }

    @Override
    public Long createAppointment(AppAppointmentSaveReqVO createReqVO) {
        // 插入
        AppointmentDO appointment = BeanUtils.toBean(createReqVO, AppointmentDO.class);
        appointment.setUserId(getLoginUserId());
        appointmentMapper.insert(appointment);

        // 发送 WebSocket 消息给所有管理员
        AppointmentCreateMessage message = new AppointmentCreateMessage()
                .setAppointmentId(appointment.getId())
                .setPatientName(appointment.getPatientName())
                .setAppointmentTime(appointment.getAppointmentTime().toString());
        webSocketMessageSender.sendObject(UserTypeEnum.ADMIN.getValue(), "appointment-create", message);// 发送 WebSocket 消息给所有管理员

        // 返回
        return appointment.getId();
    }

    @Override
    public void updateAppointment(AppointmentSaveReqVO updateReqVO) {
        // 校验存在
        validateAppointmentExists(updateReqVO.getId());
        // 更新
        AppointmentDO updateObj = BeanUtils.toBean(updateReqVO, AppointmentDO.class);
        appointmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteAppointment(Long id) {
        // 校验存在
        validateAppointmentExists(id);
        // 删除
        appointmentMapper.deleteById(id);
    }

    private void validateAppointmentExists(Long id) {
        if (appointmentMapper.selectById(id) == null) {
            throw exception(APPOINTMENT_NOT_EXISTS);
        }
    }

    @Override
    public AppointmentDO getAppointment(Long id) {
        return appointmentMapper.selectById(id);
    }

    @Override
    public PageResult<AppointmentDO> getAppointmentPage(AppointmentPageReqVO pageReqVO) {
        return appointmentMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<AppointmentDO> getAppointmentPage(AppAppointmentPageReqVO pageReqVO) {
        pageReqVO.setUserId(getLoginUserId());
        return appointmentMapper.selectPage(pageReqVO);
    }

}