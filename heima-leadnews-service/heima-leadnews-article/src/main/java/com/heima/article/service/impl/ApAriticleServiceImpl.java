package com.heima.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ApAriticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService{

    @Resource
    private ApArticleMapper apArticleMapper;

    private static final short MIN_PAGE_SIZE = 50;
    /**
     * 加载文章列表
     *
     * @param articleHomeDto
     * @param type
     * @return
     */
    @Override
    public ResponseResult load(ArticleHomeDto articleHomeDto, Short type) {
        //1.校验参数
        Integer size = articleHomeDto.getSize();
        if (size == null || size == 0) {
            size = 10;
        }

        size = Math.min(size, MIN_PAGE_SIZE);

        if (!type.equals(ArticleConstants.LOADTYPE_LOAD_MORE) && !type.equals(ArticleConstants.LOADTYPE_LOAD_NEW)) {
            type = ArticleConstants.LOADTYPE_LOAD_MORE;
        }

        if (StringUtils.isBlank(articleHomeDto.getTag())) {
            articleHomeDto.setTag(ArticleConstants.DEFAULT_TAG);
        }

        if (articleHomeDto.getMaxBehotTime() == null) articleHomeDto.setMaxBehotTime(new Date());
        if (articleHomeDto.getMinBehotTime() == null) articleHomeDto.setMinBehotTime(new Date());

        List<ApArticle> apArticles = apArticleMapper.loadArticleList(articleHomeDto, type);
        return ResponseResult.okResult(apArticles);
    }
}
