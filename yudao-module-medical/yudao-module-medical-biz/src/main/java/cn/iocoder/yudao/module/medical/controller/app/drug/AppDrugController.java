package cn.iocoder.yudao.module.medical.controller.app.drug;

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

import cn.iocoder.yudao.module.medical.controller.app.drug.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.drug.DrugDO;
import cn.iocoder.yudao.module.medical.service.drug.DrugService;

@Tag(name = "用户 APP - 药品")
@RestController
@RequestMapping("/medical/drug")
@Validated
public class AppDrugController {

    @Resource
    private DrugService drugService;

    @GetMapping("/get")
    @Operation(summary = "获得药品")
    @PermitAll
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppDrugRespVO> getDrug(@RequestParam("id") Long id) {
        DrugDO drug = drugService.getDrug(id);
        return success(BeanUtils.toBean(drug, AppDrugRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得药品分页")
    @PermitAll
    public CommonResult<PageResult<AppDrugPageRespVO>> getDrugPage(@Valid AppDrugPageReqVO pageReqVO) {
        PageResult<DrugDO> pageResult = drugService.getDrugPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppDrugPageRespVO.class));
//        return success(PageResult.empty(pageResult.getTotal()));
    }
}