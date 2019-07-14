////driver = "htmlunit"
//
//import org.openqa.selenium.chrome.ChromeDriver
//import org.openqa.selenium.chrome.ChromeDriverService
//import org.openqa.selenium.os.ExecutableFinder
//
//import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
//import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
//import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS
//
//File findDriverExecutable() {
//    def defaultExecutable = new ExecutableFinder().find("chromedriver")
//    if (defaultExecutable) {
//        new File(defaultExecutable)
//    } else {
//        new File("drivers").listFiles().findAll {
//            !it.name.endsWith(".version")
//        }.find {
//            if (IS_OS_LINUX) {
//                it.name.contains("linux")
//            } else if (IS_OS_MAC) {
//                it.name.contains("mac")
//            } else if (IS_OS_WINDOWS) {
//                it.name.contains("windows")
//            }
//        }
//    }
//}
//
//driver = {
//    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
//            .usingAnyFreePort()
//            .usingDriverExecutable(findDriverExecutable())
//    new ChromeDriver(serviceBuilder.build())
//}
//
//baseUrl = "http://gebish.org"

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions

baseUrl = "http://gebish.org"

driver = {
    FirefoxOptions options = new FirefoxOptions()
    options.addArguments("incognito")
    def firefoxDriver = new FirefoxDriver(options)
    firefoxDriver.manage().window().maximize()
    firefoxDriver
}