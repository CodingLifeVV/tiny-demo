package com.codinglife;

import com.codinglife.mybatisplus.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CodingLife
 * @Description TODD
 * @since 2022/3/2 22:07
 */
@SpringBootTest
class MybatisplusGeneratorApplicationTest {
    @Test
    public void testMybatisPlusGenarator() {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generator();
    }
}
