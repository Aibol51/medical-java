package cn.iocoder.yudao.module.medical.controller.admin.swiper.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 轮播图新增/修改 Request VO")
@Data
public class SwiperSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28526")
    private Long id;

    @Schema(description = "中文图片", example = "http://xxx.com/xxx.xxx")
    private String imageZh;

    @Schema(description = "en图片", example = "http://xxx.com/xxx.xxx")
    private String imageEn;

    @Schema(description = "ru图片", example = "http://xxx.com/xxx.xxx")
    private String imageRu;

    @Schema(description = "kz图片", example = "http://xxx.com/xxx.xxx")
    private String imageKz;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "状态不能为空")
    private Integer status;

}