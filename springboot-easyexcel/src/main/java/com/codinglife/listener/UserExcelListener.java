package com.codinglife.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.codinglife.entity.User;
import com.codinglife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/21 11:05
 */
public class UserExcelListener extends AnalysisEventListener<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExcelListener.class);
    public UserService userService;

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<User> list = new ArrayList<User>();

    public UserExcelListener(UserService userService) {
        this.userService = userService;
    }

    public UserExcelListener() {
    }

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据");
        list.add(user);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            // 批量将数据存储在数据库中
            userService.saveBatch(list);
            LOGGER.info("存储数据库成功！");
            // 存储完成清理 list
            list.clear();
        }

    }


    /**
     * 所有数据解析完成了 都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        userService.saveBatch(list);
        LOGGER.info("所有数据解析完成！");
    }
}
