package cn.iocoder.yudao.module.medical.service.record;

import cn.iocoder.yudao.module.medical.controller.app.record.vo.AppRecordPageReqVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.record.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.record.RecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.record.RecordMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * 健康记录 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class RecordServiceImpl implements MedicalRecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public Long createRecord(RecordSaveReqVO createReqVO) {
        // 插入
        RecordDO record = BeanUtils.toBean(createReqVO, RecordDO.class);
        recordMapper.insert(record);
        // 返回
        return record.getId();
    }

    @Override
    public void updateRecord(RecordSaveReqVO updateReqVO) {
        // 校验存在
        validateRecordExists(updateReqVO.getId());
        // 更新
        RecordDO updateObj = BeanUtils.toBean(updateReqVO, RecordDO.class);
        recordMapper.updateById(updateObj);
    }

    @Override
    public void deleteRecord(Long id) {
        // 校验存在
        validateRecordExists(id);
        // 删除
        recordMapper.deleteById(id);
    }

    private void validateRecordExists(Long id) {
        if (recordMapper.selectById(id) == null) {
            throw exception(RECORD_NOT_EXISTS);
        }
    }

    @Override
    public RecordDO getRecord(Long id) {
        return recordMapper.selectById(id);
    }

    @Override
    public PageResult<RecordDO> getRecordPage(RecordPageReqVO pageReqVO) {
        return recordMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<RecordDO> getRecordPage(AppRecordPageReqVO pageReqVO) {
        pageReqVO.setUserId(getLoginUserId());
        return recordMapper.selectPage(pageReqVO);
    }

}