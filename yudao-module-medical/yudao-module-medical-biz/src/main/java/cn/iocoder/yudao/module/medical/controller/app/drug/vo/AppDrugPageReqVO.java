package cn.iocoder.yudao.module.medical.controller.app.drug.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "用户 APP - 药品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppDrugPageReqVO extends PageParam {

    @Schema(description = "中文名称", example = "yaopin")
    private String nameZh;

    @Schema(description = "英文名称", example = "yaopin")
    private String nameEn;

    @Schema(description = "俄语名称", example = "yaopin")
    private String nameRu;

    @Schema(description = "哈萨克语名称", example = "yaopin")
    private String nameKz;

    @Schema(description = "状态", example = "2")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}