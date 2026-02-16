```md
# Tutor Management System (Java EE)

A Maven-based Java EE web application for managing tutoring services with role-based access control.

The system supports three user roles: **Manager**, **Teacher**, and **Student**, with authentication handled through Apache TomEE DataSourceRealm and an Oracle database backend.

---

## 🚀 Features

- Role-based authentication (Manager / Teacher / Student)
- Manager can create new users for each role
- User-role mapping stored in `user_mapping_tbl`
- Database-backed authentication using TomEE Realm
- Maven project structure

---

## 🛠 Tech Stack

- Java EE (JSP / Servlets)
- Maven
- Oracle Database (XE)
- Apache TomEE Web Profile 9.1.2
- OpenJDK 11

---

## 📦 Requirements

- OpenJDK 11
- Oracle Database (XE)
- Apache TomEE Web Profile 9.1.2
- Oracle JDBC Driver (`ojdbc11.jar`)

---

## ⚙️ Setup

### 1) Add JDBC Driver

Copy `ojdbc11.jar` into:

```

{tomee_dir}/lib
src/main/webapp/WEB-INF/lib

```

---

### 2) Configure DataSource

Edit:

```

{tomee_dir}/conf/tomee.xml

````

Add:

```xml
<Resource id="jdbc/JtaDataSource" type="javax.sql.DataSource">
  jdbcDriver = oracle.jdbc.driver.OracleDriver
  jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
  username = <your_db_username>
  password = <your_db_password>
  jtaManaged = true
</Resource>
````

---

### 3) Configure Realm

Edit:

```
{tomee_dir}/conf/server.xml
```

Add:

```xml
<Realm className="org.apache.catalina.realm.DataSourceRealm"
  dataSourceName="jdbc/JtaDataSource"
  userTable="studentEntity"
  userNameCol="u_username"
  userCredCol="u_password"
  userRoleTable="user_mapping_tbl"
  roleNameCol="role"/>
```

(Repeat for `teacherEntity` and `managerEntity` if needed.)

---

## 👥 User Roles

* **Manager**

  * Can create new users for each role

* **Teacher**

  * Access teacher-related features

* **Student**

  * Access student-related features

---

## 📝 Notes

* This project is for educational purposes.
* The `user_mapping_tbl` table stores user-role mappings for authentication.

---

## 👩‍💻 Author

Fatemeh Khalvandi

```
```
