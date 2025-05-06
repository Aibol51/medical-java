package cn.iocoder.yudao.module.medical.service.swiper;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.app.swiper.vo.AppSwiperPageReqVO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.swiper.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.swiper.SwiperDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 轮播图 Service 接口
 *
 * @author admin
 */
public interface SwiperService {

    /**
     * 创建轮播图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSwiper(@Valid SwiperSaveReqVO createReqVO);

    /**
     * 更新轮播图
     *
     * @param updateReqVO 更新信息
     */
    void updateSwiper(@Valid SwiperSaveReqVO updateReqVO);

    /**
     * 删除轮播图
     *
     * @param id 编号
     */
    void deleteSwiper(Long id);

    /**
     * 获得轮播图
     *
     * @param id 编号
     * @return 轮播图
     */
    SwiperDO getSwiper(Long id);

    /**
     * 获得轮播图分页
     *
     * @param pageReqVO 分页查询
     * @return 轮播图分页
     */
    PageResult<SwiperDO> getSwiperPage(SwiperPageReqVO pageReqVO);

    /**
     * 获得轮播图分页
     *
     * @param pageReqVO 分页查询
     * @return 轮播图分页
     */
    PageResult<SwiperDO> getSwiperPage(AppSwiperPageReqVO pageReqVO);

}