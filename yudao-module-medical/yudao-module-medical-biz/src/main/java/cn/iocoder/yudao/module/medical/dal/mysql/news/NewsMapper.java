package cn.iocoder.yudao.module.medical.dal.mysql.news;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.medical.controller.app.news.vo.AppNewsPageReqVO;
import cn.iocoder.yudao.module.medical.dal.dataobject.news.NewsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.medical.controller.admin.news.vo.*;

/**
 * 新闻 Mapper
 *
 * @author admin
 */
@Mapper
public interface NewsMapper extends BaseMapperX<NewsDO> {

    default PageResult<NewsDO> selectPage(NewsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NewsDO>()
                .likeIfPresent(NewsDO::getTitleZh, reqVO.getTitleZh())
                .likeIfPresent(NewsDO::getTitleEn, reqVO.getTitleEn())
                .likeIfPresent(NewsDO::getTitleRu, reqVO.getTitleRu())
                .likeIfPresent(NewsDO::getTitleKz, reqVO.getTitleKz())
                .eqIfPresent(NewsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(NewsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NewsDO::getId));
    }

    default PageResult<NewsDO> selectPage(AppNewsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NewsDO>()
                .likeIfPresent(NewsDO::getTitleZh, reqVO.getTitleZh())
                .likeIfPresent(NewsDO::getTitleEn, reqVO.getTitleEn())
                .likeIfPresent(NewsDO::getTitleRu, reqVO.getTitleRu())
                .likeIfPresent(NewsDO::getTitleKz, reqVO.getTitleKz())
                .eqIfPresent(NewsDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(NewsDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NewsDO::getId));
    }

}