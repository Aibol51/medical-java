package cn.iocoder.yudao.module.medical.dal.dataobject.news;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 新闻 DO
 *
 * @author admin
 */
@TableName("medical_news")
@KeySequence("medical_news_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 中文标题
     */
    private String titleZh;
    /**
     * 英文标题
     */
    private String titleEn;
    /**
     * 俄文标题
     */
    private String titleRu;
    /**
     * 哈萨克文标题
     */
    private String titleKz;
    /**
     * 中文内容
     */
    private String contentZh;
    /**
     * 英文内容
     */
    private String contentEn;
    /**
     * 俄文内容
     */
    private String contentRu;
    /**
     * 哈萨克文内容
     */
    private String contentKz;
    /**
     * 封面图
     */
    private String coverPath;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}