package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;


public class MarksheetTest {
	public static void main(String[] args) throws Exception {
//      testUpdate();
		//testAdd();
		testfindByRoll_No();
//		testSearch();
	}

	private static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setRoll_No(102);
		MarksheetModel model = new MarksheetModel();
		
		List list = model.search(bean,1,5);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			 bean = (MarksheetBean) it.next();
	   
			System.out.print("\t" +bean.getId());
			System.out.print("\t" +bean.getName());
			System.out.print("\t" +bean.getRoll_No());
			System.out.print("\t" +bean.getPhysics());
			System.out.print("\t" +bean.getChemistry());
			System.out.println("\t" +bean.getMaths());
			
		}
		
	}

	private static void testadd() throws Exception {
MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		bean.setName("Ravan");
		bean.setRoll_No(117);
		bean.setPhysics(44);
		bean.setChemistry(56);
		bean.setMaths(33);
		
		
		MarksheetModel model = new MarksheetModel(); 
		
		model.add(bean);
		
		
		
	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(16);
		bean.setName("Nikita");
		bean.setRoll_No(116);
		bean.setPhysics(44);
		bean.setChemistry(55);
		bean.setMaths(33);
		
		
		MarksheetModel model = new MarksheetModel(); 
		
		model.update(bean);
	}
	private static void testfindByRoll_No() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByRoll_No(117);
		
		if (bean != null) {
			
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRoll_No());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
    
		}else {
			System.out.println("Roll_Number not Exist.....!!!!!");
		}
}
}


