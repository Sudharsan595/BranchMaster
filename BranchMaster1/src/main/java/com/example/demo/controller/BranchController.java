package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BranchService;
import com.example.demo.bean.BranchBean;
import com.example.demo.bean.City;
import com.example.demo.bean.Country;
import com.example.demo.bean.Location;
import com.example.demo.bean.State;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class BranchController {
@Autowired
private BranchService bserv;
	@PostMapping("/addbranch")
	public String meth1(@RequestBody BranchBean bb)
	{
		return bserv.addBranch(bb);
	
	}
	@GetMapping("/viewallbranch")
	public List<BranchBean> meth2()
	{
		
		return bserv.viewBranch();
	}
	
	@PutMapping("/updatebranch")
	public String meth3(@RequestBody BranchBean bb)
	{
		bserv.updateBranch(bb);
		return "<h1> Branch Updated successfully</h1>";
	}
	@GetMapping("/branch/{id}")
	public BranchBean meth4(@PathVariable(value = "id") int branchID)
	{
		return bserv.viewBranchById(branchID);
		
	}
	
	@GetMapping("/branchcode/{id}")
	public BranchBean meth5(@PathVariable(value = "id") String branchcode)
	{
		return bserv.viewBranchByBranchcode(branchcode);
		
	}
	
	
	 @GetMapping("/viewcountry")
	    public List<Country>  getCountry()
	    {
	        
	        return bserv. getCountry();
	    }
	    
	    @GetMapping("/statebyid/{id}")
	    public List<State> getStateBycountryid(@PathVariable(value = "id") String countryid)
	    {
	        
	        return bserv.getStateBycountryid(countryid);
	    }
	    
	    @GetMapping("/citybyid/{id}")
	    public List<City>  getCityBystateid(@PathVariable(value = "id") String stateid)
	    {
	        
	        return bserv.getCityBystateid(stateid);
	    }
	    @GetMapping("/locationbyid/{id}")
	    public List<Location>  getLocationBycityid(@PathVariable(value = "id") String cityid)
	    {
	        
	        return bserv.getLocationBycityid(cityid);
	    }

	    @PostMapping("/addCountry")
	    public String addCountry(@RequestBody Country country) {
	        System.out.println( country);
	        return bserv.addCountry( country);
	    }
	    
	    @PostMapping("/addState")
	    public String addState(@RequestBody State state) {
	        System.out.println( state);
	        return bserv.addState( state);
	    }
	    
	    @PostMapping("/addCity")
	    public String addCity(@RequestBody City city) {
	        System.out.println( city);
	        return bserv.addCity( city);
	    }
	    
	    
	    @PostMapping("/addLocation")
	    public String addLocation(@RequestBody Location location) {
	        System.out.println( location);
	        return bserv.addLocation( location);
	    }
	    @GetMapping("/locationbylocationid/{code}")
	    public Location viewlocationbyId(@PathVariable(value = "code") String locationid)
	    {
	        
	        return bserv.viewlocationbyId(locationid);
	    }
	    @PutMapping("/updateCountry")
	    public boolean modifyCountry(@RequestBody Country country) {
	        return bserv.modifyCountry(country);
	    }
	    @PutMapping("/updateState")
	    public boolean modifyState(@RequestBody State state) {
	        return bserv.modifyState(state);
	    }
	    @PutMapping("/updateCity")
	    public boolean modifyCity(@RequestBody City city) {
	        return bserv.modifyCity(city);
	    }
	    @PutMapping("/updateLocation")
	    public boolean modifyLocation(@RequestBody Location location) {
	        return bserv.modifyLocation(location);
	    }
	    @GetMapping("/viewCountrybyid/{countryid}")
	    public Country ViewCountrybyId(@PathVariable(value = "countryid") String countryid) {
	        return bserv.ViewCountrybyid(countryid);
	    }
	    
	    @GetMapping("/viewStatebyid/{stateid}")
	    public State viewStatebyId(@PathVariable(value = "stateid") String stateid) {
	        return bserv.viewStatebyId(stateid);
	    }
	    @GetMapping("/viewCitybyid/{cityid}")
	    public City viewCitybyId(@PathVariable(value = "cityid") String cityid) {
	        return bserv.viewCitybyId(cityid);
	    }
	    @GetMapping("/viewLocationbyid/{locationid}")
	    public Location viewLocationbyId(@PathVariable(value = "locationid") String locationid) {
	        return bserv.viewlocationbyId(locationid);
	    }
}
