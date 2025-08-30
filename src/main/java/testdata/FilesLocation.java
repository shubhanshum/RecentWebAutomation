package testdata;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface FilesLocation {
	
	String timestamp=new SimpleDateFormat("dd.MM.yyyy.ss").format(new Date());

	String configFile=System.getProperty("user.dir")+"\\config.properties";
	String reportPath="\\TestReports\\"+"TestReport"+timestamp+".html";
}
