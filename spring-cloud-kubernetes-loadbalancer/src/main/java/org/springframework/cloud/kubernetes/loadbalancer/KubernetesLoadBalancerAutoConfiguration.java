/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.loadbalancer;

import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryProperties;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Piotr Minkowski
 */
@Configuration
@LoadBalancerClients(defaultConfiguration = KubernetesClientConfiguration.class)
public class KubernetesLoadBalancerAutoConfiguration {

	@Bean
	KubernetesLoadBalancerProperties properties() {
		return new KubernetesLoadBalancerProperties();
	}

	@Bean
	KubernetesServiceInstanceMapper mapper(KubernetesLoadBalancerProperties properties,
			KubernetesDiscoveryProperties discoveryProperties) {
		return new KubernetesServiceInstanceMapper(properties, discoveryProperties);
	}

}
