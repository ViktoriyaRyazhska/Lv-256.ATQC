package com.regres.testdata;

import com.regres.testdata.DB.UserDB;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadUsersFromEcxel {
    public List<UserDB> addUserFromEcxelToList(File excelFile, String sheetName) throws IOException {
        List<UserDB> userDBList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = workbook.getSheet(sheetName);
        for (int r = 1; r < sheet.getLastRowNum(); r++) {
            XSSFRow row = sheet.getRow(r);
            userDBList.add(new UserDB(
                    ecxelEnumToStringConverter(row.getCell(0)),
                    ecxelEnumToStringConverter(row.getCell(1)),
                    ecxelEnumToStringConverter(row.getCell(2)),
                    ecxelEnumToStringConverter(row.getCell(3)),
                    ecxelEnumToStringConverter(row.getCell(4)),
                    ecxelEnumToStringConverter(row.getCell(5)),
                    ecxelEnumToStringConverter(row.getCell(6)),
                    ecxelEnumToStringConverter(row.getCell(7)),
                    ecxelEnumToStringConverter(row.getCell(8)),
                    ecxelEnumToStringConverter(row.getCell(9)),
                    ecxelEnumToStringConverter(row.getCell(10)),
                    ecxelEnumToStringConverter(row.getCell(11)),
                    ecxelEnumToStringConverter(row.getCell(12)),
                    ecxelEnumToStringConverter(row.getCell(13)),
                    ecxelEnumToStringConverter(row.getCell(14)),
                    ecxelEnumToStringConverter(row.getCell(15)),
                    ecxelEnumToStringConverter(row.getCell(16)),
                    ecxelEnumToStringConverter(row.getCell(17)),
                    ecxelEnumToStringConverter(row.getCell(18)),
                    ecxelEnumToStringConverter(row.getCell(19))
            ));
        }
        workbook.close();
        return userDBList;
    }

    public String ecxelEnumToStringConverter(XSSFCell cell) {
        String s;
        switch (cell.getCellTypeEnum()) {
            case STRING:
                s = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell))
                    s = cell.getDateCellValue().toString();
                else
                    s = String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                s = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                s = cell.getCellFormula();
                break;
            case BLANK:
                s = "";
                break;
            default:
                s = "";
        }
        return s;
    }
}
