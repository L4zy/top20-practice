import org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsAnnotationConfiguration

dataSource {
    pooled = true
    jmxExport = true
    configClass = GrailsAnnotationConfiguration.class
   	pooled = false
   	driverClassName = "com.mysql.jdbc.Driver"
   	username = "root"
   	password =  ""
   	dialect = "org.hibernate.dialect.MySQL5Dialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
 //   singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost/top20?useUnicode=yes&characterEncoding=UTF-8"
        }
    }
}
