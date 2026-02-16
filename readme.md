tutor System

    - Under Development

    - Requirement :
        
        - Oracle database
        - install OpenJDK 11

- make a root directory in drive C
- download apache-tomee-webprofile-9.1.2 
- put the tomEE file in the root directory
- copy ojdbc11 driver in webapp/WEB-INF/lib @ {tomee_dir}/lib

  - setup resource in {tomee_dir}/conf/tomee.xml (jta)

          <Resource id = "jdbc/JtaDataSource" type = "javax.sql.DataSource">
          jdbcDriver = oracle.jdbc.driver.OracleDriver
          jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
          username = javaee
          password = java123
          jtaManaged = true
          maxIdle = 20
          minIdle = 5
          maxWait = 10000
          </Resource>
          <Resource id = "jdbc/NonJtaDataSource" type = "javax.sql.DataSource">
          jdbcDriver = oracle.jdbc.driver.OracleDriver
          jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
          username = javaee
          password = java123
          jtaManaged = false
          maxIdle = 20
          minIdle = 5
          maxWait = 10000
          </Resource>
    - setup realm in {tomee_dir}/conf/server.xml

          <Realm className="org.apache.catalina.realm.DataSourceRealm"
           dataSourceName="jdbc/JtaDataSource"
           userTable="studentEntity"
           userNameCol="u_username"
           userCredCol="u_password"
            userRoleTable="user_mapping_tbl"
              roleNameCol="role"/>
              <Realm className="org.apache.catalina.realm.DataSourceRealm"
            dataSourceName="jdbc/JtaDataSource"
            userTable="teacherEntity"
             userNameCol="u_username"
             userCredCol="u_password"
            userRoleTable="user_mapping_tbl"
            roleNameCol="role"/>

             <Realm className="org.apache.catalina.realm.DataSourceRealm"
             dataSourceName="jdbc/JtaDataSource"
             userTable="managerEntity"
             userNameCol="u_username"
             userCredCol="u_password"
             userRoleTable="user_mapping_tbl"
             roleNameCol="role"/>  

- UserMapping is a class with a table that save username and role of each user and I use it to login with realm

- There are three different types of clients in this system
  - Manager
  - Teacher
  - Student

- when you log in az manager you can make new client for each role
