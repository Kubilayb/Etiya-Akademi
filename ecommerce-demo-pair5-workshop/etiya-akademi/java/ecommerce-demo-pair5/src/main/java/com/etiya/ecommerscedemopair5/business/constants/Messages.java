package com.etiya.ecommerscedemopair5.business.constants;

public class Messages {

    public static class Category {
       // public static final String CategoryExistWithSameName = "Bu isimde kategori zaten var.";
        //MAGIC STRING
        public static final String CategoryExistsWithSameName = "categoryExistsWithSameName";
        public static final String CheckIfExistsCategoryId = "This Category found";
        public static final String addCategory= "This Category has been successfully added. ";
        public static final String getAllCategory= "All Category has been successfully called.";
        public static final String getByCategoryId = "This Category was called successfully";
        public static final String runTimeExceptionCategory = "This Category not found";
        public static final String getByCategoryName = "This Category name was called successfully";
    }

    public static class Exception{
        public static final String badRequest ="Bad request";
        public static final String noSuchException ="No such exception";
        public static final String validationException ="Validation exception";

        public static final String runTimeException ="This is exists";
    }

    public static class Product {
        public static final String CheckIfExistsProductId = "This  product  found";
        public static final String addProduct ="This product has been successfully added. ";
        public static final String getAllProducts = "All products has been successfully called.";
        public static final String getByProductId= "This product was called successfully";
        public static final String getByProductName = "Product names has been listed successfully.";
        public static final String getByProductStock = "Product stock has been listed successfully.";
        public static final String runTimeExceptionProduct = "This  product not found";

    }
    public static class ProductCategory {
        public static final String CheckIfExistsProductCategoryId = "This  product  found";
        public static final String addProductCategory ="This product has been successfully added. ";
        public static final String getAllProductCategory = "All products have been successfully called.";
        public static final String getByProductCategoryId= "This product was called successfully";
        public static final String runTimeExceptionCategory = "This  product not found";

    }
    public static class Address {
        public static final String CheckIfExistsAddressId = "This address found";
        public static final String addAddress = "This address has been successfully added. ";
        public static final String getAllAddress = "All addresses has been successfully called.";
        public static final String getByAddressId = "This address was called successfully";
        public static final String getByAddressName = "This address  name was called successfully";

        public static final String runTimeExceptionAddress= "This address not found";
    }

    public static class AddressTitle {
        public static final String CheckIfExistsAddressTitleId = "This street found";
        public static final String addStreet= "This street has been successfully added. ";
        public static final String getAllStreets= "All streets have been successfully called.";
        public static final String getByStreetId = "This street was called successfully";
        public static final String getByStreetName = "This street  name was called successfully";

        public static final String runTimeExceptionAddressTitle = "This street not found";
    }

    public static class City {
        public static final String CheckIfExistsCityId = "This city  found";
        public static final String addCity="This city has been successfully added. ";
        public static final String getByCityName = "City names has been listed successfully.";

        public static final String getAllCity= "All city has been successfully called.";
        public static final String getByCityId= "This city was called successfully";
        public static final String runTimeExceptionCity = "This city not found";
    }

    public static class Customer {
        public static final String CheckIfExistsCustomerId = "This customer  found";
        public static final String addCustomer="This customer has been successfully added. ";
        public static final String getCustomerFirstName= "Customers first name has been successfully called.";
        public static final String getCustomerLastName= "Customers last name has been successfully called.";
        public static final String getAllNameAsc= "All customers has been successfully called.";

        public static final String getAllCustomers= "All customers has been successfully called.";
        public static final String getByCustomerId= "This customer was called successfully";
        public static final String runTimeExceptionCustomer = "This customer not found";
    }


    public static class Size {
        public static final String CheckIfExistsSizeId = "This size  found";
        public static final String addSize= "This size has been successfully added. ";
        public static final String getAllSizes="All  size have been successfully called.";
        public static final String getBySizeStock = "Size stock has been listed successfully.";

        public static final String getBySizeId = "This size was called successfully";
        public static final String getBySizeName = "Size names has been listed successfully.";
        public static final String runTimeExceptionSize = "This size not found";
    }
    public static class Cargo {
        public static final String CheckIfExistsCargoId = "This cargo  found";
        public static final String addCargo = "This cargo has been successfully added. ";
        public static final String getAllCargo= "All cargo have been successfully called.";
        public static final String getByCargoPrice = "Cargo price has been listed successfully.";
        public static final String getByCargoName = "Cargo names has been listed successfully.";

        public static final String getByCargoId = "This cargo was called successfully";
        public static final String runTimeExceptionCargo = "This cargo not found";
    }
    public static class Order {
        public static final String CheckIfExistsOrderId = "This order  found";
        public static final String addOrder= "This order has been successfully added. ";
        public static final String getAllOrder ="All  order has been successfully called.";
        public static final String getOrderDate ="Order date listed successfully.";
        public static final String getAllOrderByCargoCompany ="All orders received by the cargo company have been successfully listed.";

        public static final String getByOrderId = "This order  was called successfully";
        public static final String runTimeExceptionOrder = "This order not found";
    }

    public static class Color {
        public static final String CheckIfExistsColorId = "This color  found";
        public static final String addColor = "This color has been successfully added. ";
        public static final String getAllColors= "All colors has been successfully called.";
        public static final String getByColorId = "This color was called successfully";
        public static final String runTimeExceptionColor = "This color not found";
    }

    public static class Payment {
        public static final String CheckIfExistsPaymentId = "This payment  found";
        public static final String addPayment = "This payment has been successfully added. ";
        public static final String getAllPayment= "All payments has been successfully called.";
        public static final String getByPaymentId = "This payment was called successfully";
        public static final String runTimeExceptionPayment = "This payment not found";
    }



    public static class MoneyType {
        public static final String CheckIfExistsMoneyTypeId = "This money type  found";
        public static final String addMoneyType = "This money type has been successfully added. ";
        public static final String getAllMoneyType= "All money type has been successfully called.";
        public static final String getByMoneyTypeId = "This money type was called successfully";
        public static final String getByMoneyTypeName = "Money type names has been listed successfully.";
        public static final String runTimeException = "This money type not found";

    }

    public static class ColorSizeRelation {
        public static final String CheckIfExistsColorSizeId = "This colorSize found";
        public static final String addColorSize = "This colorSize has been successfully added. ";
        public static final String getAllColorSize= "All colorSize has successfully called.";
        public static final String getByColorSizeId = "This colorSize  was called successfully";
        public static final String runTimeExceptionColorSize = "This colorSize not found";
    }

}
