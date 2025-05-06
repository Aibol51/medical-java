package cn.iocoder.yudao.module.medical.controller.app.expert.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "用户 APP - 专家 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppExpertRespVO {

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "12708")
    @ExcelProperty("用户ID")
    private Long id;

    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("用户昵称")
    private String nickname;

    @Schema(description = "岗位编号数组")
    @ExcelProperty("岗位编号数组")
    private String postIds;

    @Schema(description = "头像地址")
    @ExcelProperty("头像地址")
    private String avatar;

    @Schema(description = "中文内容", example = "qwe")
    @ExcelProperty("中文内容")
    private String contentZh;

    @Schema(description = "英文内容", example = "qwe")
    @ExcelProperty("英文内容")
    private String contentEn;

    @Schema(description = "俄文内容", example = "qwe")
    @ExcelProperty("俄文内容")
    private String contentRu;

    @Schema(description = "哈萨克文内容", example = "qwe")
    @ExcelProperty("哈萨克文内容")
    private String contentKz;
}