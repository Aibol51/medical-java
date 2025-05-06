package cn.iocoder.yudao.module.medical.controller.admin.drug.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 药品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class DrugRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "16922")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "中文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @ExcelProperty("中文名称")
    private String nameZh;

    @Schema(description = "英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @ExcelProperty("英文名称")
    private String nameEn;

    @Schema(description = "俄语名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @ExcelProperty("俄语名称")
    private String nameRu;

    @Schema(description = "哈萨克语名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @ExcelProperty("哈萨克语名称")
    private String nameKz;

    @Schema(description = "图片路径", example = "https://xxx.com/xxx.xxx")
    @ExcelProperty("图片路径")
    private String imagePath;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED,example = "10")
    @ExcelProperty("库存数量")
    private Integer quantity;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}