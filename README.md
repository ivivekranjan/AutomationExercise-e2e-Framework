# 🧪 AutomationExercise E2E Selenium Test Framework

This is a TestNG-based End-to-End automation framework designed for [AutomationExercise.com](https://automationexercise.com/).  
Built using Selenium WebDriver, TestNG, and Maven following the Page Object Model (POM) design pattern.

---

## ✅ Features

- POM Design Pattern
- Selenium WebDriver with TestNG
- Page-wise reusable methods
- Utility classes for Waits and Config
- Organized folder structure
src/
├── main/
│ └── java/
│ ├── pages/
│ │ ├── LoginPage.java
│ │ ├── CartPage.java
│ │ ├── OrderPage.java
│ │ ├── LogoutPage.java
│ │ └── BasePage.java
│ └── utils/
│ ├── ConfigReader.java
│ ├── Constants.java
│ └── WaitUtils.java
├── test/
│ └── java/
│ ├── tests/
│ │ ├── LoginTest.java
│ │ ├── CartTest.java
│ │ ├── OrderTest.java
│ │ └── LogoutTest.java
│ └── BaseTest.java
├── testng.xml
├── pom.xml
└── README.md

📌 Author
Vivek Ranjan
Functional Tester | Learning Automation | Passionate about Test Engineering
