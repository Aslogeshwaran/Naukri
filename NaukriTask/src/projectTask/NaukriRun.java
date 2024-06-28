package projectTask;


import java.util.ArrayList;


public class NaukriRun extends NaukriPage{

	
	
	public static void main(String[] args) throws InterruptedException {

		
		browserSetup(Constants.chromeBrowser);
		System.out.println("Info : --> : WebBrowser has been launched successfully");

		maximize();
		System.out.println("Info : --> : The window has been maximized successfully");
		
		implictWait(Constants.longWait);
		
		passURL(Constants.pageURL);
		System.out.println("Info : --> : URL has been Passed successfully");
		
		String printTitle = printTitle();
		System.out.println("Info : --> : The title of the page : " +printTitle);
		System.out.println("Info : --> : Identified the title of the page successfully");
		
		String printCurrentURL = printCurrentURL();
		System.out.println("Info : --> : The Current URL of the page : " +printCurrentURL);
		System.out.println("Info : --> : Identified the URL of the page successfully");
		
		searchJob(Constants.jobSearchKeyword);
		System.out.println("Info : --> : Keyword Entered in the webpage : " +Constants.jobSearchKeyword);
		System.out.println("Info : --> : keyword / designation / companies Entered successfully");
		
		clickExperienceDropDown();
		System.out.println("Info : --> : Dropdown options successfully clicked");
		
		chooseYearsofExperience(Constants.yearsOfExperience);
		System.out.println("Info : --> : Years of Experience Entered in the webpage : " +Constants.yearsOfExperience);
		System.out.println("Info : --> : Years of Experience Entered successfully");
		
		clickSearchButton();
		System.out.println("Info : --> : Search Button successfully clicked");
		
		clickSortByButton();
		System.out.println("Info : --> : SortBy Button successfully clicked");
		
		chooseSortByOption(Constants.sortBy);
		System.out.println("Info : --> : SortBy Choosed in the webpage : " +Constants.sortBy);
		System.out.println("Info : --> : SortBy Choosed successfully");
		
		clickDepartmentViewMoreOption();
		System.out.println("Info : --> : Department View more Option successfully clicked");
		
		chooseDepartment(Constants.jobSearchDepartment);
		System.out.println("Info : --> : Department Entered in the webpage : " +Constants.jobSearchDepartment);
		System.out.println("Info : --> : Choose Department Entered successfully");
		
		clickApplyButton();
		System.out.println("Info : --> : Apply Button successfully clicked");
		
		Thread.sleep(2000);
		
		scrollingDown(0,700);
		System.out.println("Info : --> : WebPage successfully Scrolled");
		
		clickQARoleButton();
		System.out.println("Info : --> : QA Role Button successfully clicked");
		
		ArrayList<String> jobsLinksinPagination = getJobsLinksinPagination();
		System.out.println(jobsLinksinPagination.size());

		for (String aa : jobsLinksinPagination) {
			System.out.println(aa);
		} 
		System.out.println("Info : --> : Identified the Job Posts of the page successfully");
		
		quit();
		System.out.println("Info : --> : The Window has been closed successfully");
	}

}
