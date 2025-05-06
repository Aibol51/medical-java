package cn.iocoder.yudao.module.medical.controller.app.news;

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

import cn.iocoder.yudao.module.medical.controller.app.news.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.module.medical.service.news.NewsService;

@Tag(name = "用户 APP - 新闻")
@RestController
@RequestMapping("/medical/news")
@Validated
public class AppNewsController {

    @Resource
    private NewsService newsService;

    @GetMapping("/get")
    @Operation(summary = "获得新闻")
    @PermitAll
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppNewsRespVO> getNews(@RequestParam("id") Long id) {
        NewsDO news = newsService.getNews(id);
        return success(BeanUtils.toBean(news, AppNewsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得新闻分页")
    @PermitAll
    public CommonResult<PageResult<AppNewsPageRespVO>> getNewsPage(@Valid AppNewsPageReqVO pageReqVO) {
        PageResult<NewsDO> pageResult = newsService.getNewsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppNewsPageRespVO.class));
    }

}