package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private EmployeeRepository repository;

	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\DELL\\Desktop\\jasper report";
		List<Employee> employees = repository.findAll();
		// load file and compile it
		File file = ResourceUtils.getFile("classpath:employees.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Aruna");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
		}

		return "report generated in path : " + path;
	}
}