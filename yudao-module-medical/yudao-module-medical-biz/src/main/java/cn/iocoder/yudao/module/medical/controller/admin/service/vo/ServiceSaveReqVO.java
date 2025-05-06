package cn.iocoder.yudao.module.medical.controller.admin.service.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 服务新增/修改 Request VO")
@Data
public class ServiceSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17135")
    private Long id;

    @Schema(description = "中文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "中文名称不能为空")
    private String nameZh;

    @Schema(description = "英文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "英文名称不能为空")
    private String nameEn;

    @Schema(description = "俄文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "俄文名称不能为空")
    private String nameRu;

    @Schema(description = "哈萨克文名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "qwe")
    @NotEmpty(message = "哈萨克文名称不能为空")
    private String nameKz;

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

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "状态不能为空")
    private Integer status;

}