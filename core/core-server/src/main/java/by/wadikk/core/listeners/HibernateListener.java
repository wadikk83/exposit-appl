package by.wadikk.core.listeners;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Service
public class HibernateListener {

    private final EntityManagerFactory entityManagerFactory;

    private DeleteEventListenerClass deleteEventListenerClass;

    @Autowired
    public HibernateListener(EntityManagerFactory entityManagerFactory, DeleteEventListenerClass deleteEventListenerClass) {
        this.entityManagerFactory = entityManagerFactory;
        this.deleteEventListenerClass = deleteEventListenerClass;
    }

    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(deleteEventListenerClass);
    }
}
