package cn.iocoder.yudao.module.medical.controller.admin.swiper;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
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

import cn.iocoder.yudao.module.medical.controller.admin.swiper.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.swiper.SwiperDO;
import cn.iocoder.yudao.module.medical.service.swiper.SwiperService;

@Tag(name = "管理后台 - 轮播图")
@RestController
@RequestMapping("/medical/swiper")
@Validated
public class SwiperController {

    @Resource
    private SwiperService swiperService;

    @PostMapping("/create")
    @Operation(summary = "创建轮播图")
    @PreAuthorize("@ss.hasPermission('medical:swiper:create')")
    public CommonResult<Long> createSwiper(@Valid @RequestBody SwiperSaveReqVO createReqVO) {
        return success(swiperService.createSwiper(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新轮播图")
    @PreAuthorize("@ss.hasPermission('medical:swiper:update')")
    public CommonResult<Boolean> updateSwiper(@Valid @RequestBody SwiperSaveReqVO updateReqVO) {
        swiperService.updateSwiper(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除轮播图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:swiper:delete')")
    public CommonResult<Boolean> deleteSwiper(@RequestParam("id") Long id) {
        swiperService.deleteSwiper(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得轮播图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:swiper:query')")
    public CommonResult<SwiperRespVO> getSwiper(@RequestParam("id") Long id) {
        SwiperDO swiper = swiperService.getSwiper(id);
        return success(BeanUtils.toBean(swiper, SwiperRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得轮播图分页")
    @PreAuthorize("@ss.hasPermission('medical:swiper:query')")
    public CommonResult<PageResult<SwiperRespVO>> getSwiperPage(@Valid SwiperPageReqVO pageReqVO) {
        PageResult<SwiperDO> pageResult = swiperService.getSwiperPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SwiperRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出轮播图 Excel")
    @PreAuthorize("@ss.hasPermission('medical:swiper:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSwiperExcel(@Valid SwiperPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SwiperDO> list = swiperService.getSwiperPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "轮播图.xls", "数据", SwiperRespVO.class,
                        BeanUtils.toBean(list, SwiperRespVO.class));
    }

}