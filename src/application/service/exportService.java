package application.service;

import application.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.io.File;

/**
 * Created by ЖЛЗК on 12.06.2017.
 */
public class exportService  {
    public void executeExport(File file, String table)
    {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("COPY(SELECT * from \""+table+"\") TO \'"+file.getAbsolutePath()+"\'(format csv);");
        sqlQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
