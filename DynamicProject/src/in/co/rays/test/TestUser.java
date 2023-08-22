package in.co.rays.test;


	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Iterator;
	import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

	public class TestUser {
		
		public static void main(String[] args) throws Exception {
			
		//testAdd();
//			testUpdate();
			testSearch();
		}    

		private static void testUpdate() throws Exception {
			 
			UserModel model = new UserModel();
			UserBean bean = model.findByPk(1);
			
			if(bean!= null) {
				bean.setFirstName("ajaypal");
				bean.setLastName( "singh rajput");
				
				model.update(bean);
				
				System.out.println("User exist & Updated");
			
				
			}else {
				System.out.println("User not exist...!!!");
			}
			
			
		}

		private static void testAdd() throws Exception {
			
			String dob = "2002-12-31";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			UserBean bean = new UserBean();
			bean.setId(11);
			bean.setFirstName("baljeet");
			bean.setLastName("rajput");
			bean.setLoginId("baljeet@gmail.com");
			bean.setPassword("Ballu@2255");
			bean.setDob( sdf.parse(dob));
			bean.setAddress("Ratlam");
			
			UserModel model = new UserModel();
			
			model.add(bean);

			
		}
	 

		public static void testSearch() throws Exception {
			
			String dob = "2000-02-23";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			UserBean bean = new UserBean();
			bean.setDob(sdf.parse(dob));
			UserModel model = new UserModel  ();
			
		 List list = model.search(bean, 0, 0);
		 Iterator it = list.iterator();
		 
		 while(it.hasNext()) {
			 bean = (UserBean)it.next();
			 System.out.print("\t" +bean.getId());
			 System.out.print("\t" +bean.getFirstName());
			 System.out.print("\t" +bean.getLastName());
			 System.out.print("\t" +bean.getLoginId());
			 System.out.print("\t" +bean.getPassword());
			 System.out.print("\t" +bean.getDob());
			 System.out.println("\t" +bean.getAddress());
	}
		}
		}



