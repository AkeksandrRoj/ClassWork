package tests;

import org.junit.jupiter.api.*;

public class SimpleJunitTest {

    int result;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("### - beforeAll\n");
    }

    @BeforeEach
    void beforeEach() throws Exception {
        System.out.println("### BeforeEach");
         result =getResult();
    }

    @Test
    void firstTest() {
        System.out.println("###     firstTest");
        Assertions.assertTrue(result>3);
    }

    @Test
    void secondTest() {
        System.out.println("###     secondTest");
        Assertions.assertTrue(result>3);

    }

    @Test
    void thirdTest() {
        System.out.println("###     thirdTest");
        Assertions.assertTrue(result>3);

    }

    int getResult() {
        return 5;
    }

    @AfterEach
    void afterEach() throws Exception {
        System.out.println("###         AfterEach\n");
        result = 0;
    }

}
