package cn.iocoder.yudao.module.medical.controller.app.expert;

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

import cn.iocoder.yudao.module.medical.controller.app.expert.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.expert.ExpertDO;
import cn.iocoder.yudao.module.medical.service.expert.ExpertService;

@Tag(name = "用户 APP - 专家")
@RestController
@RequestMapping("/medical/expert")
@Validated
public class AppExpertController {

    @Resource
    private ExpertService expertService;

    @GetMapping("/get")
    @Operation(summary = "获得专家")
    @PermitAll
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppExpertRespVO> getExpert(@RequestParam("id") Long id) {
        ExpertDO expert = expertService.getExpert(id);
        return success(BeanUtils.toBean(expert, AppExpertRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得专家分页")
    @PermitAll
    public CommonResult<PageResult<AppExpertRespVO>> getExpertPage(@Valid AppExpertPageReqVO pageReqVO) {
        PageResult<ExpertDO> pageResult = expertService.getExpertPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppExpertRespVO.class));
    }


}