package in.co.rays.library;

public class TestLibrary {
	
	public static void main(String[] args) throws Exception {
//		testAdd();
		testUpdate();
		
	}

	private static void testUpdate() throws Exception {
		
		librarybean bean = new librarybean();
		
	
		bean.setStudent_name("nikita jat");
		bean.setFees(400);
		bean.setMobile_no(743883363);
		bean.setAddress("ratlam");
		bean.setId(11);
		
		LibraryModel model = new LibraryModel();
		
		model.update(bean);
		
		
		
	}

	private static void testAdd() throws Exception {
		
		librarybean bean = new librarybean();
		
		bean.setId(11);
		bean.setStudent_name("Shubham jat");
		bean.setFees(500);
		bean.setMobile_no(838363633);
		bean.setAddress("Tarana");
		
		LibraryModel model = new LibraryModel();
		
		model.add(bean);
		
		
	}

}
