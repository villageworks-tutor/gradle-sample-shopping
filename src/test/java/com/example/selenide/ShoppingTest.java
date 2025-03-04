package com.example.selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

class ShoppingTest {

	/* テスト補助変数 */
	private static final String URL_SAMPLE_SHOPPING = "http://localhost:8080/sample-shopping";
	
	@BeforeEach
	void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome"; // Chromeを使用
        Configuration.timeout = 2000; // タイムアウト設定
        Configuration.headless = false; // ヘッドレスモード（GUIあり）
        Configuration.baseUrl = "http://localhost:8080"; // テスト対象のURL
	}

	@Nested
	@DisplayName("Test02: メニュリンクがクリックされたときの振る舞いのテストケース")
	class MenuTest {
		@BeforeEach
		void setUp() {
			open(URL_SAMPLE_SHOPPING);
		}
		@Test
		@DisplayName("NT-002: 「ようこそ」メニュがクリックされるとトップ画面が表示される")
		void test11() {
			// execcute
			$("a#top").click();
			// verify
			$("body#top").should(visible);
			sleep(1000);
		}
		@Test
		@DisplayName("NT-003: 「本」メニュがクリックされると「本」カテゴリの商品一覧が表示される")
		void test12() {
			// execcute
			$("a#book").click();
			// verify
			$("body#list").should(visible);
			$("article#book").should(visible);
			sleep(1000);
		}
		@Test
		@DisplayName("NT-004: 「DVD」メニュがクリックされると「DVD」カテゴリの商品一覧が表示される")
		void test13() {
			// execcute
			$("a#dvd").click();
			// verify
			$("body#list").should(visible);
			$("article#dvd").should(visible);
			sleep(1000);
		}
		@Test
		@DisplayName("NT-005: 「ゲーム」メニュがクリックされると「ゲーム」カテゴリの商品一覧が表示される")
		void test14() {
			// execcute
			$("a#game").click();
			// verify
			$("body#list").should(visible);
			$("article#game").should(visible);
			sleep(1000);
		}
	}
	
	@Test
	@DisplayName("NT-001: URL「http://localhost:8080/sample-shopping」にアクセスするとトップ画面が表示される")
	void test01() {
		// 初期画面表示のテスト
		open("http://localhost:8080/sample-shopping");
		$("body#view_top").should(visible);
	}

}
