package BaseURIsAndHeaders;

import utilities.Config;

public class EndPoints {
	
	//List of GET End points
	public static final String GET_PRODUCT_TYPE = "/product-type";
	public static final String GET_UPLOADED_DOCUMENT_DETAILS = "/uploadeddocuments/"+Config.getConfigValue("LeadID");
	public static final String GET_ACTIVITY_DETAILS_OF_LEAD = "/leads/" + Config.getConfigValue("LeadID") + "/details";
	public static final String GET_DETAILS_OF_LEAD = "/overviewdata/" +Config.getConfigValue("LeadID");
	public static final String GET_CITY_DETAILS = "/StateCityList/India";
	public static final String GET_COLLEGES_NAME = "/completefillingdata";
	public static final String kk = "/bulkdocuments/";
	public static final String signup = "/sign-up";
	public static final String getCountryList = "/inprinciple/getCountryList";
	public static final String GET_BANK_DETAILS ="/finbit/getBanks";

}
