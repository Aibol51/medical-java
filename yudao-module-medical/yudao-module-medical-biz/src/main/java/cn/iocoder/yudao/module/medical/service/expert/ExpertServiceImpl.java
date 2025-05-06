package cn.iocoder.yudao.module.medical.service.expert;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.UserPostDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.app.expert.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.expert.ExpertDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.expert.ExpertMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 专家 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ExpertServiceImpl implements ExpertService {

    @Resource
    private ExpertMapper expertMapper;


    @Override
    public ExpertDO getExpert(Long id) {
        return expertMapper.selectOne(new LambdaQueryWrapperX<ExpertDO>()
                .eq(ExpertDO::getId, id)
                .like(ExpertDO::getPostIds, "5")); // 限制只查询 postIds 包含 5 的记录
    }

    @Override
    public PageResult<ExpertDO> getExpertPage(AppExpertPageReqVO pageReqVO) {
        // 构建查询条件
        return expertMapper.selectPage(pageReqVO, new LambdaQueryWrapperX<ExpertDO>()
                .likeIfPresent(ExpertDO::getNickname, pageReqVO.getNickname())
                .like(ExpertDO::getPostIds, "5") // 查询 postIds 包含 5 的记录
                .orderByDesc(ExpertDO::getId));
    }

    @Override
    public List<ExpertDO> getUserListByPostIds(Collection<Long> postIds) {
        // 如果没有指定岗位编号，则返回空列表
        if (CollUtil.isEmpty(postIds)) {
            return Collections.emptyList();
        }
        
        // 构建查询条件
        LambdaQueryWrapperX<ExpertDO> queryWrapper = new LambdaQueryWrapperX<ExpertDO>()
                .in(ExpertDO::getPostIds, postIds)
                .eq(ExpertDO::getStatus, CommonStatusEnum.ENABLE.getStatus()); // 只查询启用的用户
                
        // 执行查询
        return expertMapper.selectList(queryWrapper);
    }

}