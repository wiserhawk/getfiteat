package com.indhawk.api.gateway.food;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.indhawk.api.gateway.ServiceNavigationHelper;

@Component("foodServiceNavigationHelper")
public class FoodServiceNavigationHelper implements ServiceNavigationHelper{
	
	@Value("${app.food.service.host}")
	private String appFoodServiceHost;
	
	@Value("${app.food.service.port}")
	private String appFoodServicePort;

	@Override
	public String getServiceDomainName() {
		StringBuilder builder = new StringBuilder();
		builder.append(appFoodServiceHost);
		builder.append(":");
		builder.append(appFoodServicePort);
		return builder.toString();
	}
	
}
