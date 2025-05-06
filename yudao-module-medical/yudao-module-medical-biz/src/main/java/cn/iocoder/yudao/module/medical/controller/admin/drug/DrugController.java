package cn.iocoder.yudao.module.medical.controller.admin.drug;

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

import cn.iocoder.yudao.module.medical.controller.admin.drug.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.drug.DrugDO;
import cn.iocoder.yudao.module.medical.service.drug.DrugService;

@Tag(name = "管理后台 - 药品")
@RestController
@RequestMapping("/medical/drug")
@Validated
public class DrugController {

    @Resource
    private DrugService drugService;

    @PostMapping("/create")
    @Operation(summary = "创建药品")
    @PreAuthorize("@ss.hasPermission('medical:drug:create')")
    public CommonResult<Long> createDrug(@Valid @RequestBody DrugSaveReqVO createReqVO) {
        return success(drugService.createDrug(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新药品")
    @PreAuthorize("@ss.hasPermission('medical:drug:update')")
    public CommonResult<Boolean> updateDrug(@Valid @RequestBody DrugSaveReqVO updateReqVO) {
        drugService.updateDrug(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除药品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:drug:delete')")
    public CommonResult<Boolean> deleteDrug(@RequestParam("id") Long id) {
        drugService.deleteDrug(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得药品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:drug:query')")
    public CommonResult<DrugRespVO> getDrug(@RequestParam("id") Long id) {
        DrugDO drug = drugService.getDrug(id);
        return success(BeanUtils.toBean(drug, DrugRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得药品分页")
    @PreAuthorize("@ss.hasPermission('medical:drug:query')")
    public CommonResult<PageResult<DrugRespVO>> getDrugPage(@Valid DrugPageReqVO pageReqVO) {
        PageResult<DrugDO> pageResult = drugService.getDrugPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, DrugRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出药品 Excel")
    @PreAuthorize("@ss.hasPermission('medical:drug:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDrugExcel(@Valid DrugPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<DrugDO> list = drugService.getDrugPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "药品.xls", "数据", DrugRespVO.class,
                        BeanUtils.toBean(list, DrugRespVO.class));
    }

}