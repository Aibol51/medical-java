package cn.iocoder.yudao.module.medical.dal.mysql.appointment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.AppAppointmentPageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.appointment.AppointmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.appointment.vo.*;

/**
 * 预约 Mapper
 *
 * @author admin
 */
@Mapper
public interface AppointmentMapper extends BaseMapperX<AppointmentDO> {

    default PageResult<AppointmentDO> selectPage(AppointmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AppointmentDO>()
                .likeIfPresent(AppointmentDO::getPatientName, reqVO.getPatientName())
                .eqIfPresent(AppointmentDO::getPatientPhone, reqVO.getPatientPhone())
                .betweenIfPresent(AppointmentDO::getAppointmentTime, reqVO.getAppointmentTime())
                .eqIfPresent(AppointmentDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AppointmentDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AppointmentDO::getDoctorId, reqVO.getDoctorId())
                .betweenIfPresent(AppointmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AppointmentDO::getId));
    }

    default PageResult<AppointmentDO> selectPage(AppAppointmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AppointmentDO>()
                .betweenIfPresent(AppointmentDO::getAppointmentTime, reqVO.getAppointmentTime())
                .eqIfPresent(AppointmentDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AppointmentDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AppointmentDO::getDoctorId, reqVO.getDoctorId())
                .betweenIfPresent(AppointmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AppointmentDO::getId));
    }

}