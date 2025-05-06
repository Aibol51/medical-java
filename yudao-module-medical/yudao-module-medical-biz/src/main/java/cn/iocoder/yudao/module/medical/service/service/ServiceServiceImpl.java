package cn.iocoder.yudao.module.medical.service.service;

import cn.iocoder.yudao.module.medical.controller.app.service.vo.AppServicePageReqVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.service.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.service.ServiceDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.service.ServiceMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 服务 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class ServiceServiceImpl implements ServiceService {

    @Resource
    private ServiceMapper serviceMapper;

    @Override
    public Long createService(ServiceSaveReqVO createReqVO) {
        // 插入
        ServiceDO service = BeanUtils.toBean(createReqVO, ServiceDO.class);
        serviceMapper.insert(service);
        // 返回
        return service.getId();
    }

    @Override
    public void updateService(ServiceSaveReqVO updateReqVO) {
        // 校验存在
        validateServiceExists(updateReqVO.getId());
        // 更新
        ServiceDO updateObj = BeanUtils.toBean(updateReqVO, ServiceDO.class);
        serviceMapper.updateById(updateObj);
    }

    @Override
    public void deleteService(Long id) {
        // 校验存在
        validateServiceExists(id);
        // 删除
        serviceMapper.deleteById(id);
    }

    private void validateServiceExists(Long id) {
        if (serviceMapper.selectById(id) == null) {
            throw exception(SERVICE_NOT_EXISTS);
        }
    }

    @Override
    public ServiceDO getService(Long id) {
        return serviceMapper.selectById(id);
    }

    @Override
    public PageResult<ServiceDO> getServicePage(ServicePageReqVO pageReqVO) {
        return serviceMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<ServiceDO> getServicePage(AppServicePageReqVO pageReqVO) {
        return serviceMapper.selectPage(pageReqVO);
    }

}