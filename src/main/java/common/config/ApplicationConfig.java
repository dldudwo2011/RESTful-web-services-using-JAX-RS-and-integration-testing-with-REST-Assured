package common.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.enterprise.context.ApplicationScoped;

@DataSourceDefinitions({

	@DataSourceDefinition(
		name="java:app/datasources/h2databaseDS",
		className="org.h2.jdbcx.JdbcDataSource",
		url="jdbc:h2:file:~/jdk/databases/YOUNGJAELEE_H2DATABASEDS",
//		url="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
		user="user2015",
		password="Password2015"),
//
//	@DataSourceDefinition(
//		name="java:app/datasources/hsqldatabaseDS",
//		className="org.hsqldb.jdbc.JDBCDataSource",
////		url="jdbc:hsqldb:file:~/jdk/databases/dmit2015-hsqldb-demos;shutdown=true",
//		url="jdbc:hsqldb:mem:dmit2015hsqldb",
//		user="user2015",
//		password="Password2015"),

//        @DataSourceDefinition(
//                name = "java:app/datasources/mssqlDS",
//                className = "com.microsoft.sqlserver.jdbc.SQLServerDataSource",
//                url = "jdbc:sqlserver://localhost;databaseName=DMIT2015_1212_CourseDB;TrustServerCertificate=true",
//                user = "user2015",
//                password = "Password2015"),

//	@DataSourceDefinition(
//		name="java:app/datasources/oracleUser2015DS",
//		className="oracle.jdbc.pool.OracleDataSource",
//		url="jdbc:oracle:thin:@192.168.101.201:1521/xepdb1",
//		user="user2015",
//		password="Password2015"),

//	@DataSourceDefinition(
//		name="java:app/datasources/oracleHrDS",
//		className="oracle.jdbc.pool.OracleDataSource",
//		url="jdbc:oracle:thin:@192.168.101.201:11521/xepdb1",
//		user="hr",
//		password="Password2015"),
//
//	@DataSourceDefinition(
//			name="java:app/datasources/oracleOeDS",
//			className="oracle.jdbc.pool.OracleDataSource",
//			url="jdbc:oracle:thin:@192.168.101.201:11521/xepdb1",
//			user="oe",
//			password="Password2015"),

//	@DataSourceDefinition(
//		name="java:app/datasources/mysqlDS",
//		className="com.mysql.cj.jdbc.MysqlDataSource",
//		url="jdbc:mysql://192.168.101.201/dmit2015-mysql-db",
//		user="user2015",
//		password="Password2015"),

//	@DataSourceDefinition(
//		name="java:app/datasources/mariadbDS",
//		className="org.mariadb.jdbc.MariaDbDataSource",
//		url="jdbc:mariadb://192.168.101.129:13306/dmit2015-mariadb-db",
//		user="user2015",
//		password="Password2015"),

//	@DataSourceDefinition(
//		name="java:app/datasources/postgresqlDS",
//		className="org.postgresql.ds.PGPoolingDataSource",
//		url="jdbc:postgresql://192.168.101.201/dmit2015-postgres-db",
//		user="user2015",
//		password="Password2015"),

})

@ApplicationScoped
public class ApplicationConfig {

}
    