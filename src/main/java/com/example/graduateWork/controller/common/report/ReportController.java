package com.example.graduateWork.controller.common.report;

import com.example.graduateWork.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    //полный отчет
    @GetMapping("/generateAllExcel")
    public void generateExcelReport(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=AppointmentReport.xls");
            reportService.generateAllExcel(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //отчет за месяц
    @GetMapping("/generateLastMonthReport")
    public void generateLastMonthReport(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=AppointmentReport_LastMonth.xls");
            reportService.generateLastMonthReport(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //отчет за год
    @GetMapping("/generateLastYearReport")
    public void generateLastYearReport(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=AppointmentReport_LastYear.xls");
            reportService.generateLastYearReport(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
