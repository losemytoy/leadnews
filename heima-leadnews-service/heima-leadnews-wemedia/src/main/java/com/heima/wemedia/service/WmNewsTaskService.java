package com.heima.wemedia.service;

import java.util.Date;

public interface WmNewsTaskService {

    /**
     *
     * @param id 文章id
     * @param publishTime 发布的时间 可以作为任务的执行时间
     */
    void addNewsToTask(Integer id, Date publishTime);


    void scanNewsByTask();
}
