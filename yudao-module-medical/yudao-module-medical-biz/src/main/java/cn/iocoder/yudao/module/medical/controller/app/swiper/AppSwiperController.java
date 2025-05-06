package cn.iocoder.yudao.module.medical.controller.app.swiper;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.medical.controller.app.swiper.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.swiper.SwiperDO;
import cn.iocoder.yudao.module.medical.service.swiper.SwiperService;

@Tag(name = "用户 APP - 轮播图")
@RestController
@RequestMapping("/medical/swiper")
@Validated
public class AppSwiperController {

    @Resource
    private SwiperService swiperService;

    @GetMapping("/get")
    @Operation(summary = "获得轮播图")
    @PermitAll
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppSwiperRespVO> getSwiper(@RequestParam("id") Long id) {
        SwiperDO swiper = swiperService.getSwiper(id);
        return success(BeanUtils.toBean(swiper, AppSwiperRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得轮播图分页")
    @PermitAll
    public CommonResult<PageResult<AppSwiperRespVO>> getSwiperPage(@Valid AppSwiperPageReqVO pageReqVO) {
        PageResult<SwiperDO> pageResult = swiperService.getSwiperPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppSwiperRespVO.class));
    }

}