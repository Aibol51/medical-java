package cn.iocoder.yudao.module.medical.dal.mysql.expert;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.dal.dataobject.expert.ExpertDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.app.expert.vo.*;

/**
 * 专家 Mapper
 *
 * @author admin
 */
@Mapper
public interface ExpertMapper extends BaseMapperX<ExpertDO> {

    default PageResult<ExpertDO> selectPage(AppExpertPageReqVO reqVO, LambdaQueryWrapperX<ExpertDO> queryWrapper) {
        return selectPage(reqVO, null, queryWrapper);
    }

}