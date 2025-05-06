package cn.iocoder.yudao.module.medical.controller.app.service.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "用户 APP - 服务分页 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppServicePageRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17135")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "中文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("中文名称")
    private String nameZh;

    @Schema(description = "英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("英文名称")
    private String nameEn;

    @Schema(description = "俄文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("俄文名称")
    private String nameRu;

    @Schema(description = "哈萨克文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @ExcelProperty("哈萨克文名称")
    private String nameKz;

    @Schema(description = "封面图", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("封面图")
    private String coverPath;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}