package cn.iocoder.yudao.module.medical.controller.app.appointment;

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

import cn.iocoder.yudao.module.medical.controller.app.appointment.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.module.medical.service.appointment.AppointmentService;

@Tag(name = "用户 APP - 预约")
@RestController
@RequestMapping("/medical/appointment")
@Validated
public class AppAppointmentController {

    @Resource
    private AppointmentService appointmentService;

    @PostMapping("/create")
    @Operation(summary = "创建预约")
    @PermitAll
    public CommonResult<Long> createAppointment(@Valid @RequestBody AppAppointmentSaveReqVO createReqVO) {
        return success(appointmentService.createAppointment(createReqVO));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除预约")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> deleteAppointment(@RequestParam("id") Long id) {
        appointmentService.deleteAppointment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得预约")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppAppointmentRespVO> getAppointment(@RequestParam("id") Long id) {
        AppointmentDO appointment = appointmentService.getAppointment(id);
        return success(BeanUtils.toBean(appointment, AppAppointmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得预约分页")
    public CommonResult<PageResult<AppAppointmentRespVO>> getAppointmentPage(@Valid AppAppointmentPageReqVO pageReqVO) {
        PageResult<AppointmentDO> pageResult = appointmentService.getAppointmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppAppointmentRespVO.class));
    }

}