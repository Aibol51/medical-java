package cn.iocoder.yudao.module.medical.service.news;

import cn.iocoder.yudao.module.medical.controller.app.news.vo.AppNewsPageReqVO;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.medical.controller.admin.news.vo.*;
import cn.iocoder.yudao.module.medical.dal.dataobject.news.NewsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.medical.dal.mysql.news.NewsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.medical.enums.ErrorCodeConstants.*;

/**
 * 新闻 Service 实现类
 *
 * @author admin
 */
@Service
@Validated
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public Long createNews(NewsSaveReqVO createReqVO) {
        // 插入
        NewsDO news = BeanUtils.toBean(createReqVO, NewsDO.class);
        newsMapper.insert(news);
        // 返回
        return news.getId();
    }

    @Override
    public void updateNews(NewsSaveReqVO updateReqVO) {
        // 校验存在
        validateNewsExists(updateReqVO.getId());
        // 更新
        NewsDO updateObj = BeanUtils.toBean(updateReqVO, NewsDO.class);
        newsMapper.updateById(updateObj);
    }

    @Override
    public void deleteNews(Long id) {
        // 校验存在
        validateNewsExists(id);
        // 删除
        newsMapper.deleteById(id);
    }

    private void validateNewsExists(Long id) {
        if (newsMapper.selectById(id) == null) {
            throw exception(NEWS_NOT_EXISTS);
        }
    }

    @Override
    public NewsDO getNews(Long id) {
        return newsMapper.selectById(id);
    }

    @Override
    public PageResult<NewsDO> getNewsPage(NewsPageReqVO pageReqVO) {
        return newsMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<NewsDO> getNewsPage(AppNewsPageReqVO pageReqVO) {
        return newsMapper.selectPage(pageReqVO);
    }

}