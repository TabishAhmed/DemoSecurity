package com.rc.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rc.demo.city.City;
import com.rc.demo.city.CityRepository;

@RestController
@RequestMapping("/test")
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private CityRepository cityService;
	
	@GetMapping("/showName")
	String getName() {
		log.info("Get request received with url '/test/showName'");
		return "Demo Controller";
	}
	
	@GetMapping("/showCities")
	List<City> getCitiesByCountryCode(@RequestParam("code") final String code) {
		return cityService.findByCountryCode(code);
	}
	
	@RequestMapping("/showParamNames")
	String getName(@RequestParam("name") final String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(path="/abc/{numericId: \\d+}/abc", method=RequestMethod.GET)
	String getNameOf(@PathVariable("numericId") Long name) {
		return "Hello " + name;
	}
	
	@RequestMapping(path="/abc/{numericId : (true)|(false)}/abc", method=RequestMethod.GET)
	String getNameFor(@PathVariable("numericId") Boolean name) {
		return "Hello " + name;
	}
	
	@PostMapping("/showName")
	String postExample() {
		return "postExample";
	}
	
	@PostMapping("/showName1")
	String postExample1(@RequestBody Product product) {
		return "postExample with post params : " + product.getName() + " and " + product.getDescription();
	}
	
//	@RequestMapping(value="/upload", method=RequestMethod.POST)	
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//            @RequestBody Product product) {
//		
//		return file.getSize() > 0 ? "success : " + product.toString() : "failure";
//    }
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
    public String handleFileUpload(@RequestPart("product") final Product product, final MultipartFile file) {
		
		return file.getSize() > 0 ? "success : "  + product.getName() : "failure";
	}
}
