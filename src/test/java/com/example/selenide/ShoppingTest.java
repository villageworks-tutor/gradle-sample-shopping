package com.example.selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

class ShoppingTest {

	@BeforeEach
	void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome"; // Chromeを使用
        Configuration.timeout = 2000; // タイムアウト設定
        Configuration.headless = false; // ヘッドレスモード（GUIあり）
        Configuration.baseUrl = "http://localhost:8080"; // テスト対象のURL
	}

	@Test
	void test() {
		open("http://localhost:8080/sample-shopping");
		$("body#view_top").should(visible);
	}

}
