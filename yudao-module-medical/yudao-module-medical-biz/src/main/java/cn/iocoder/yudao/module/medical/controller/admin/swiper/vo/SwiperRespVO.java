package cn.iocoder.yudao.module.medical.controller.admin.swiper.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 轮播图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SwiperRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28526")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "中文图片", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("中文图片")
    private String imageZh;

    @Schema(description = "en图片", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("en图片")
    private String imageEn;

    @Schema(description = "ru图片", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("ru图片")
    private String imageRu;

    @Schema(description = "kz图片", example = "http://xxx.com/xxx.xxx")
    @ExcelProperty("kz图片")
    private String imageKz;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}