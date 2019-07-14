import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.os.ExecutableFinder

import static org.apache.commons.lang3.SystemUtils.IS_OS_LINUX
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC
import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS

File findDriverExecutable() {
    def defaultExecutable = new ExecutableFinder().find("chromedriver-windows.exe")
    if (defaultExecutable) {
        new File(defaultExecutable)
    } else {
        f = new File("drivers").listFiles().findAll {
            !it.name.endsWith(".version")
        }.find {
            if (IS_OS_LINUX) {
                it.name.contains("linux")
            } else if (IS_OS_MAC) {
                it.name.contains("mac")
            } else if (IS_OS_WINDOWS) {
                it.name.contains("windows")
            }
        }
        print "="
        print f.getName()
        print "="
        return f
    }
}

driver = {
    ChromeOptions options = new ChromeOptions()
    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    options.addArguments("headless")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    ChromeDriverService.Builder serviceBuilder = new ChromeDriverService.Builder()
            .usingAnyFreePort()
            .usingDriverExecutable(findDriverExecutable())
    new ChromeDriver(serviceBuilder.build(), capabilities)
}

baseUrl = "http://gebish.org"

waiting {
    timeout = 2
}