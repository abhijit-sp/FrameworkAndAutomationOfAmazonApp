package framework.utils.datareader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class provides utility methods for reading excel files containing test data.
 */
public class ExcelReader {

    /**
     * This method is used to get a particular excel sheet.
     *
     * @param fileName   String value of the path to the excel file.
     * @param sheetIndex int value of the index of the sheet required
     * @return XSSFSheet An excel sheet containing test data.
     * @throws IOException
     */
    public XSSFSheet getExcelSheet(String fileName, int sheetIndex) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        return workbook.getSheetAt(sheetIndex);
    }
}
