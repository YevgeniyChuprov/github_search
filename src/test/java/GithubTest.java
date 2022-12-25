import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    public void githubTest(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-body ul").shouldBe(text("Soft assertions"));
        $("#wiki-pages-box .wiki-more-pages-link button").click();
        $x("//*[@id='wiki-pages-box']//a[text()='SoftAssertions']").click();
        $("#wiki-body").shouldBe(text("3. Using JUnit5 extend test class:"));
    }
}
