package by.htp.selenium.run;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class SimpleSeleniumExample {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "C:\\WebDrivers\\chromedriver_win32\\chromedriver.exe";

	private static int count;

	public static void main(String[] args) {
		System.setProperty(CHROME, CHROME_PATH);
		WebDriver driver = new ChromeDriver();

		task1(driver, "http://google.com");

		task2(driver, "https://tut.by/");

		task3Registration(driver, "http://www.quizful.net");

		task4Autauthorization(driver, "http://www.quizful.net");

		task5(driver, "https://www.it-academy.by/");
		driver.quit();

	}

	public static void task4Autauthorization(WebDriver driver, String path) {
		driver.get(path);
		WebElement enterElem = driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[1]/a"));
		enterElem.click();
		WebElement loginElem = driver.findElement(By.id("login"));
		loginElem.sendKeys("seleniumtest");
		WebElement passElem = driver.findElement(By.name("loginForm.password"));
		passElem.sendKeys("mypassword2018");
		WebElement enterButton = driver.findElement(By.name("ok"));
		enterButton.click();
		WebElement profileElem = driver.findElement(By.xpath("//*[@id=\"navigation\"]/li[7]/a"));
		profileElem.click();
		sleep(2000);
		editButtonEnter(driver);
		WebElement persInfElem = driver.findElement(By.xpath("//*[@id=\"profile-personal-form\"]/div[2]/img"));
		persInfElem.click();
		sleep(1000);
		WebElement nameElemPI = driver.findElement(By.name("personalForm.name"));
		nameElemPI.clear();
		nameElemPI.sendKeys("Alex");
		sleep(1000);
		WebElement surNameElemPI = driver.findElement(By.name("personalForm.surname"));
		surNameElemPI.clear();
		surNameElemPI.sendKeys("Domashevski");
		sleep(1000);
		WebElement yearElemPI = driver.findElement(By.name("personalForm.birthyear"));
		yearElemPI.clear();
		yearElemPI.sendKeys("1987");
		sleep(1000);
		WebElement siteElemPI = driver.findElement(By.name("personalForm.site"));
		siteElemPI.clear();
		siteElemPI.sendKeys("alex.domashevski.by");
		sleep(1000);
		WebElement companyElemPI = driver.findElement(By.name("personalForm.company"));
		companyElemPI.clear();
		companyElemPI.sendKeys("HouseBuilder");
		sleep(1000);
		WebElement countryElem = driver.findElement(By.name("personalForm.countryId"));
		List<WebElement> listCountries = countryElem.findElements(By.tagName("option"));
		for (WebElement webElement : listCountries) {
			if (webElement.getText().equals("Беларусь")) {
				webElement.click();
			}
		}
		sleep(1000);
		WebElement hourElem = driver.findElement(By.name("personalForm.zone"));
		List<WebElement> listHours = hourElem.findElements(By.tagName("option"));
		for (WebElement webElement : listHours) {
			if (webElement.getText().contains("Белоруссия")) {
				webElement.click();
			}
		}
		sleep(1000);
		WebElement aboutHimself = driver.findElement(By.name("personalForm.about"));
		aboutHimself.sendKeys("Nothing else");
		sleep(1000);
		WebElement savePersanalFormButton = driver.findElement(By.name("personalForm.save"));
		savePersanalFormButton.click();
		editButtonEnter(driver);
		sleep(1000);
		WebElement notificationElem = driver.findElement(By.xpath("//*[@id=\"profile-notifications-form\"]/div[1]/b"));
		notificationElem.click();
		sleep(1000);
		WebElement checkboxNotifElem = driver.findElement(By.name("notificationsForm.notificationsEnabled"));
		if (enableOrNotCheckbox(checkboxNotifElem))
			checkboxNotifElem.click();
		sleep(1000);
		WebElement checkboxDelivery = driver.findElement(By.name("notificationsForm.deliveryEnabled"));
		if (enableOrNotCheckbox(checkboxDelivery))
			checkboxDelivery.click();
		sleep(1000);
		WebElement saveChanges = driver.findElement(By.name("notificationsForm.save"));
		saveChanges.click();
		editButtonEnter(driver);
		sleep(1000);
		WebElement confElem = driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[1]/b"));
		confElem.click();
		sleep(1000);
		WebElement radio = driver.findElement(
				By.xpath("//*[@id=\"profile-privacy-form\"]/div[2]/form/table/tbody/tr[4]/td[1]/label/input"));
		if (!enableOrNotCheckbox(radio))
			radio.click();
		sleep(1000);
		WebElement savePrivacyFormButton = driver.findElement(By.name("privacyForm.save"));
		savePrivacyFormButton.click();
	}

	private static boolean enableOrNotCheckbox(WebElement element) {
		if (element.getAttribute("checked") != null) {
			return true;
		} else
			return false;
	}

	private static void editButtonEnter(WebDriver driver) {
		WebElement editButton = driver.findElement(By.className("btn-group"));
		editButton.click();
	}

	public static void task5(WebDriver driver, String path) {

		driver.get(path);
		WebElement elemMenu = driver
				.findElement(By.xpath("/html/body/div/asside/div/div/div[2]/div[2]/ul/li[1]/a/span"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elemMenu);
		List<WebElement> listCourses = driver
				.findElements(By.xpath("/html/body/div/main/section[1]/section[1]/div/ul/li"));
		for (WebElement webElement : listCourses) {
			WebElement elemTeg = webElement.findElement(By.xpath(".//a/span"));
			System.out.println(elemTeg.getText());
			List<WebElement> listProgramm = webElement.findElements(By.xpath(".//ul/li/a"));
			for (WebElement webElement2 : listProgramm) {
				System.out.println(webElement2.getText());
			}
		}
	}

	public static void task3Registration(WebDriver driver, String path) {
		driver.get(path);
		WebElement registration = driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[3]/a"));
		registration.click();
		WebElement loginElem = driver.findElement(By.id("login"));
		loginElem.sendKeys("seleniumtest");
		WebElement passElem = driver.findElement(By.name("registrationForm.password"));
		passElem.sendKeys("mypassword2018");
		WebElement repeatPassElem = driver.findElement(By.name("registrationForm.repassword"));
		repeatPassElem.sendKeys("mypassword2018");
		WebElement mailElem = driver.findElement(By.name("registrationForm.email"));
		mailElem.sendKeys("alextest1312903@gmail.com");
		WebElement corpElem = driver.findElement(By.id("corporate"));
		corpElem.click();
		inputCaptcha(driver);
		WebElement submitButton = driver.findElement(By.name("ok"));
		submitButton.click();
	}

	private static void inputCaptcha(WebDriver driver) {
		String capchaVal = JOptionPane.showInputDialog("Введите capcha  значение");
		driver.findElement(By.name("registrationForm.captcha")).sendKeys(capchaVal);
	}

	public static void task2(WebDriver driver, String path) {
		driver.get(path);
		WebElement elementTopNews = driver.findElement(By.className("entry-head"));
		elementTopNews.click();
		WebElement elementNews = driver.findElement(By.id("article_body"));
		List<WebElement> listPar = elementNews.findElements(By.cssSelector("p"));
		System.out.println(listPar.size());
	}

	public static void task1(WebDriver driver, String path) {
		driver.get(path);
		WebElement webElement = driver.findElement(By.name("q"));
		webElement.sendKeys("web driver 3 new features java 8 htp tat 9");
		sleep(1000);
		webElement.submit();
		String title = driver.getTitle();
		clicAllReference(driver);
	}

	private static void clicAllReference(WebDriver driver) {
		count += findReference(driver);
		if (isElementPresent(By.id("pnnext"), driver)) {
			WebElement buttonNext = driver.findElement(By.id("pnnext"));
			buttonNext.click();
			clicAllReference(driver);
			sleep(1000);
		}
	}

	private static Integer findReference(WebDriver driver) {
		List<WebElement> listReference = driver.findElements(By.className("r"));
		return listReference.size();
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
