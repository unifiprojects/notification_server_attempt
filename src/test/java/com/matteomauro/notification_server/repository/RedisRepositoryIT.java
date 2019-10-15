/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matteomauro.notification_server.repository;

import com.matteomauro.notification_server.model.Topic;
import org.junit.Before;
import org.junit.Test;
import javax.websocket.Session;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author matteo
 */
@RunWith(MockitoJUnitRunner.class)
public class RedisRepositoryIT {

    private RedisRepository repository;

    @Before
    public void setup() {
        repository = new RedisRepository();
    }

    @Test
    public void testWhenOneTopicAndMultipleSessionsArePersisted() {
        Topic topic = new Topic("test1");
        Session session1 = mock(Session.class);
        Session session2 = mock(Session.class);
        repository.insertNotification(topic, session1);
        repository.insertNotification(topic, session2);
        assertThat(repository.getAllSessions(topic)).containsExactly(session1, session2);
    }

}
