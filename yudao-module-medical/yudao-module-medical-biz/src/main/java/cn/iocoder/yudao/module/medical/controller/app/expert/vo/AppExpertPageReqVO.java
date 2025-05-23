package cn.iocoder.yudao.module.medical.controller.app.expert.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "用户 APP - 专家分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppExpertPageReqVO extends PageParam {

    @Schema(description = "用户昵称", example = "芋艿")
    private String nickname;

    @Schema(description = "岗位编号数组")
    private String postIds;

}