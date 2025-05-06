package cn.iocoder.yudao.module.medical.service.appointment;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.AppAppointmentPageReqVO;
import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.AppAppointmentSaveReqVO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.appointment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 预约 Service 接口
 *
 * @author admin
 */
public interface AppointmentService {

    /**
     * 创建预约
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAppointment(@Valid AppointmentSaveReqVO createReqVO);

    /**
     * 创建预约
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAppointment(@Valid AppAppointmentSaveReqVO createReqVO);

    /**
     * 更新预约
     *
     * @param updateReqVO 更新信息
     */
    void updateAppointment(@Valid AppointmentSaveReqVO updateReqVO);

    /**
     * 删除预约
     *
     * @param id 编号
     */
    void deleteAppointment(Long id);

    /**
     * 获得预约
     *
     * @param id 编号
     * @return 预约
     */
    AppointmentDO getAppointment(Long id);

    /**
     * 获得预约分页
     *
     * @param pageReqVO 分页查询
     * @return 预约分页
     */
    PageResult<AppointmentDO> getAppointmentPage(AppointmentPageReqVO pageReqVO);

    /**
     * 获得预约分页
     *
     * @param pageReqVO 分页查询
     * @return 预约分页
     */
    PageResult<AppointmentDO> getAppointmentPage(AppAppointmentPageReqVO pageReqVO);

}