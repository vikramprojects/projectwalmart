package Screenshots.screenshots;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import Base.BaseW;

public class failedscreenshots extends BaseW implements ITestListener{

	public ExtentReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	public void onStart(ITestContext outcome)	{
		logger.info("Test "+outcome.getName()+" Started.");
		
	}
	
	public void onTestSuccess(ITestResult outcome)
	{
		logger=extent.createTest(outcome.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(outcome.getName(),ExtentColor.RED)); // send the passed information to the report with color highlighted
	}
	
	public void onTestFailure(ITestResult outcome) {
		
		DateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS_MS");
		Date date = new Date();
		String d = dateformat.format(date) + ".png";
		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String pat = System.getProperty("user.dir");
			FileUtils.copyFile(shot, new File(pat + "/Screenshot/" + outcome.getName() + d));
			logger.info("Screenshot taken");
		} 
		catch (IOException e) {
			logger.fail(e);
		}
		logger.info("Test "+outcome.getName()+" Finished.");
		logger.warning("Test " + outcome.getName() + " Failed.");
		
		}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
}
}

