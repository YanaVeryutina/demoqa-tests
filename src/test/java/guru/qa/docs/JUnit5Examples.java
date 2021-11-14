package guru.qa.docs;

import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is the before all method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is the after all method");
    }

    @BeforeEach
    void openYandex() {
        //   open("ya.ru");
        System.out.println("    open(\"ya.ru\")");
    }

    @AfterEach
    void takeScreenshot() {
        System.out.println("    takeScreenshot();");
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(true);
        System.out.println("            first test");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(true);
        System.out.println("               second test");
    }


}