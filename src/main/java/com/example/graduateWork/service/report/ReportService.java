package com.example.graduateWork.service.report;

import com.example.graduateWork.entity.Appointment;
import com.example.graduateWork.repository.AppointmentRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    /*
     * Создание Excel-отчета с информацией о всех записях
     */
    public void generateAllExcel(HttpServletResponse response) throws Exception {
        List<Appointment> appointments = appointmentRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Appointment Info");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID записи");
        row.createCell(1).setCellValue("Дата записи");
        row.createCell(2).setCellValue("Дата приема");
        row.createCell(3).setCellValue("Описание");
        row.createCell(4).setCellValue("Врач");
        row.createCell(5).setCellValue("Пациент");
        row.createCell(6).setCellValue("Статус");


        int dataRowIndex = 1;
        for (Appointment appointment : appointments) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(appointment.getIdAppointment());
            dataRow.createCell(1).setCellValue(appointment.getDtRec().toString());
            dataRow.createCell(2).setCellValue(appointment.getDtAp().toString());
            dataRow.createCell(3).setCellValue(appointment.getDescription());
            dataRow.createCell(4).setCellValue(appointment.getUsers_cl().toString());
            dataRow.createCell(5).setCellValue(appointment.getUsers_doc().toString());
            dataRow.createCell(6).setCellValue(appointment.getStatus().toString());

            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }

    /*
     * Создание Excel-отчета с информацией о записях, которые произошли за последний месяц(последние 30 дней)
     */
    public void generateLastMonthReport(HttpServletResponse response) throws Exception {
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysAgo = currentDate.minusDays(30);

        List<Appointment> appointments = appointmentRepository.findByDtRecBetween(
                Date.from(thirtyDaysAgo.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Appointment Report - Last 30 Days");
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID записи");
        headerRow.createCell(1).setCellValue("Дата записи");
        headerRow.createCell(2).setCellValue("Дата приема");
        headerRow.createCell(3).setCellValue("Описание");
        headerRow.createCell(4).setCellValue("Врач");
        headerRow.createCell(5).setCellValue("Пациент");
        headerRow.createCell(6).setCellValue("Статус");
        int dataRowIndex = 1;
        for (Appointment appointment : appointments) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(appointment.getIdAppointment());
            dataRow.createCell(1).setCellValue(appointment.getDtRec().toString());
            dataRow.createCell(2).setCellValue(appointment.getDtAp().toString());
            dataRow.createCell(3).setCellValue(appointment.getDescription());
            dataRow.createCell(4).setCellValue(appointment.getUsers_cl().toString());
            dataRow.createCell(5).setCellValue(appointment.getUsers_doc().toString());
            dataRow.createCell(6).setCellValue(appointment.getStatus().toString());

            dataRowIndex++;
        }

        response.setHeader("Content-Disposition", "attachment; filename=AppointmentReport_Last30Days.xls");
        response.setContentType("application/vnd.ms-excel");

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }

    /*
     * Создание Excel-отчета с информацией о записях, которые произошли за последний год(последние 365 дней)
     */
    public void generateLastYearReport(HttpServletResponse response) throws Exception {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneYearAgo = currentDate.minusYears(1);

        List<Appointment> appointments = appointmentRepository.findByDtRecBetween(
                Date.from(oneYearAgo.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        );

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Appointment Report - Last Year");
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID записи");
        headerRow.createCell(1).setCellValue("Дата записи");
        headerRow.createCell(2).setCellValue("Дата приема");
        headerRow.createCell(3).setCellValue("Описание");
        headerRow.createCell(4).setCellValue("Врач");
        headerRow.createCell(5).setCellValue("Пациент");
        headerRow.createCell(6).setCellValue("Статус");
        int dataRowIndex = 1;
        for (Appointment appointment : appointments) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(appointment.getIdAppointment());
            dataRow.createCell(1).setCellValue(appointment.getDtRec().toString());
            dataRow.createCell(2).setCellValue(appointment.getDtAp().toString());
            dataRow.createCell(3).setCellValue(appointment.getDescription());
            dataRow.createCell(4).setCellValue(appointment.getUsers_cl().toString());
            dataRow.createCell(5).setCellValue(appointment.getUsers_doc().toString());
            dataRow.createCell(6).setCellValue(appointment.getStatus().toString());
            dataRowIndex++;
        }

        response.setHeader("Content-Disposition", "attachment; filename=AppointmentReport_LastYear.xls");
        response.setContentType("application/vnd.ms-excel");

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
}
