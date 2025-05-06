package cn.iocoder.yudao.module.medical.controller.admin.record;

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

import cn.iocoder.yudao.module.medical.controller.admin.record.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.record.RecordDO;
import cn.iocoder.yudao.module.medical.service.record.MedicalRecordService;

@Tag(name = "管理后台 - 健康记录")
@RestController
@RequestMapping("/medical/record")
@Validated
public class RecordController {

    @Resource
    private MedicalRecordService medicalRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建健康记录")
    @PreAuthorize("@ss.hasPermission('medical:record:create')")
    public CommonResult<Long> createRecord(@Valid @RequestBody RecordSaveReqVO createReqVO) {
        return success(medicalRecordService.createRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新健康记录")
    @PreAuthorize("@ss.hasPermission('medical:record:update')")
    public CommonResult<Boolean> updateRecord(@Valid @RequestBody RecordSaveReqVO updateReqVO) {
        medicalRecordService.updateRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除健康记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:record:delete')")
    public CommonResult<Boolean> deleteRecord(@RequestParam("id") Long id) {
        medicalRecordService.deleteRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得健康记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:record:query')")
    public CommonResult<RecordRespVO> getRecord(@RequestParam("id") Long id) {
        RecordDO record = medicalRecordService.getRecord(id);
        return success(BeanUtils.toBean(record, RecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康记录分页")
    @PreAuthorize("@ss.hasPermission('medical:record:query')")
    public CommonResult<PageResult<RecordRespVO>> getRecordPage(@Valid RecordPageReqVO pageReqVO) {
        PageResult<RecordDO> pageResult = medicalRecordService.getRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, RecordRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出健康记录 Excel")
    @PreAuthorize("@ss.hasPermission('medical:record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRecordExcel(@Valid RecordPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<RecordDO> list = medicalRecordService.getRecordPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "健康记录.xls", "数据", RecordRespVO.class,
                        BeanUtils.toBean(list, RecordRespVO.class));
    }

}