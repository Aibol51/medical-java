package cn.iocoder.yudao.module.medical.controller.app.news.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "用户 APP - 新闻新增/修改 Request VO")
@Data
public class AppNewsSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "25843")
    private Long id;

    @Schema(description = "中文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "中文标题不能为空")
    private String titleZh;

    @Schema(description = "英文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "英文标题不能为空")
    private String titleEn;

    @Schema(description = "俄文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "俄文标题不能为空")
    private String titleRu;

    @Schema(description = "哈萨克文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "哈萨克文标题不能为空")
    private String titleKz;

    @Schema(description = "中文内容", example = "qwe")
    private String contentZh;

    @Schema(description = "英文内容", example = "qwe")
    private String contentEn;

    @Schema(description = "俄文内容", example = "qwe")
    private String contentRu;

    @Schema(description = "哈萨克文内容", example = "qwe")
    private String contentKz;

    @Schema(description = "封面图", example = "http://xxx.com/xxx.xxx")
    private String coverPath;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}