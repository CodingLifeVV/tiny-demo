package com.codinglife.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Component
public class AutoFillConfig implements MetaObjectHandler {
    private static final Logger log =
            LoggerFactory.getLogger(AutoFillConfig.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // 自动填充属性 createTime
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        // 自动填充属性 deleted
        this.strictInsertFill(metaObject, "deleted", Integer.class, 0);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        // 自动填充属性 version
        this.strictUpdateFill(metaObject, "version", Integer.class, 1);
    }
}
