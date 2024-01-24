package commonLibs.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDriver {
  private Workbook excelWorkbook;

  public void openWorkbook(String excelFilename) throws Exception {
    excelFilename = excelFilename.trim();
    File file = new File(excelFilename);
    if (!file.exists()) {
      throw new Exception("File does not exist");
    }

    excelWorkbook = WorkbookFactory.create(file, null, true);
  }

  public int getRowCount(String sheetname) throws Exception {
    sheetname = sheetname.trim();
    Sheet sheet = excelWorkbook.getSheet(sheetname);
    if (sheet == null) {
      throw new Exception("Invalid sheet name");
    }
    return sheet.getLastRowNum();  // row = Already 0-index-based
  }

  public int getCellCountFromARow(String sheetname, int rowNumber) throws Exception {
    sheetname = sheetname.trim();
    Sheet sheet = excelWorkbook.getSheet(sheetname);
    if (sheet == null) {
      throw new Exception("Invalid sheet name");
    }
    if (rowNumber < 0) {
      throw new Exception("Invalid row number");
    }

    Row row = sheet.getRow(rowNumber);
    if (row == null) {
      return -1;
    } else {
      return row.getLastCellNum() - 1;  // column = Make 0-index-based
    }
  }

  public String getCellData(String sheetname, int rowNumber, int cellNumber) throws Exception {
    sheetname = sheetname.trim();
    Sheet sheet = excelWorkbook.getSheet(sheetname);
    if (sheet == null) {
      throw new Exception("Invalid sheet name");
    }
    if (rowNumber < 0 || cellNumber < 0) {
      throw new Exception("Invalid row or cell number");
    }

    Row row = sheet.getRow(rowNumber);
    if (row == null) {
      return "";
    }

    Cell cell = row.getCell(cellNumber);
    if (cell == null) {
      return "";
    } else {
      if (cell.getCellType() == CellType.NUMERIC) {
        return String.valueOf(cell.getNumericCellValue());
      } else {
        return cell.getStringCellValue();
      }
    }
  }
  
  public void closeWorkbook() throws IOException {
    excelWorkbook.close();
  }
}
