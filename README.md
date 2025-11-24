# Excel File Download, Edit, and Upload Automation Framework 📊🚀

[![Build Status](https://github.com/usmanbasharmal123/ExcelFile-Download-Edit-and-Upload/actions/workflows/ci.yml/badge.svg)](https://github.com/usmanbasharmal123/ExcelFile-Download-Edit-and-Upload/actions)
[![Coverage Status](https://img.shields.io/badge/coverage-85%25-yellowgreen)](reports/)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue)](https://www.linkedin.com/in/basharmal-safi-l/)
[![GitHub](https://img.shields.io/badge/GitHub-Portfolio-black)](https://github.com/usmanbasharmal123)

---

## 📖 Overview
This repository demonstrates a **QA automation framework** focused on **Excel file handling** (download, edit, upload) combined with **UI automation** using **Java, Selenium, TestNG, and Maven**.  
It showcases **data-driven testing**, **CI/CD integration**, and **professional documentation** for scalable QA solutions.

---

## 🛠️ Tech Stack
- **Language**: Java  
- **Frameworks**: Selenium, TestNG  
- **Build Tool**: Maven  
- **CI/CD**: GitHub Actions / Jenkins  
- **Utilities**: Apache POI (Excel), Dynamic XPath strategies  
- **Reporting**: ExtentReports / Allure  
---
ExcelFile-Download-Edit-and-Upload/ ├── src/ │ ├── test/java │ │ ├── base/ # Driver setup & teardown │ │ ├── tests/ # UI + Excel test cases │ │ ├── utilities/ # ExcelUtils, ConfigReader, DynamicXPath │ └── main/resources # Configs & test data ├── reports/ # Auto-generated test reports ├── ci-cd/ # Jenkinsfile / GitHub Actions workflows ├── docs/ # Documentation & onboarding guides ├── pom.xml └── README.md

---

---

## ✅ Features
- Download Excel files from web applications  
- Edit Excel files using **Apache POI** utilities  
- Upload modified files back into the application  
- Cross-browser execution (Chrome, Firefox, Edge)  
- Data-driven testing with Excel utilities  
- CI/CD pipeline integration  
- Rich HTML reporting with screenshots  
- Modular, reusable framework design  

---

## 🚀 Getting Started
1. Clone the repo:  
   ```bash
   git clone https://github.com/usmanbasharmal123/ExcelFile-Download-Edit-and-Upload.git
   
2.Install dependencies:  mvn clean install
3.Run Test:  mvn test

📊 Sample Reports
Screenshots of ExtentReports and Allure Reports are included in the reports/ folder. Recruiters can preview test execution results without running the framework.

## UI Test Example

 ```@Test
   public void loginTest() {
       driver.get("https://example.com/login");
       driver.findElement(By.id("username")).sendKeys("user");
       driver.findElement(By.id("password")).sendKeys("pass");
       driver.findElement(By.id("login")).click();
       Assert.assertTrue(driver.getTitle().contains("Dashboard"));
   }

## Excel Utility Example
 ```@Test
   public void excelReadTest() {
       ExcelUtils excel = new ExcelUtils("testdata.xlsx");
       String value = excel.getCellData("LoginData", "Username", 1);
       Assert.assertEquals(value, "testuser");
   }


📘 Documentation
Framework Overview

Troubleshooting Guide

Contribution Guide

🔮 Future Enhancements
API testing with Postman / REST Assured

Dockerized test execution

Selenium Grid for parallel cross-browser testing

Performance testing with JMeter

AI-driven test case generation

👨‍💻 Author
Usman (Basharmal Safi)

QA Automation Engineer | Java + Selenium | CI/CD | API Testing

LinkedIn Profile

GitHub Portfolio

🌟 Recruiter Highlights
Demonstrates real-world automation skills with CI/CD integration.

Includes professional documentation for team onboarding.

Showcases Excel utilities, UI automation, and reporting in one framework.



## 📂 Project Structure
