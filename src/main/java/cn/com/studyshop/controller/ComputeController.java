package cn.com.studyshop.controller;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

	private Logger logger = LoggerFactory.getLogger(ComputeController.class);

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		client.getServices().forEach(o -> System.out.println(o));

		// return discoveryClient.getInstances(s).get(0).getUri().toString();

		try {
			System.out.println(client.getInstances("compute-service").get(0).getUri().toURL().toString());

			logger.debug("service url:->{}", client.getInstances("compute-service").get(0).getUri().toURL());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// client.getInstances(serviceId)
		Integer r = a + b;
		logger.info("/add  result:{}", r);
		return r;
	}
}
