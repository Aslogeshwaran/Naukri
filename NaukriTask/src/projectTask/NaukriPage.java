package projectTask;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NaukriPage extends BaseClass{

	private static String searchJobFieldValue="input[placeholder^='Enter skill']";
	private static By searchJobField=By.cssSelector(searchJobFieldValue);
	
	private static String experienceDropDownValue="expereinceDD";
	private static By experienceDropDown=By.id(experienceDropDownValue);
	
	private static String experienceDropDownListValue="ul[class^='dropdown']>li";
	private static By experienceDropDownList=By.cssSelector(experienceDropDownListValue);
	
	private static String searchButtonValue="//div[text()='Search']";
	private static By searchButton=By.xpath(searchButtonValue);
	
	private static String sortByButtonValue="filter-sort";
	private static By sortByButton=By.id(sortByButtonValue);
	
	private static String sortByOptionValue="//ul[@data-filter-id='sort']/li[2]/a/span";
	private static By sortByOption=By.xpath(sortByOptionValue);
	
	private static String departmentViewMoreOptionValue="//a[@id='functionAreaIdGid']/span";
	private static By departmentViewMoreOption=By.xpath(departmentViewMoreOptionValue);
	
	private static String applyButtonValue="//div[text()='Apply']";
	private static By applyButton=By.xpath(applyButtonValue);
	
	private static String qaRoleButtonValue="/html/body/div/div/main/div[1]/div[1]/div/div/div[2]/div[7]/div[2]/div[2]/label/i";
	private static By qaRoleButton=By.xpath(qaRoleButtonValue);

	public static void searchJob(String enterTheSkills){
		sendKeys(searchJobField, enterTheSkills);
	}

	public static void clickExperienceDropDown(){
		click(experienceDropDown);
	}

	public static void chooseYearsofExperience(int enterYearsofExp){
		List<WebElement> experienceList =findElements(experienceDropDownList);
		for (WebElement bb : experienceList) {
			if(Integer.parseInt(bb.getAttribute("index"))==enterYearsofExp){
				bb.click();
				break;
			}
		}
	}

	public static void clickSearchButton(){
		click(searchButton);
	}

	public static void clickSortByButton(){
		click(sortByButton);
	}

	public static void chooseSortByOption(String chooseValue){
		List<WebElement> filterList=findElements(sortByOption);
		for (WebElement aa : filterList) {
			if(aa.getText().contains(chooseValue)){
				aa.click();
				break;
			}
		}
	}

	public static void clickDepartmentViewMoreOption(){
		click(departmentViewMoreOption);
	}

	public static void chooseDepartment(String entertheDepartment){
		List<WebElement> departments = driver.findElements(By.xpath("//div[@class='swiper-wrapper']/div"));
		int departmentsSize = departments.size();
		for (int i=1;i<=departmentsSize;i++) {
			List<WebElement> columns = driver.findElements(By.xpath("//div[@class='swiper-wrapper']/div["+i+"]/div"));
			int columnsSize = columns.size();
			for(int j=1; j<=columnsSize;j++){
				WebElement element = driver.findElement(By.xpath("//div[@class='swiper-wrapper']/div["+i+"]/div["+j+"]"));
				String text =element.getText();
				if(text.contains(entertheDepartment)){
					WebElement element2 = driver.findElement(By.xpath("//div[@id='swiperType']/div/div["+i+"]/div["+j+"]/label/i"));
					                                                  // /html/body/div/div/main/div[1]/div[1]/div/div/div[2]/div[4]/div[3]/div[2]/div[2]/div/div[1]/div[1]/label/i
					element2.click();
					break;	
				}

			}
		}
	}

	public static void clickApplyButton(){
		click(applyButton);
	}

	public static void clickQARoleButton(){
		click(qaRoleButton);
	}

	public static ArrayList<String> getJobsLinksinPagination(){
		for(int p=1; p<=Constants.paginationCount; p++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/div/div/main/div[1]/div[2]/div[3]/div/div[2]/a["+p+"]")).click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=1; i<=20; i++){
				if(i == 4 || i == 9 || i == 13 || i == 17 || i == 20){
					continue;}
				WebElement jobsLinks = driver.findElement(By.xpath("/html/body/div/div/main/div[1]/div[2]/div[2]/div/div["+i+"]/div/div[1]/a"));
				
				String jobsLink = jobsLinks.getAttribute("href");
				list.add(jobsLink);
			}
		}

		return list;
	}
}
