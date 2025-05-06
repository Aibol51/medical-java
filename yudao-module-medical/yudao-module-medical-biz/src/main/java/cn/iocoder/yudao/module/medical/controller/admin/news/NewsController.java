package cn.iocoder.yudao.module.medical.controller.admin.news;

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

import cn.iocoder.yudao.module.medical.controller.admin.news.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.module.medical.service.news.NewsService;

@Tag(name = "管理后台 - 新闻")
@RestController
@RequestMapping("/medical/news")
@Validated
public class NewsController {

    @Resource
    private NewsService newsService;

    @PostMapping("/create")
    @Operation(summary = "创建新闻")
    @PreAuthorize("@ss.hasPermission('medical:news:create')")
    public CommonResult<Long> createNews(@Valid @RequestBody NewsSaveReqVO createReqVO) {
        return success(newsService.createNews(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新新闻")
    @PreAuthorize("@ss.hasPermission('medical:news:update')")
    public CommonResult<Boolean> updateNews(@Valid @RequestBody NewsSaveReqVO updateReqVO) {
        newsService.updateNews(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除新闻")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('medical:news:delete')")
    public CommonResult<Boolean> deleteNews(@RequestParam("id") Long id) {
        newsService.deleteNews(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得新闻")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('medical:news:query')")
    public CommonResult<NewsRespVO> getNews(@RequestParam("id") Long id) {
        NewsDO news = newsService.getNews(id);
        return success(BeanUtils.toBean(news, NewsRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得新闻分页")
    @PreAuthorize("@ss.hasPermission('medical:news:query')")
    public CommonResult<PageResult<NewsRespVO>> getNewsPage(@Valid NewsPageReqVO pageReqVO) {
        PageResult<NewsDO> pageResult = newsService.getNewsPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, NewsRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出新闻 Excel")
    @PreAuthorize("@ss.hasPermission('medical:news:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportNewsExcel(@Valid NewsPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<NewsDO> list = newsService.getNewsPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "新闻.xls", "数据", NewsRespVO.class,
                        BeanUtils.toBean(list, NewsRespVO.class));
    }

}