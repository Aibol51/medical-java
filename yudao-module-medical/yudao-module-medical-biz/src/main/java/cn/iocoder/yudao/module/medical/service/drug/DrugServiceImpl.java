package cn.iocoder.yudao.module.medical.service.drug;

import cn.iocoder.yudao.module.medical.controller.app.drug.vo.AppDrugPageReqVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.drug.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.drug.DrugDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.drug.DrugMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 药品 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class DrugServiceImpl implements DrugService {

    @Resource
    private DrugMapper drugMapper;

    @Override
    public Long createDrug(DrugSaveReqVO createReqVO) {
        // 插入
        DrugDO drug = BeanUtils.toBean(createReqVO, DrugDO.class);
        drugMapper.insert(drug);
        // 返回
        return drug.getId();
    }

    @Override
    public void updateDrug(DrugSaveReqVO updateReqVO) {
        // 校验存在
        validateDrugExists(updateReqVO.getId());
        // 更新
        DrugDO updateObj = BeanUtils.toBean(updateReqVO, DrugDO.class);
        drugMapper.updateById(updateObj);
    }

    @Override
    public void deleteDrug(Long id) {
        // 校验存在
        validateDrugExists(id);
        // 删除
        drugMapper.deleteById(id);
    }

    private void validateDrugExists(Long id) {
        if (drugMapper.selectById(id) == null) {
            throw exception(DRUG_NOT_EXISTS);
        }
    }

    @Override
    public DrugDO getDrug(Long id) {
        return drugMapper.selectById(id);
    }

    @Override
    public PageResult<DrugDO> getDrugPage(DrugPageReqVO pageReqVO) {
        return drugMapper.selectPage(pageReqVO);
    }
    @Override
    public PageResult<DrugDO> getDrugPage(AppDrugPageReqVO pageReqVO) {
        return drugMapper.selectPage(pageReqVO);
    }

}