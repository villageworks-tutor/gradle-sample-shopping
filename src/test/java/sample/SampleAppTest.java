package sample;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

class SampleAppTest {

	@BeforeEach
	void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome"; // Chromeを使用
        Configuration.timeout = 2000; // タイムアウト設定
        Configuration.headless = false; // ヘッドレスモード（GUIあり）
        Configuration.baseUrl = "http://localhost:8080"; // テスト対象のURL
	}

	@Test
	void testSelenide() {
		// サイト初期表示の確認
		open("/tmp-gradle-project");
		$("h1").shouldHave(text("Gradleプロジェクトテンプレート"));
		
		// リンク「JSPサンプル」のクリックによるJSPサンプルへの画面遷移の確認
		$("#sample").click();
		$("#sample").shouldBe(visible);
		sleep(2000);
		
	}
	
	/**
	 * 成功するテスト：gradle test --tests "sample.SampleAppTest.testSucceed"
	 */
	@Test
	void testSucceed() {
		assertThat(1 * 1, is(1));
	}
	
	/**
	 * 失敗するテスト：gradle test --tests "sample.SampleAppTest.testFailure"
	 * 失敗することを確認できたら「@Disabled」を追記しておく
	 */
	@Test
	@Disabled
	void testFailure() {
		fail("まだ実装されていません");
	}

}
