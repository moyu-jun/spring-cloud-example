package com.james.example.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by James on 2020/3/26.
 */
@Configuration
public class ActiveMQConfig {
    //如果要使用topic类型的消息，则需要配置该bean
    @Bean
    public JmsListenerContainerFactory<?> jmsTopicListenerContainerFactory(
            @Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true); //这里必须设置为true，false则表示是queue类型
        return factory;
    }


    @Bean
    public Queue queue() {
        return new ActiveMQQueue("springboot.queue");
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic("springboot.topic");
    }

    @Bean
    public Queue queueReply() {
        return new ActiveMQQueue("springboot.queue.reply");
    }
}
