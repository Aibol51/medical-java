package cn.iocoder.yudao.module.medical.controller.app.drug.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "用户 APP - 药品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppDrugRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24625")
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

    @Schema(description = "中文描述", example = "yaopin")
    @ExcelProperty("中文描述")
    private String descriptionZh;

    @Schema(description = "英文描述", example = "yaopin")
    @ExcelProperty("英文描述")
    private String descriptionEn;

    @Schema(description = "俄语描述", example = "yaopin")
    @ExcelProperty("俄语描述")
    private String descriptionRu;

    @Schema(description = "哈萨克语描述", example = "yaopin")
    @ExcelProperty("哈萨克语描述")
    private String descriptionKz;

    @Schema(description = "图片路径", example = "https://xxx.com/xxx.xxx")
    @ExcelProperty("图片路径")
    private String imagePath;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("库存数量")
    private Integer quantity;

}