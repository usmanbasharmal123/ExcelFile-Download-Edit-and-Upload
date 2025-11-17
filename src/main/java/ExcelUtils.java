import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils implements AutoCloseable {
    private final String filePath;
    private final XSSFWorkbook workbook;
    private final XSSFSheet sheet;
    private final DataFormatter dataFormatter = new DataFormatter();
    public ExcelUtils(String filePath, String sheetName) throws IOException {
    this.filePath = filePath;

    try(FileInputStream fis = new FileInputStream(filePath)){
    this.workbook = new XSSFWorkbook(fis);
    }
    this.sheet = workbook.getSheet(sheetName);
    if (sheet == null) {
        workbook.close();
        throw new IllegalArgumentException("Sheet"+sheetName+" Not Found");
    }
    }
    public int findRowIndex(String itemName){
       for(Row row:sheet){ //= all rows in the sheet.
           for (Cell cell:row){
               String cellValue=dataFormatter.formatCellValue(cell).trim();
               if(cellValue.equalsIgnoreCase(itemName)){
                   System.out.println("cellvalue for rowindex = "+cellValue + "and Rownumber is "+row.getRowNum());
                   return row.getRowNum();
               }
           }
       }
       return -1;   //👉 So in short: -1 is returned to indicate “no match found”, making your function predictable and safe to use in larger automation flows.
    }
    public int findColumnIndex(String columnName) {
        Row row = sheet.getRow(0);//// sheet.getRow(0) = one specific row (header row).
        System.out.println("Row is " + row + "Row number = " + row.getRowNum() + " column is = " + columnName);
      if(row != null){
        for (Cell cell : row) {
            String cellValue = dataFormatter.formatCellValue(cell).trim();
            if (cellValue.equalsIgnoreCase(columnName)) {
                System.out.println("Cell index is = " + cell.getColumnIndex() + "and cell value is = " + cellValue);
                return cell.getColumnIndex();
            }
        }
    }
        return -1;
    }
    public boolean updateCellValue(int rowIndex, int columnIndex,String newValue) throws IOException {
     Row row = sheet.getRow(rowIndex);
     if(row == null)row=sheet.createRow(rowIndex);
     Cell cell=row.getCell(columnIndex);
     if(cell==null)cell=row.createCell(columnIndex);
     cell.setCellValue(newValue);
     try(FileOutputStream fos = new FileOutputStream(filePath)){
         workbook.write(fos);
     }
     return true;
    }
    @Override
    public void close() throws IOException {
        workbook.close();
    }

}