package cn.iocoder.yudao.module.medical.dal.dataobject.drug;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 药品 DO
 *
 * @author admin
 */
@TableName("medical_drug")
@KeySequence("medical_drug_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 中文名称
     */
    private String nameZh;
    /**
     * 英文名称
     */
    private String nameEn;
    /**
     * 俄语名称
     */
    private String nameRu;
    /**
     * 哈萨克语名称
     */
    private String nameKz;
    /**
     * 中文描述
     */
    private String descriptionZh;
    /**
     * 英文描述
     */
    private String descriptionEn;
    /**
     * 俄语描述
     */
    private String descriptionRu;
    /**
     * 哈萨克语描述
     */
    private String descriptionKz;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 库存数量
     */
    private Integer quantity;
    /**
     * 状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;

}