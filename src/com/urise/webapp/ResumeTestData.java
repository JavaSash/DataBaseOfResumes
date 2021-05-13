package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume1 = new Resume("Григорий Кислин");
        AbstractSection<String> personal = new TextSection();
        AbstractSection<String> objective = new TextSection();
        AbstractSection<List<String>> achievement = new ListSection();
        AbstractSection<List<String>> qualification = new ListSection();
        AbstractSection<List<Organization>> experience = new OrganizationSection();
        AbstractSection<List<Organization>> education = new OrganizationSection();

        final String personalTxt = "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.";
        final String objectiveTxt = "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям";
        final String jopTxt = "Создание, организация и проведение Java онлайн проектов и стажировок.";
        final String wrikeTxt = "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.";
        final String ritTxt = "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python";
        final String luxoftTxt = "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.";
        final String yotaTxt = "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS).";
        final String enkataTxt = "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).";
        final String siemensTxt = "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).";
        final String alcatelTxt = "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).";

        objective.setInfo(objectiveTxt);
        personal.setInfo(personalTxt);

        achievement.setInfo("С 2013 года: разработка проектов \"Разработка Web приложения\", \"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievement.setInfo("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievement.setInfo("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievement.setInfo("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievement.setInfo("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievement.setInfo("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        qualification.setInfo("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualification.setInfo("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.setInfo("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualification.setInfo("MySQL, SQLite, MS SQL, HSQLDB");
        qualification.setInfo("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualification.setInfo("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualification.setInfo("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualification.setInfo("Python: Django");
        qualification.setInfo("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualification.setInfo("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualification.setInfo("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualification.setInfo("Инструменты: Maven + plugin development, Gradle, настройка Ngnix.");
        qualification.setInfo("Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualification.setInfo("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualification.setInfo("Родной русский, английский \"upper intermediate\"");

        experience.setInfo(new Organization("JavaOnlineProjects", "https://javaops.ru/", "Автор проекта", jopTxt, YearMonth.of(2013, 10), YearMonth.now()));
        experience.setInfo(new Organization("Wrike", "https://www.wrike.com/", "Старший разработчик (backend)", wrikeTxt, YearMonth.of(2014, 10), YearMonth.of(2016, 1)));
        experience.setInfo(new Organization("RIT Center", "", "Java архитектор", ritTxt, YearMonth.of(2012, 4), YearMonth.of(2014, 10)));
        experience.setInfo(new Organization("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/", "Ведущий программист", luxoftTxt, YearMonth.of(2010, 12), YearMonth.of(2012, 4)));
        experience.setInfo(new Organization("Yota", "https://www.yota.ru/", "Ведущий специалист", yotaTxt, YearMonth.of(2008, 6), YearMonth.of(2010, 12)));
        experience.setInfo(new Organization("Enkata", "https://www.pega.com/products/platform/robotic-process-automation", "Разработчик ПО", enkataTxt, YearMonth.of(2007, 3), YearMonth.of(2008, 6)));
        experience.setInfo(new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html", "Разработчик ПО", siemensTxt, YearMonth.of(2005, 1), YearMonth.of(2007, 2)));
        experience.setInfo(new Organization("Alcatel", "http://www.alcatel.ru/", "Инженер по аппаратному и программному тестированию", alcatelTxt, YearMonth.of(1997, 9), YearMonth.of(2005, 1)));

        education.setInfo(new Organization("Coursera", "https://www.coursera.org/course/progfun", "\"Functional Programming Principles in Scala\" by Martin Odersky", YearMonth.of(2013, 3), YearMonth.of(2013, 5)));
        education.setInfo(new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML", YearMonth.of(2011, 3), YearMonth.of(2011, 4)));
        education.setInfo(new Organization("Siemens AG", "http://www.siemens.ru/", "3 месяца обучения мобильным IN сетям (Берлин)", YearMonth.of(2005, 1), YearMonth.of(2005, 4)));
        education.setInfo(new Organization("Alcatel", "http://www.alcatel.ru/", "6 месяцев обучения цифровым телефонным сетям (Москва)", YearMonth.of(1997, 9), YearMonth.of(1998, 3)));
        education.setInfo(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/", "Аспирантура (программист C, C++)", YearMonth.of(1993, 9), YearMonth.of(1996, 7)));
        education.setInfo(new Organization("", "", "Инжнер (программист Fortran, C)", YearMonth.of(1987, 9), YearMonth.of(1993, 7)));
        education.setInfo(new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/", "Закончил с отличием", "", YearMonth.of(1984, 9), YearMonth.of(1987, 6)));

        System.out.println(resume1);

        resume1.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume1.setContact(ContactType.SKYPE, "grigory.kislin");
        resume1.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume1.setContact(ContactType.LINKEDIN, "");
        resume1.setContact(ContactType.GITHUB, "");
        resume1.setContact(ContactType.STACKOVERFLOW, "");
        resume1.setContact(ContactType.HOME_PAGE, "");

        resume1.setSection(SectionType.PERSONAL, personal);
        resume1.setSection(SectionType.OBJECTIVE, objective);
        resume1.setSection(SectionType.ACHIEVEMENT, achievement);
        resume1.setSection(SectionType.QUALIFICATIONS, qualification);
        resume1.setSection(SectionType.EXPERIENCE, experience);
        resume1.setSection(SectionType.EDUCATION, education);

        System.out.println(resume1);

        for (Map.Entry<ContactType, String> entry : resume1.getContacts().entrySet()) {
            System.out.println(entry.getKey().getTitle() + entry.getValue());
        }

        for(Map.Entry<SectionType, AbstractSection<?>> entry : resume1.getSections().entrySet()) {
            System.out.println(entry.getKey().getTitle() + "\n" + entry.getValue());
        }
    }
}
