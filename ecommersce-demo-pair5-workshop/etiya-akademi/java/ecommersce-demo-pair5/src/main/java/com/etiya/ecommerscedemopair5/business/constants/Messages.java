package com.etiya.ecommerscedemopair5.business.constants;

public class Messages {

    public static class Category {
        public static final String CategoryExistWithSameName = "Bu isimde kategori zaten var.";
        //MAGIC STRING
    }

    public static class Exception{
        public static final String badRequest ="Bad request";
        public static final String noSuchException ="No such exception";
        public static final String validationException ="Validation exception";

        public static final String runTimeException ="This is exists";
    }
    public static class AddressTitle {
        public static final String CheckIfExistsAddressTitleId = "This street found";
        public static final String createStreet= "This street has been successfully added. ";
        public static final String getAllStreets= "All streets have been successfully called.";
        public static final String getByStreetId = "This street was called successfully";
        public static final String runTimeException = "This street not found";
    }

    public static class City {
        public static final String CheckIfExistsCityId = "This city  found";
        public static final String createCity="This city has been successfully added. ";
        public static final String getAllCity= "All city have been successfully called.";
        public static final String getByCityId= "This city was called successfully";
        public static final String runTimeException = "This city not found";
    }

    public static class Customer {
        public static final String CheckIfExistsCustomerId = "This customer  found";
        public static final String createCustomer="This customer has been successfully added. ";
        public static final String getAllCustomers= "All customers have been successfully called.";
        public static final String getByCustomerId= "This customer was called successfully";
        public static final String runTimeException = "This customer not found";
    }


}
