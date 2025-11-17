import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProviderTest {
    DataFormatter dataFormatter = new DataFormatter();
    @Test(dataProvider = "getdata")
    public void getExcelDataTest(String greetings,String communication,String id) {
        System.out.println(greetings+" "+communication+" "+id);
    }
    @DataProvider(name ="getdata")
    public Object[][] getdata() throws IOException {

        FileInputStream fis = new FileInputStream("C://Users//Basharmal Safi//Documents/demo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount= sheet.getPhysicalNumberOfRows();
        int columnCount= sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data=new Object[rowCount-1][columnCount];


        for(int i=0;i<rowCount;i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j=0;j<columnCount;j++) {
                XSSFCell cell = row.getCell(j);
                data[i-1][j]=dataFormatter.formatCellValue(cell);

            }
        }

        return data;
    }
}
