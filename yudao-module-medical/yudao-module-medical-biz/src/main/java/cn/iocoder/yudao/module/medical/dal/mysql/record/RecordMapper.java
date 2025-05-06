package cn.iocoder.yudao.module.medical.dal.mysql.record;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.record.vo.AppRecordPageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.record.RecordDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.record.vo.*;

/**
 * 健康记录 Mapper
 *
 * @author admin
 */
@Mapper
public interface RecordMapper extends BaseMapperX<RecordDO> {

    default PageResult<RecordDO> selectPage(RecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RecordDO>()
                .likeIfPresent(RecordDO::getPatientName, reqVO.getPatientName())
                .likeIfPresent(RecordDO::getPatientPhone, reqVO.getPatientPhone())
                .eqIfPresent(RecordDO::getDoctorId, reqVO.getDoctorId())
                .eqIfPresent(RecordDO::getUserId, reqVO.getUserId())
                .betweenIfPresent(RecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RecordDO::getId));
    }

    default PageResult<RecordDO> selectPage(AppRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RecordDO>()
                .likeIfPresent(RecordDO::getPatientName, reqVO.getPatientName())
                .likeIfPresent(RecordDO::getPatientPhone, reqVO.getPatientPhone())
                .eqIfPresent(RecordDO::getDoctorId, reqVO.getDoctorId())
                .eqIfPresent(RecordDO::getUserId, reqVO.getUserId())
                .betweenIfPresent(RecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RecordDO::getId));
    }

}