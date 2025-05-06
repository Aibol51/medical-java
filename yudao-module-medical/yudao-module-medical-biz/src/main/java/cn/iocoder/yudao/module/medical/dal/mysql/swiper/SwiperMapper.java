package cn.iocoder.yudao.module.medical.dal.mysql.swiper;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.swiper.vo.AppSwiperPageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.swiper.SwiperDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.swiper.vo.*;

/**
 * 轮播图 Mapper
 *
 * @author admin
 */
@Mapper
public interface SwiperMapper extends BaseMapperX<SwiperDO> {

    default PageResult<SwiperDO> selectPage(SwiperPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SwiperDO>()
                .eqIfPresent(SwiperDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SwiperDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SwiperDO::getId));
    }

    default PageResult<SwiperDO> selectPage(AppSwiperPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SwiperDO>()
                .eqIfPresent(SwiperDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SwiperDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SwiperDO::getId));
    }

}