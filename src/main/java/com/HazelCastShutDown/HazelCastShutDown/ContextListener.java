package com.HazelCastShutDown.HazelCastShutDown;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class ContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent) {
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("ServletContextListener destroyed");
		
		Config config = new Config("my-test-instance");
		HazelcastInstance existingHazelcastInstance = Hazelcast
				.newHazelcastInstance(config);
		existingHazelcastInstance.shutdown();
	}
}
