package cn.iocoder.yudao.module.medical.service.drug;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.app.drug.vo.AppDrugPageReqVO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.drug.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.drug.DrugDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 药品 Service 接口
 *
 * @author admin
 */
public interface DrugService {

    /**
     * 创建药品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDrug(@Valid DrugSaveReqVO createReqVO);

    /**
     * 更新药品
     *
     * @param updateReqVO 更新信息
     */
    void updateDrug(@Valid DrugSaveReqVO updateReqVO);

    /**
     * 删除药品
     *
     * @param id 编号
     */
    void deleteDrug(Long id);

    /**
     * 获得药品
     *
     * @param id 编号
     * @return 药品
     */
    DrugDO getDrug(Long id);

    /**
     * 获得药品分页
     *
     * @param pageReqVO 分页查询
     * @return 药品分页
     */
    PageResult<DrugDO> getDrugPage(DrugPageReqVO pageReqVO);

    /**
     * 获得药品分页
     *
     * @param pageReqVO 分页查询
     * @return 药品分页
     */
    PageResult<DrugDO> getDrugPage(AppDrugPageReqVO pageReqVO);

}