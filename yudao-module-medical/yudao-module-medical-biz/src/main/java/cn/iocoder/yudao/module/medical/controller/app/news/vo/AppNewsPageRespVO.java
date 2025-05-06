package cn.iocoder.yudao.module.medical.controller.app.news.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
@Schema(description = "用户 APP - 新闻分页 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppNewsPageRespVO {
    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "25843")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "中文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("中文标题")
    private String titleZh;

    @Schema(description = "英文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("英文标题")
    private String titleEn;

    @Schema(description = "俄文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("俄文标题")
    private String titleRu;

    @Schema(description = "哈萨克文标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("哈萨克文标题")
    private String titleKz;

    @Schema(description = "封面图", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("封面图")
    private String coverPath;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
