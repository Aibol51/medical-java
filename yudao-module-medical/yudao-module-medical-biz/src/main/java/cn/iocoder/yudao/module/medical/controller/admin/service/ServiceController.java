package cn.iocoder.yudao.module.medical.controller.admin.service;

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

import cn.iocoder.yudao.module.medical.controller.admin.service.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.service.ServiceDO;
import cn.iocoder.yudao.module.medical.service.service.ServiceService;

@Tag(name = "管理后台 - 服务")
@RestController
@RequestMapping("/medical/service")
@Validated
public class ServiceController {

    @Resource
    private ServiceService serviceService;

    @PostMapping("/create")
    @Operation(summary = "创建服务")
    @PreAuthorize("@ss.hasPermission('medical:service:create')")
    public CommonResult<Long> createService(@Valid @RequestBody ServiceSaveReqVO createReqVO) {
        return success(serviceService.createService(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新服务")
    @PreAuthorize("@ss.hasPermission('medical:service:update')")
    public CommonResult<Boolean> updateService(@Valid @RequestBody ServiceSaveReqVO updateReqVO) {
        serviceService.updateService(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除服务")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:service:delete')")
    public CommonResult<Boolean> deleteService(@RequestParam("id") Long id) {
        serviceService.deleteService(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得服务")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:service:query')")
    public CommonResult<ServiceRespVO> getService(@RequestParam("id") Long id) {
        ServiceDO service = serviceService.getService(id);
        return success(BeanUtils.toBean(service, ServiceRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得服务分页")
    @PreAuthorize("@ss.hasPermission('medical:service:query')")
    public CommonResult<PageResult<ServiceRespVO>> getServicePage(@Valid ServicePageReqVO pageReqVO) {
        PageResult<ServiceDO> pageResult = serviceService.getServicePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ServiceRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出服务 Excel")
    @PreAuthorize("@ss.hasPermission('medical:service:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportServiceExcel(@Valid ServicePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ServiceDO> list = serviceService.getServicePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "服务.xls", "数据", ServiceRespVO.class,
                        BeanUtils.toBean(list, ServiceRespVO.class));
    }

}