package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.BranchBean;
import com.example.demo.bean.City;
import com.example.demo.bean.Country;
import com.example.demo.bean.Location;
import com.example.demo.bean.State;

@Repository
public class BranchDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Query q;
	private Object locationid;


 

	public String addBranch(BranchBean branchBean) 
	{
	    if(branchBean == null) {
	        return "ERROR";
	    }

	    session = sessionFactory.openSession();
	    transaction = session.beginTransaction();

	    // Check if a branch with the same code already exists
	    Query query = session.createQuery("from BranchBean where branchcode = :branchcode");
	    query.setParameter("branchcode", branchBean.getBranchcode());
	    BranchBean existingBranch = (BranchBean) query.uniqueResult();

	    if(existingBranch != null) {
	        // A branch with the same code already exists
	        transaction.rollback();
	        session.close();
	        return "DUPLICATE";
	    }

	    // No branch with the same code exists, save the new branch
	    session.save(branchBean);
	    transaction.commit();
	    session.close();
	    return "SUCCESS";
	}



	public String updateBranch(BranchBean branchBean)
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		if(branchBean!=null)
		{
		session.update(branchBean);

		transaction.commit();

		session.close();
		return "SUCCESS";
		}
		else if(branchBean==null)
		{
			return "FAIL";
		}
		else
		{
			return "ERROR";
		}
	}


	
	public ArrayList<BranchBean> viewBranch()
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		q=session.createQuery("from BranchBean");
		return (ArrayList<BranchBean>) q.list();
	}
	public BranchBean viewBranchById(int branchID)
	{
		BranchBean bb=new BranchBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<BranchBean> q2=session.createQuery("from BranchBean where branchID=:branchID");
	q2.setParameter("branchID", branchID);
	ArrayList<BranchBean> al=(ArrayList<BranchBean>) q2.getResultList();
	for(BranchBean e1:al)
	{
		bb=e1;
	}
	return bb;
	}

    
	
	public BranchBean viewBranchByBranchcode(String branchcode)
	{
		BranchBean bb=new BranchBean();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
	Query<BranchBean> q2=session.createQuery("from BranchBean where branchcode=:branchcode");
	q2.setParameter("branchcode", branchcode);
	ArrayList<BranchBean> al=(ArrayList<BranchBean>) q2.getResultList();
	for(BranchBean e1:al)
	{
		bb=e1;
	}
	return bb;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	

	 public ArrayList<Country> getCountry()
	    {
	        session=sessionFactory.openSession();
	        transaction=session.beginTransaction();
	        q=session.createQuery("from Country");
	        return (ArrayList<Country>) q.list();
	    }
	    
	    public Country viewCountrybyId(String countryid) {
	        
	        Country elBean=new Country();
	            session=sessionFactory.openSession();
	            transaction=session.beginTransaction();
	        Query<Country> q2=session.createQuery("from Country where countryid=:countryid");
	        q2.setParameter("countryid", countryid);
	        ArrayList<Country> all=(ArrayList<Country>) q2.getResultList();
	        for( Country e1:all)
	        {
	            elBean=e1;
	        }
	        return elBean;
	        }
	      
	//  public State viewStatebystateId(String stateid) {
//	      
//	      State elBean=new State();
//	          session=sessionFactory.openSession();
//	          transaction=session.beginTransaction();
//	      Query<State> q2=session.createQuery("from State where stateid=:stateid");
//	      q2.setParameter("stateid", stateid);
//	      ArrayList<State> all=(ArrayList<State>) q2.getResultList();
//	      for( State e1:all)
//	      {
//	          elBean=e1;
//	      }
//	      return elBean;
//	      }

	    
	    public ArrayList<State> getStateBycountryid(String countryid) {
	      
	       Country country = viewCountrybyId(countryid);
	        if (country != null) {
	            session = sessionFactory.openSession();
	            try {
	                transaction = session.beginTransaction();
	                Query<State> query = session.createQuery("FROM State WHERE country.countryid = :countryid");
	                query.setParameter("countryid", countryid);
	                ArrayList<State> reservations = (ArrayList<State>) query.getResultList();
	                transaction.commit();
	                return reservations;
	            } catch (Exception e) {
	                if (transaction != null) {
	                    transaction.rollback();
	                }
	                
	            } finally {
	                session.close();
	            }
	        }
	        return null;
	    }
	    
	    
	    public State viewStatebyId(String stateid) {
	        try (Session session = sessionFactory.openSession()) {
	            Query<State> query = session.createQuery("from State where stateid = :stateid", State.class);
	            query.setParameter("stateid", stateid);
	            List<State> results = query.getResultList();
	            if (!results.isEmpty()) {
	                return results.get(0);
	            }
	        } catch (Exception e) {
	            // Handle any exceptions or log errors
	            e.printStackTrace();
	        }
	        return null;
	    }

	    
	    


	public ArrayList<City> getCityBystateid(String stateid) {
	    System.out.println("Under DAO " + stateid);
	    State state = viewStatebyId(stateid);
	    if (state != null) {
	        session = sessionFactory.openSession();
	        try {
	            transaction = session.beginTransaction();
	            Query<City> query = session.createQuery("FROM City WHERE state.stateid = :stateid");
	            query.setParameter("stateid", stateid);
	            ArrayList<City> reservations = (ArrayList<City>) query.getResultList();
	            transaction.commit();
	            return reservations;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            
	        } finally {
	            session.close();
	        }
	    }
	    return null;
	}

	public City viewCitybyId(String cityid) {
	    try (Session session = sessionFactory.openSession()) {
	        Query<City> query = session.createQuery("from City where cityid = :cityid", City.class);
	        query.setParameter("cityid", cityid);
	        List<City> results = query.getResultList();
	        if (!results.isEmpty()) {
	            return results.get(0);
	        }
	    } catch (Exception e) {
	        // Handle any exceptions or log errors
	        e.printStackTrace();
	    }
	    return null;
	}


	public Location viewLocationById(String locationid) {
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        Query<Location> query = session.createQuery("FROM Location WHERE locationid = :locationid");
	        query.setParameter("locationid", locationid);
	        
	        Location elBean = query.uniqueResult();
	        
	        transaction.commit();
	        return elBean;
	    } catch (Exception e) {
	        // Handle any exceptions or log errors
	        e.printStackTrace();
	        return null; // or throw an exception
	    }
	}





	public ArrayList<Location> getLocationBycityid(String cityid) {
	    System.out.println("Under DAO " + cityid);
	    City city = viewCitybyId(cityid);
	    if (city != null) {
	        session = sessionFactory.openSession();
	        try {
	            transaction = session.beginTransaction();
	            Query<Location> query = session.createQuery("FROM Location WHERE city.cityid = :cityid");
	            query.setParameter("cityid", cityid);
	            ArrayList<Location> reservations = (ArrayList<Location>) query.getResultList();
	            transaction.commit();
	            return reservations;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	           
	        } finally {
	            session.close();
	        }
	    }
	    return null;
	}

	public String addCountry(Country country) {
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    session.save(country);
	    transaction.commit();
	    session.close();
	    return "success";
	    
	}
	public String addState(State state) {
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    session.save(state);
	    transaction.commit();
	    session.close();
	    return "success";
	}
	public String addCity(City city) {
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    session.save(city);
	    transaction.commit();
	    session.close();
	    return "success";
	}
	public String addLocation(Location location) {
	    session=sessionFactory.openSession();
	    transaction=session.beginTransaction();
	    session.save(location);
	    transaction.commit();
	    session.close();
	    return "success";
	}


	public Location viewlocationbyId(String locationid) {
	    
	    Location elBean=new Location();
	        session=sessionFactory.openSession();
	        transaction=session.beginTransaction();
	    Query<Location> q2=session.createQuery("from Location where locationid=:locationid");
	    q2.setParameter("locationid", locationid);
	    ArrayList<Location> all=(ArrayList<Location>) q2.getResultList();
	    for( Location e1:all)
	    {
	        elBean=e1;
	    }
	    return elBean;
	    }

	public boolean modifyCountry(Country country) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(country);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        
	    }
	    return isSuccess;
	}
	public boolean modifyState(State state) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(state);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        
	    }
	    return isSuccess;
	}

	public boolean modifyCity(City city) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(city);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	        
	    }
	    return isSuccess;
	}

	public boolean modifyLocation(Location location) {
	    boolean isSuccess = true;
	    try {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(location);
	        transaction.commit();
	        session.close();
	    } catch (Exception e) {
	        isSuccess = false;
	       
	    }
	    return isSuccess;
	}

	public List<Country> viewCountryByCountryId(String countryId) {
	    session = sessionFactory.openSession();
	    transaction = session.beginTransaction();
	    Query q1 = session.createQuery("FROM Country WHERE countryid = :countryid");
	    q1.setParameter("countryid", countryId);
	    List<Country> countries = q1.list();
	    transaction.commit();
	    session.close();
	    return countries;
	}





}
