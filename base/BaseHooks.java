package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseHooks {

	//public static ChromeDriver driver;
	public ChromeDriver driver;
	
	public static String leadID;
	
	public String excelFileName;
	
	//public static Properties prop;
	public Properties prop;
	
	@DataProvider(indices =0)
	public String[][] sendData() throws IOException{
		
		utils.ReadExcel re= new utils.ReadExcel();
		String[][] readData = re.readData(excelFileName);
		
		
		
		return readData;
		
		
		
		}
	
	//to execute before each scenario
	@Parameters({"language"})
	@BeforeMethod
	public void preCondition(String lang) throws IOException {
		if(lang.equals("english")) {
		//FileInputStream fis = new FileInputStream("./src/main/resources/english.properties");
			FileInputStream fis = new FileInputStream("./src/main/resources/"+lang+".properties");
		prop = new Properties();
		prop.load(fis);
		} else if(lang.equals("french")) {
			FileInputStream fis = new FileInputStream("./src/main/resources/"+lang+".properties");
			prop = new Properties();
			prop.load(fis);
			
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://leaftaps.com/opentaps/");
			}
//To execute after each scenario
	@AfterMethod
	public void postCondition() {
		//driver.close();
	}
}
