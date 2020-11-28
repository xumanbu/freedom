package webDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverTest {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.itest.info");

        String title = driver.getTitle();
        System.out.printf(title);

        driver.close();
    }

    public static void htmlUnitSignTest() throws Exception {
        WebClient wc = new WebClient(BrowserVersion.CHROME);
        wc.setJavaScriptTimeout(5000);
        wc.getOptions().setUseInsecureSSL(true);//接受任何主机连接 无论是否有有效证书
        wc.getOptions().setJavaScriptEnabled(true);//设置支持javascript脚本
        wc.getOptions().setCssEnabled(false);//禁用css支持
        wc.getOptions().setThrowExceptionOnScriptError(false);//js运行错误时不抛出异常
        wc.getOptions().setTimeout(100000);//设置连接超时时间
        wc.getOptions().setDoNotTrackEnabled(false);
        wc.getOptions().setActiveXNative(true);

        wc.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        wc.addRequestHeader("Accept-Encoding", "gzip, deflate, br");
        wc.addRequestHeader("Accept-Language", "zh-CN,zh;q=0.9");
        wc.addRequestHeader("Connection", "keep-alive");
        wc.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36");


        //HtmlPage htmlpage = wc.getPage("http://127.0.0.1:8081/demo.html?companyName=testCompany");
        HtmlPage htmlpage = wc.getPage("http://www.baidu.com");
        String res = htmlpage.asXml();
        //处理源码
        System.out.println(res);

//        HtmlForm form = htmlpage.getFormByName("f");
//        HtmlButton button = form.getButtonByName("btnDomName"); // 获取提交按钮
//        HtmlPage nextPage = button.click();
//        System.out.println("等待20秒");
//        Thread.sleep(2000);
//        System.out.println(nextPage.asText());
        wc.close();
    }
}
