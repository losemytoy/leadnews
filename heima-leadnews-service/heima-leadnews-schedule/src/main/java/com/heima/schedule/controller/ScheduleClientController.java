package com.heima.schedule.controller;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ScheduleClientController {

    @Resource
    private TaskService taskService;
    /**
     * 添加延迟任务
     * @param task
     * @return
     */
    @PostMapping("api/v1/task/add")
    ResponseResult addTask(@RequestBody Task task) {
        return ResponseResult.okResult(taskService.addTask(task));
    }

    /**
     * 取消任务
     * @param taskId
     * @return
     */
    @GetMapping("api/v1/task/{taskId}")
    ResponseResult cancelTask(@PathVariable("taskId") long taskId) {
        return ResponseResult.okResult(taskService.cancelTask(taskId));
    }

    /**
     * 按照类型和优先级来拉取任务
     * @param type
     * @param priority
     * @return
     */
    @GetMapping("api/v1/task/{type}/{priority}")
    ResponseResult poll(@PathVariable("type")int type,@PathVariable("priority") int priority) {
        return ResponseResult.okResult(taskService.poll(type, priority));
    }
}
