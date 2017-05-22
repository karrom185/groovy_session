package db

import groovy.sql.Sql

class SqlConnectionFactory {

    static withNewInstance(Closure sqlCode){
        def sql = Sql.newInstance("jdbc:h2:gallery", "sa", "sa", "org.h2.Driver")
        def result = sqlCode sql
        sql.close()
        result
    }

}
