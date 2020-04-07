package com.knoldus

import org.openqa.selenium.chrome.ChromeDriver
import org.scalatestplus.testng.TestNGSuite
import org.testng.Reporter
import org.testng.annotations.Test


class ThirdTest extends TestNGSuite with ReadExcel {

  System.setProperty("webdriver.chrome.driver", "/home/knoldus/Downloads/chromedriver_linux64(2)/chromedriver")
  val driver = new ChromeDriver()

  @Test
  def MyntraWindow(): Unit = {
    driver.manage().window().maximize()
    driver.get("https://www.myntra.com/")
    Reporter.log("site accessed")
    driver.findElementByCssSelector("#desktop-header-cnt > div.desktop-bound > div.desktop-actions > div > div.desktop-userIconsContainer > span.desktop-userTitle").click()
    driver.findElementByCssSelector("#desktop-header-cnt > div.desktop-bound > div.desktop-actions > div > div.desktop-userActions > div.desktop-userActionsContent > div:nth-child(2) > div.desktop-getUserInLinks.desktop-getInLinks > a:nth-child(2)").click()
    Reporter.log("clicked on the log in button")
    driver.findElementByCssSelector("#mountRoot > div > div > div > div > form > fieldset.login-input-container > div:nth-child(1) > input").clear()

    val username = getData(0, 0, 0)
    driver.findElementByCssSelector("#mountRoot > div > div > div > div > form > fieldset.login-input-container > div:nth-child(1) > input").sendKeys(username)
    Reporter.log("username entered")
    driver.findElementByCssSelector("#mountRoot > div > div > div > div > form > fieldset.login-input-container > div:nth-child(2) > input").clear()

    val password = getData(0, 1, 0)
    driver.findElementByCssSelector("#mountRoot > div > div > div > div > form > fieldset.login-input-container > div:nth-child(2) > input").sendKeys(password)
    Reporter.log("password entered")
    driver.findElementByCssSelector("#mountRoot > div > div > div > div > form > fieldset.login-login-button-container > button").click()
    driver.quit()
    Reporter.log("window closed")
  }
}
