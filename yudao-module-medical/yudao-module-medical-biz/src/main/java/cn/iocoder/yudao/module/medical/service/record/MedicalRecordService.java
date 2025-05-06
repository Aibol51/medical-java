package cn.iocoder.yudao.module.medical.service.record;

import java.util.*;

import cn.iocoder.yudao.module.medical.controller.app.record.vo.AppRecordPageReqVO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.medical.controller.admin.record.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.record.RecordDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 健康记录 Service 接口
 *
 * @author admin
 */
public interface MedicalRecordService {

    /**
     * 创建健康记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecord(@Valid RecordSaveReqVO createReqVO);

    /**
     * 更新健康记录
     *
     * @param updateReqVO 更新信息
     */
    void updateRecord(@Valid RecordSaveReqVO updateReqVO);

    /**
     * 删除健康记录
     *
     * @param id 编号
     */
    void deleteRecord(Long id);

    /**
     * 获得健康记录
     *
     * @param id 编号
     * @return 健康记录
     */
    RecordDO getRecord(Long id);

    /**
     * 获得健康记录分页
     *
     * @param pageReqVO 分页查询
     * @return 健康记录分页
     */
    PageResult<RecordDO> getRecordPage(RecordPageReqVO pageReqVO);


    /**
     * 获得健康记录分页
     *
     * @param pageReqVO 分页查询
     * @return 健康记录分页
     */
    PageResult<RecordDO> getRecordPage(AppRecordPageReqVO pageReqVO);

}