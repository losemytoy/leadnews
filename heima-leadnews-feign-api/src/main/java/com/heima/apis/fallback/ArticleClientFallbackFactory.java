package com.heima.apis.fallback;

import com.heima.apis.IArticleClient;
import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.Collection;

@Slf4j
public class ArticleClientFallbackFactory implements FallbackFactory<IArticleClient> {
    @Override
    public IArticleClient create(Throwable cause) {
        return new IArticleClient() {
            @Override
            public ResponseResult saveArticle(ArticleDto dto) {
                log.error("文章保存失败", cause);
                return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
            }
        };
    }
}
