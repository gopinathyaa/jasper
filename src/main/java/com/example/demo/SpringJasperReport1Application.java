package com.example.demo;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class SpringJasperReport1Application {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private ReportService service;

	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {

		return repository.findAll();
	}

	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return service.exportReport(format);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJasperReport1Application.class, args);
	}

}
