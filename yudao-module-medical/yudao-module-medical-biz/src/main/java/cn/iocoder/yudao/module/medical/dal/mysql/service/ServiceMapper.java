package cn.iocoder.yudao.module.medical.dal.mysql.service;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.service.vo.AppServicePageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.service.ServiceDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.service.vo.*;

/**
 * 服务 Mapper
 *
 * @author admin
 */
@Mapper
public interface ServiceMapper extends BaseMapperX<ServiceDO> {

    default PageResult<ServiceDO> selectPage(ServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServiceDO>()
                .likeIfPresent(ServiceDO::getNameZh, reqVO.getNameZh())
                .likeIfPresent(ServiceDO::getNameEn, reqVO.getNameEn())
                .likeIfPresent(ServiceDO::getNameRu, reqVO.getNameRu())
                .likeIfPresent(ServiceDO::getNameKz, reqVO.getNameKz())
                .eqIfPresent(ServiceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ServiceDO::getId));
    }

    default PageResult<ServiceDO> selectPage(AppServicePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ServiceDO>()
                .likeIfPresent(ServiceDO::getNameZh, reqVO.getNameZh())
                .likeIfPresent(ServiceDO::getNameEn, reqVO.getNameEn())
                .likeIfPresent(ServiceDO::getNameRu, reqVO.getNameRu())
                .likeIfPresent(ServiceDO::getNameKz, reqVO.getNameKz())
                .eqIfPresent(ServiceDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ServiceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ServiceDO::getId));
    }

}