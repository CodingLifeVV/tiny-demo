package com.codinglife;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codinglife.entity.User;
import com.codinglife.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        System.out.println("查询表中所有数据: ");
        List<User> userList = userMapper.selectList(null);
        //Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        User user = userMapper.selectById(1L);
        System.out.println("根据Id查询: " + user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println("批量查询: ");
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User("CodingLife", 20, "wyj_program@163.com");
        int result = userMapper.insert(user);
        System.out.println("影响的行数 : " + result); // 影响的行数
        System.out.println(user); // id 自动回填
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(1L);
        user.setAge(30);

        int result = userMapper.updateById(user);
        System.out.println("影响的行数 : " + result); //影响的行数

        User user1 = userMapper.selectById(1L);
        System.out.println(user1);
    }

    @Test
    public void testAutoFill() {
        User user = new User(null, "CodingLife", 35, "1013801973@qq.com", null, null,null,null);
        System.out.println("插入时自动填充 createTime : ");
        System.out.println( userMapper.insert(user) );

        user.setAge(36);
        System.out.println("更新时自动填充 updateTime : ");
        System.out.println(userMapper.updateById(user));
    }

    @Test
    public void testOptimisticLocker() {
        // 拿到数据库 ID=1 的记录, 同时拿到当前记录的版本号 oldVersion = 1
        User user = userMapper.selectById(1L);
        // 更新该条记录的信息
        user.setName("codeLifeV");

        // 模拟事务 X 对该条记录进行了修改, 并使当前数据库的版本号增 1, 此时 version = 2
        User user2 = userMapper.selectById(1L);
        user2.setName("codeLifeVV");
        userMapper.updateById(user2);

        // 当前事务更新数据, 发现 oldVersion 不等于 version
        userMapper.updateById(user);
    }

    @Test
    public void testPagePlugin() {
        // 根据 entity 条件, 分页查询获取全部数据
        //Page<User> page = new Page<User>(1,2);
        //userMapper.selectPage(page, null);
        //page.getRecords().forEach(System.out::println);

        // 分页查询获取全部记录, 数据封装在 Map 集合中
        IPage<Map<String, Object>> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        mapIPage.getRecords().forEach(System.out::println);


        System.out.println("获取分页信息: ");
        System.out.println("总条数" + page.getTotal());
        System.out.println("当前页码" + page.getCurrent());
        System.out.println("总页码" + page.getPages());
        System.out.println("每页显示的条数" + page.getSize());
        //System.out.println("是否有上一页" + page.hasPrevious());
        //System.out.println("是否有下一页" + page.hasNext());
    }

    @Test
    public void testDeleteByID() {
        int result = userMapper.deleteById(6L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(3, 4, 5));
        System.out.println(result);
    }

    @Test
    public void testDeleteByMap() {
        // 删除 user 表 name=Jack, age=20 的记录
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test
    public void  testLogicDelete() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }



}

