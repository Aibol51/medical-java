package cn.iocoder.yudao.module.medical.service.expert;

import java.util.*;

import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.app.expert.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.expert.ExpertDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 专家 Service 接口
 *
 * @author admin
 */
public interface ExpertService {

    /**
     * 获得专家
     *
     * @param id 编号
     * @return 专家
     */
    ExpertDO getExpert(Long id);

    /**
     * 获得专家分页
     *
     * @param pageReqVO 分页查询
     * @return 专家分页
     */
    PageResult<ExpertDO> getExpertPage(AppExpertPageReqVO pageReqVO);

    /**
     * 获得指定岗位的用户数组
     *
     * @param postIds 岗位数组
     * @return 用户数组
     */
    List<ExpertDO> getUserListByPostIds(Collection<Long> postIds);

}