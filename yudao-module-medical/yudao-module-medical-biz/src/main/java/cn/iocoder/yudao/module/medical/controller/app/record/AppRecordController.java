package cn.iocoder.yudao.module.medical.controller.app.record;

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

import cn.iocoder.yudao.module.medical.controller.app.record.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.record.RecordDO;
import cn.iocoder.yudao.module.medical.service.record.MedicalRecordService;

@Tag(name = "用户 APP - 健康记录")
@RestController
@RequestMapping("/medical/record")
@Validated
public class AppRecordController {

    @Resource
    private MedicalRecordService medicalRecordService;

    @GetMapping("/get")
    @Operation(summary = "获得健康记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppRecordRespVO> getRecord(@RequestParam("id") Long id) {
        RecordDO record = medicalRecordService.getRecord(id);
        return success(BeanUtils.toBean(record, AppRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得健康记录分页")
    public CommonResult<PageResult<AppRecordRespVO>> getRecordPage(@Valid AppRecordPageReqVO pageReqVO) {
        PageResult<RecordDO> pageResult = medicalRecordService.getRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppRecordRespVO.class));
    }

}