# Tutor Management System (Java EE)

Java EE (Maven) web application for managing a tutoring system with three roles: Manager, Teacher, and Student.
Authentication is configured using Apache TomEE `DataSourceRealm` with an Oracle XE database.

## What it does
- Login for three roles: Manager / Teacher / Student
- Manager can create users for each role
- Roles are stored in `user_mapping_tbl` and used by TomEE Realm during authentication

## Tech
- Java EE (JSP / Servlets)
- Maven
- Oracle Database (XE)
- Apache TomEE Web Profile 9.1.2
- OpenJDK 11

## Prerequisites
- OpenJDK 11
- Oracle XE
- Apache TomEE Web Profile 9.1.2
- Oracle JDBC driver (`ojdbc11.jar`)

## Setup (TomEE + Oracle)
1) Copy `ojdbc11.jar` to:
   - `{tomee_dir}/lib`
   - `src/main/webapp/WEB-INF/lib`

2) Configure datasource in `{tomee_dir}/conf/tomee.xml`:

```xml
<Resource id="jdbc/JtaDataSource" type="javax.sql.DataSource">
  jdbcDriver = oracle.jdbc.driver.OracleDriver
  jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
  username = <your_db_username>
  password = <your_db_password>
  jtaManaged = true
</Resource>
Configure realm in {tomee_dir}/conf/server.xml (example for Student):

<Realm className="org.apache.catalina.realm.DataSourceRealm"
  dataSourceName="jdbc/JtaDataSource"
  userTable="studentEntity"
  userNameCol="u_username"
  userCredCol="u_password"
  userRoleTable="user_mapping_tbl"
  roleNameCol="role"/>
Repeat for teacherEntity and managerEntity if you use separate tables per role.

