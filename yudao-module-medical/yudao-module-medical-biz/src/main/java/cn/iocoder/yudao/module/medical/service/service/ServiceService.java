package cn.iocoder.yudao.module.medical.service.service;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.app.service.vo.AppServicePageReqVO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.service.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.service.ServiceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 服务 Service 接口
 *
 * @author admin
 */
public interface ServiceService {

    /**
     * 创建服务
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createService(@Valid ServiceSaveReqVO createReqVO);

    /**
     * 更新服务
     *
     * @param updateReqVO 更新信息
     */
    void updateService(@Valid ServiceSaveReqVO updateReqVO);

    /**
     * 删除服务
     *
     * @param id 编号
     */
    void deleteService(Long id);

    /**
     * 获得服务
     *
     * @param id 编号
     * @return 服务
     */
    ServiceDO getService(Long id);

    /**
     * 获得服务分页
     *
     * @param pageReqVO 分页查询
     * @return 服务分页
     */
    PageResult<ServiceDO> getServicePage(ServicePageReqVO pageReqVO);

    /**
     * 获得服务分页
     *
     * @param pageReqVO 分页查询
     * @return 服务分页
     */
    PageResult<ServiceDO> getServicePage(AppServicePageReqVO pageReqVO);
}