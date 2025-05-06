package cn.iocoder.yudao.module.medical.dal.dataobject.swiper;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 轮播图 DO
 *
 * @author admin
 */
@TableName("medical_swiper")
@KeySequence("medical_swiper_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwiperDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 中文图片
     */
    private String imageZh;
    /**
     * en图片
     */
    private String imageEn;
    /**
     * ru图片
     */
    private String imageRu;
    /**
     * kz图片
     */
    private String imageKz;
    /**
     * 状态
     */
    private Integer status;

}