package cn.iocoder.yudao.module.medical.service.swiper;

import cn.iocoder.yudao.module.medical.controller.app.swiper.vo.AppSwiperPageReqVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.swiper.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.swiper.SwiperDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.swiper.SwiperMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 轮播图 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class SwiperServiceImpl implements SwiperService {

    @Resource
    private SwiperMapper swiperMapper;

    @Override
    public Long createSwiper(SwiperSaveReqVO createReqVO) {
        // 插入
        SwiperDO swiper = BeanUtils.toBean(createReqVO, SwiperDO.class);
        swiperMapper.insert(swiper);
        // 返回
        return swiper.getId();
    }

    @Override
    public void updateSwiper(SwiperSaveReqVO updateReqVO) {
        // 校验存在
        validateSwiperExists(updateReqVO.getId());
        // 更新
        SwiperDO updateObj = BeanUtils.toBean(updateReqVO, SwiperDO.class);
        swiperMapper.updateById(updateObj);
    }

    @Override
    public void deleteSwiper(Long id) {
        // 校验存在
        validateSwiperExists(id);
        // 删除
        swiperMapper.deleteById(id);
    }

    private void validateSwiperExists(Long id) {
        if (swiperMapper.selectById(id) == null) {
            throw exception(SWIPER_NOT_EXISTS);
        }
    }

    @Override
    public SwiperDO getSwiper(Long id) {
        return swiperMapper.selectById(id);
    }

    @Override
    public PageResult<SwiperDO> getSwiperPage(SwiperPageReqVO pageReqVO) {
        return swiperMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<SwiperDO> getSwiperPage(AppSwiperPageReqVO pageReqVO) {
        return swiperMapper.selectPage(pageReqVO);
    }

}