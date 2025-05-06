package cn.iocoder.yudao.module.medical.dal.mysql.drug;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.drug.vo.AppDrugPageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.drug.DrugDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.drug.vo.*;

/**
 * 药品 Mapper
 *
 * @author admin
 */
@Mapper
public interface DrugMapper extends BaseMapperX<DrugDO> {

    default PageResult<DrugDO> selectPage(DrugPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DrugDO>()
                .likeIfPresent(DrugDO::getNameZh, reqVO.getNameZh())
                .likeIfPresent(DrugDO::getNameEn, reqVO.getNameEn())
                .likeIfPresent(DrugDO::getNameRu, reqVO.getNameRu())
                .likeIfPresent(DrugDO::getNameKz, reqVO.getNameKz())
                .eqIfPresent(DrugDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DrugDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DrugDO::getId));
    }

    default PageResult<DrugDO> selectPage(AppDrugPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DrugDO>()
                .likeIfPresent(DrugDO::getNameZh, reqVO.getNameZh())
                .likeIfPresent(DrugDO::getNameEn, reqVO.getNameEn())
                .likeIfPresent(DrugDO::getNameRu, reqVO.getNameRu())
                .likeIfPresent(DrugDO::getNameKz, reqVO.getNameKz())
                .eqIfPresent(DrugDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(DrugDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DrugDO::getId));
    }

}