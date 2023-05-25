package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.BranchBean;
import com.example.demo.bean.City;
import com.example.demo.bean.Country;
import com.example.demo.bean.Location;
import com.example.demo.bean.State;
import com.example.demo.dao.BranchDao;
@Service
public class BranchService {
@Autowired
	private BranchDao bdao;
	public String addBranch(BranchBean branchBean) 
	{
		return bdao.addBranch(branchBean);
	}
	public ArrayList<BranchBean> viewBranch()
	{
		return bdao.viewBranch();
	}
	public String updateBranch(BranchBean branchBean)
	{
		return bdao.updateBranch(branchBean);
	}
	public BranchBean viewBranchById(int branchID)
	{
		return bdao.viewBranchById(branchID);
	}
	 public BranchBean viewBranchByBranchcode(String branchcode)
		{
		 return bdao.viewBranchByBranchcode(branchcode);
		}
	 
	 
	 
	 
	 public  List<Country> getCountry(){
         return bdao.getCountry();
     }
  
  public ArrayList<State> getStateBycountryid(String countryid) {
      return bdao.getStateBycountryid(countryid);
  }
  
  public ArrayList<City> getCityBystateid(String stateid) {
      return bdao.getCityBystateid(stateid);
  }
  
  public ArrayList<Location> getLocationBycityid(String cityid) {
      return bdao.getLocationBycityid(cityid);
  }
  
  public String addCountry(Country country) {
         return bdao.addCountry(country);

 }
  public String addState(State state) {
         return bdao.addState(state);

 }
  public String addCity(City city) {
         return bdao.addCity(city);

 }
  public String addLocation(Location location) {
         return bdao.addLocation(location);

 }
  public Location viewlocationbyId(String locationid) {
      return bdao.viewlocationbyId(locationid);
  }
  public boolean modifyCountry(Country country) {
         return bdao.modifyCountry(country);
     }
  public boolean modifyState(State state) {
         return bdao.modifyState(state);
     }
  public boolean modifyCity(City city) {
         return bdao.modifyCity ( city);
     }
  public boolean modifyLocation(Location location) {
         return bdao.modifyLocation( location);
     }
  public Country ViewCountrybyid(String countryid) {
        return bdao.viewCountrybyId(countryid);
  }
  public State viewStatebyId(String stateid) {
        return bdao.viewStatebyId(stateid);
  }
  public City viewCitybyId(String cityid) {
        return bdao.viewCitybyId(cityid);
  }
 
}
