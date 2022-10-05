package com.team.prj.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.prj.admin.service.ProfitService;

@Controller
public class ProfitController {
	@Autowired
	private ProfitService ps;

	// 매출 조회
	@GetMapping("/manager/profit")
	public String salesCheck(Model model) {
		String start = null;
		String end = null;
		String key = null;
		model.addAttribute("profitList", ps.profitList(start, end));
		// Map map = ps.monthlyList(key);
		List<Map<String, Object>> d = ps.dailyList(start);
		List<Map<String, Object>> w = ps.weeklyList(start);
		List<Map<String, Object>> m = ps.monthlyList(start);

		model.addAttribute("dailyList", d);
		model.addAttribute("weeklyList", w);
		model.addAttribute("monthlyList", m);

		return "admin/profit";
	}

	@RequestMapping("/exelDownload")
	public void excelDownload(HttpServletResponse response, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws IOException {
//        Workbook wb = new HSSFWorkbook();
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("첫번째 시트");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("번호");
		cell = row.createCell(1);
		cell.setCellValue("정산일자");
		cell = row.createCell(2);
		cell.setCellValue("거래일자");
		cell = row.createCell(3);
		cell.setCellValue("구매자");
		cell = row.createCell(4);
		cell.setCellValue("판매자");
		cell = row.createCell(5);
		cell.setCellValue("거래품목");
		cell = row.createCell(6);
		cell.setCellValue("거래품명");
		cell = row.createCell(7);
		cell.setCellValue("거래금액");
		cell = row.createCell(8);
		cell.setCellValue("정산금액");
		cell = row.createCell(9);
		cell.setCellValue("매출");

		// Body
		for (int i = 1; i < 3; i++) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellValue(i + "_name");
			cell = row.createCell(2);
			cell.setCellValue(i + "_title");
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
//        response.setHeader("Content-Disposition", "attachment;filename=example.xls");
		response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}
}
