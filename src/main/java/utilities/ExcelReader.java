package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

	private Workbook workbook;

	// Constructor to load Excel file
	public ExcelReader(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));
		this.workbook = WorkbookFactory.create(file);
	}

	// Method to read data from a specific sheet
	public List<Map<String, String>> getTestData(String sheetName) {
		List<Map<String, String>> testDataAllRows = new ArrayList<>();
		Sheet sheet = workbook.getSheet(sheetName);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row (i=1)
			Row row = sheet.getRow(i);
			Map<String, String> dataMap = new HashMap<>();

			dataMap.put("TestCaseId", row.getCell(0).getStringCellValue());
			dataMap.put("Keyword", row.getCell(1).getStringCellValue());
			dataMap.put("LocatorType", row.getCell(2).getStringCellValue());
			dataMap.put("LocatorValue", row.getCell(3).getStringCellValue());
			dataMap.put("TestData", row.getCell(4).getStringCellValue());

			testDataAllRows.add(dataMap);
		}
		return testDataAllRows;
	}

	// Method to close the workbook
	public void close() throws IOException {
		workbook.close();
	}
}
