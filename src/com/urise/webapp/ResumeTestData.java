package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Organization;
import com.urise.webapp.model.Resume;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume1 = new Resume("Григорий Кислин");

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


        List<String> achievements = new ArrayList<>();
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\", \"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle");
        qualifications.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix.");
        qualifications.add("Администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");

        List<Organization> orgExp = new ArrayList<>();
        Organization javaOnlineProjects = new Organization("JavaOnlineProjects", "Автор проекта", jopTxt, YearMonth.of(2013, 10), YearMonth.now());
        Organization wrike = new Organization("Wrike", "Старший разработчик (backend)", wrikeTxt, YearMonth.of(2014, 10), YearMonth.of(2016, 1));
        Organization ritCenter = new Organization("RIT Center", "Java архитектор", ritTxt, YearMonth.of(2012, 4), YearMonth.of(2014, 10));
        Organization luxoftExp = new Organization("Luxoft (Deutsche Bank)", "Ведущий программист", luxoftTxt, YearMonth.of(2010, 12), YearMonth.of(2012, 4));
        Organization yota = new Organization("Yota", "Ведущий специалист", yotaTxt, YearMonth.of(2008, 6), YearMonth.of(2010, 12));
        Organization enkata = new Organization("Enkata", "Разработчик ПО", enkataTxt, YearMonth.of(2007, 3), YearMonth.of(2008, 6));
        Organization siemensExp = new Organization("Siemens AG", "Разработчик ПО", siemensTxt, YearMonth.of(2005, 1), YearMonth.of(2007, 2));
        Organization alcatelExp = new Organization("Alcatel", "Инженер по аппаратному и программному тестированию", alcatelTxt, YearMonth.of(1997, 9), YearMonth.of(2005, 1));
        orgExp.add(javaOnlineProjects);
        orgExp.add(wrike);
        orgExp.add(ritCenter);
        orgExp.add(luxoftExp);
        orgExp.add(yota);
        orgExp.add(enkata);
        orgExp.add(siemensExp);
        orgExp.add(alcatelExp);

        List<Organization> orgEduc = new ArrayList<>();
        Organization coursera = new Organization("Coursera", "\"Functional Programming Principles in Scala\" by Martin Odersky", YearMonth.of(2013,03), YearMonth.of(2013,05));
        Organization luxoftEduc = new Organization("Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML", YearMonth.of(2011,03), YearMonth.of(2011,04));
        Organization siemensEduc = new Organization("Siemens AG", "3 месяца обучения мобильным IN сетям (Берлин)", YearMonth.of(2005,01), YearMonth.of(2005,04));
        Organization alcatelEduc = new Organization("Alcatel", "6 месяцев обучения цифровым телефонным сетям (Москва)", YearMonth.of(1997,9), YearMonth.of(1998,03));
        Organization university = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "Аспирантура (программист C, C++)", YearMonth.of(1993,9),YearMonth.of(1996, 07));
        Organization university2 = new Organization("", "Инжнер (программист Fortran, C)", YearMonth.of(1987, 9), YearMonth.of(1993,07));
        Organization school = new Organization("Заочная физико-техническая школа при МФТИ", "Закончил с отличием", YearMonth.of(1984, 9), YearMonth.of(1987, 06));
        orgEduc.add(coursera);
        orgEduc.add(luxoftEduc);
        orgEduc.add(siemensEduc);
        orgEduc.add(alcatelEduc);
        orgEduc.add(university);
        orgEduc.add(university2);
        orgEduc.add(school);

        System.out.println(resume1);
        resume1.getObjective().setInfo(objectiveTxt);
        resume1.getPersonal().setInfo(personalTxt);

        for (String str : achievements) {
            resume1.getAchievement().setInfo(str);
        }

        for (String str : qualifications) {
            resume1.getQualification().setInfo(str);
        }

        for (Organization org : orgExp) {
            resume1.getExperience().setInfo(org);
        }

        for (Organization org : orgEduc) {
            resume1.getEducation().setInfo(org);
        }

        resume1.setContacts(ContactType.PHONE, "+7(921) 855-0482");
        resume1.setContacts(ContactType.SKYPE, "grigory.kislin");
        resume1.setContacts(ContactType.EMAIL, "gkislin@yandex.ru");
        resume1.setContacts(ContactType.LINKEDIN, "");
        resume1.setContacts(ContactType.GITHUB, "");
        resume1.setContacts(ContactType.STACKOVERFLOW, "");
        resume1.setContacts(ContactType.HOME_PAGE, "");
        System.out.println(resume1);

    }
}
