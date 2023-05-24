package org.example.task;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class PageScreenshotTest {
    @Test
    public void testScreenshot( ) {
        try (Playwright playwright = Playwright.create()) {
                try (Browser browser = playwright.chromium().launch()) {
                    BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                            .setViewportSize(1280, 1024)
                            .setAcceptDownloads(false)
                            .setLocale("en-US")
                    );
                    Page page = context.newPage();
                    page.navigate("https://www.amazon.com/Best-Sellers/zgbs");
                    page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot-" + System.currentTimeMillis() + ".png")));
                }
        }
    }
}
