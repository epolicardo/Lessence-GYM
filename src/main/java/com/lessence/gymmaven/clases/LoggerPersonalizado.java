/*
 * Copyright 2017 Emiliano.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lessence.gymmaven.clases;

import java.awt.Event;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Emiliano
 */
public class LoggerPersonalizado {
//
//    private final static Logger log = Logger.getLogger(LoggerPersonalizado.class);
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        BasicConfigurator.configure();
//        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
//        new LoggerPersonalizado();
//    }
//
//    public LoggerPersonalizado() {
//        createAndStoreEvent("El Event", new Date());
//        listEvents();
//        HibernateUtil.getSessionFactory().close();
//    }
//
//    private Long createAndStoreEvent(String title, Date theDate) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Event theEvent = new Event();
//        theEvent.setTitle(title);
//        theEvent.setDate(theDate);
//        session.save(theEvent);
//        session.getTransaction().commit();
//        log.info("Insertado: " + theEvent);
//        return theEvent.getId();
//    }
//
//    private List<Event> listEvents() {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        List<Event> result = (List<Event>) session.createQuery("from Event").list();
//        session.getTransaction().commit();
//        for (Event evento : result) {
//            log.info("Leido: " + evento);
//        }
//        return result;
//    }
//


}
