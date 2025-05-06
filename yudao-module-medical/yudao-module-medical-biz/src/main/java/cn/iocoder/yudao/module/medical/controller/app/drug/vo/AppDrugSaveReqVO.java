package cn.iocoder.yudao.module.medical.controller.app.drug.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "用户 APP - 药品新增/修改 Request VO")
@Data
public class AppDrugSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "24625")
    private Long id;

    @Schema(description = "中文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @NotEmpty(message = "中文名称不能为空")
    private String nameZh;

    @Schema(description = "英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @NotEmpty(message = "英文名称不能为空")
    private String nameEn;

    @Schema(description = "俄语名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @NotEmpty(message = "俄语名称不能为空")
    private String nameRu;

    @Schema(description = "哈萨克语名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "yaopin")
    @NotEmpty(message = "哈萨克语名称不能为空")
    private String nameKz;

    @Schema(description = "中文描述", example = "yaopin")
    private String descriptionZh;

    @Schema(description = "英文描述", example = "yaopin")
    private String descriptionEn;

    @Schema(description = "俄语描述", example = "yaopin")
    private String descriptionRu;

    @Schema(description = "哈萨克语描述", example = "yaopin")
    private String descriptionKz;

    @Schema(description = "图片路径", example = "https://xxx.com/xxx.xxx")
    private String imagePath;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "库存数量不能为空")
    private Integer quantity;

}