package cn.iocoder.yudao.module.medical.controller.app.service;

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

import cn.iocoder.yudao.module.medical.controller.app.service.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.service.ServiceDO;
import cn.iocoder.yudao.module.medical.service.service.ServiceService;

@Tag(name = "用户 APP - 服务")
@RestController
@RequestMapping("/medical/service")
@Validated
public class AppServiceController {

    @Resource
    private ServiceService serviceService;

    @GetMapping("/get")
    @Operation(summary = "获得服务")
    @PermitAll
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppServiceRespVO> getService(@RequestParam("id") Long id) {
        ServiceDO service = serviceService.getService(id);
        return success(BeanUtils.toBean(service, AppServiceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得服务分页")
    @PermitAll
    public CommonResult<PageResult<AppServicePageRespVO>> getServicePage(@Valid AppServicePageReqVO pageReqVO) {
        PageResult<ServiceDO> pageResult = serviceService.getServicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppServicePageRespVO.class));
    }

}