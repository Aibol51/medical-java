package cn.iocoder.yudao.module.medical.controller.admin.news.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 新闻分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NewsPageReqVO extends PageParam {

    @Schema(description = "中文标题", example = "qwe")
    private String titleZh;

    @Schema(description = "英文标题", example = "qwe")
    private String titleEn;

    @Schema(description = "俄文标题", example = "qwe")
    private String titleRu;

    @Schema(description = "哈萨克文标题", example = "qwe")
    private String titleKz;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}