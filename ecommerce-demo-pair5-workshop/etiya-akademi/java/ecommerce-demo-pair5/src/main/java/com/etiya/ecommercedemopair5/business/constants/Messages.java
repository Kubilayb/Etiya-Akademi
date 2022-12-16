package com.etiya.ecommercedemopair5.business.constants;

public class Messages {

    public static class Exception{
        public static final String badRequest ="badRequest";
        public static final String noSuchException ="noSuchException";
        public static final String validationException ="validationException";

        public static final String runTimeException ="runTimeException";
        public static final String getByPage = "getByPage";
    }

                //----------------Category---------------
    public static class Category {
        // public static final String CategoryExistWithSameName = "Bu isimde kategori zaten var.";
        //MAGIC STRING
        public static final String CategoryExistsWithSameName = "categoryExistsWithSameName";
        public static final String CheckIfExistsCategoryId = "CheckIfExistsCategoryId";
        public static final String addCategory= "addCategory";
        public static final String getAllCategory= "getAllCategory";
        public static final String getByCategoryId = "getByCategoryId";
        public static final String runTimeExceptionCategory = "runTimeExceptionCategory";
        public static final String getByCategoryName = "getByCategoryName";
        public static final String getByPage = "getByPage";
    }

                    //--------------------Address--------------------------
    public static class Address {
        public static final String CheckIfExistsAddressId = "CheckIfExistsAddressId";
        public static final String addAddress = "addAddress";
        public static final String getAllAddress = "getAllAddress";
        public static final String getByAddressId = "getByAddressId";
        public static final String getByAddressName = "getByAddressName";
        public static final String runTimeExceptionAddress= "runTimeExceptionAddress";
        public static final String getByPage = "getByPage";
    }

                    //------------------AddressTitle-----------------
    public static class AddressTitle {
        public static final String CheckIfExistsAddressTitleId = "CheckIfExistsAddressTitleId";
        public static final String addStreet= "addStreet";
        public static final String getAllStreets= "getAllStreets";
        public static final String getByStreetId = "getByStreetId";
        public static final String getByStreetName = "getByStreetName";
        public static final String AddressTitleExistsWithSameName = "AddressTitleExistsWithSameName";
        public static final String runTimeExceptionAddressTitle = "runTimeExceptionAddressTitle";
        public static final String getByPage = "getByPage";
    }

                     //--------------------Customer---------------------
    public static class Customer {
        public static final String CheckIfExistsCustomerId = "CheckIfExistsCustomerId";
        public static final String addCustomer="addCustomer";
        public static final String getCustomerFirstName= "getCustomerFirstName";
        public static final String getCustomerLastName= "getCustomerLastName";
        public static final String getAllNameAsc= "getAllNameAsc";
        public static final String getAllCustomers= "getAllCustomers";
        public static final String getByCustomerId= "getByCustomerId";
        public static final String runTimeExceptionCustomer = "runTimeExceptionCustomer";
        public static final String getByPage = "getByPage";
    }

                      //--------------------City-------------------------
    public static class City {
        public static final String CheckIfExistsCityId = "CheckIfExistsCityId";
        public static final String checkIfExistsCityName = "checkIfExistsCityName";
        public static final String addCity="addCity";
        public static final String getByCityName = "City names has been listed successfully.";
        public static final String getAllCity= "getAllCities";
        public static final String getByCityId= "getByCityId";
        public static final String runTimeExceptionCity = "runTimeExceptionCity";
        public static final String getByPage = "getByPage";


                      }

                    //--------------------Color------------------------
    public static class Color {
        public static final String CheckIfExistsColorId = "CheckIfExistsColorId";
        public static final String CheckIfExistsColorName = "CheckIfExistsColorName";
        public static final String addColor = "addColor";
        public static final String getAllColors= "getAllColors";
        public static final String getByColorId = "getByColorId";
        public static final String runTimeExceptionColor = "runTimeExceptionColor";
        public static final String getByPage = "getByPage";
    }

                    //------------------ColorSizeRelation--------------------
    public static class ColorSizeRelation {
        public static final String CheckIfExistsColorSizeId = "CheckIfExistsColorSizeId";
        public static final String addColorSize = "addColorSize";
        public static final String getAllColorSize= "getAllColorSize";
        public static final String getByColorSizeId = "getByColorSizeId";
        public static final String runTimeExceptionColorSize = "runTimeExceptionColorSize";
        public static final String getByPage = "getByPage";
    }

                     //-------------------MoneyType-------------------------
    public static class MoneyType {
        public static final String CheckIfExistsMoneyTypeId = "CheckIfExistsMoneyTypeId";
        public static final String addMoneyType = "addMoneyType";
        public static final String getAllMoneyType= "getAllMoneyType";
        public static final String getByMoneyTypeId = "getByMoneyTypeId";
        public static final String getByMoneyTypeName = "getByMoneyTypeName";
        public static final String runTimeException = "runTimeExceptionMoneyType";
        public static final String getByPage = "getByPage";

    }

                      //------------------Order---------------------------
    public static class Order {
        public static final String CheckIfExistsOrderId = "CheckIfExistsOrderId";
        public static final String addOrder= "addOrder";
        public static final String getAllOrder ="getAllOrder";
        public static final String getOrderDate ="getOrderDate";
        public static final String getAllOrderByCargoCompany ="getAllOrderByCargoCompany";
        public static final String getByOrderId = "getByOrderId";
        public static final String runTimeExceptionOrder = "runTimeExceptionOrder";
        public static final String getByPage = "getByPage";
    }

                     //----------------Payment-------------------------------
    public static class Payment {
        public static final String CheckIfExistsPaymentId = "CheckIfExistsPaymentId";
        public static final String addPayment = "addPayment";
        public static final String getAllPayment= "getAllPayment";
        public static final String getByPaymentId = "getByPaymentId";
        public static final String runTimeExceptionPayment = "runTimeExceptionPayment";
        public static final String getByPage = "getByPage";
    }

                     //----------------ProductCategory---------------------
    public static class ProductCategory {
        public static final String CheckIfExistsProductCategoryId = "CheckIfExistsProductCategoryId";
        public static final String addProductCategory ="addProductCategory";
        public static final String getAllProductCategory = "getAllProductCategory";
        public static final String getByProductCategoryId= "getByProductCategoryId";
        public static final String runTimeExceptionProductCategory = "runTimeExceptionProductCategory";
        public static final String getByPage = "getByPage";
    }

                     //-------------------Product--------------------------------
    public static class Product {
        public static final String CheckIfExistsProductId = "CheckIfExistsProductId";
        public static final String addProduct ="addProduct";
        public static final String getAllProducts = "getAllProducts";
        public static final String getByProductId= "getByProductId";
        public static final String getByProductName = "getByProductName";
        public static final String getByProductStock = "getByProductStock";
        public static final String runTimeExceptionProduct = "runTimeExceptionProduct";
        public static final String getByPage = "getByPage";
    }

                     //----------------------Size-----------------------------
    public static class Size {
        public static final String CheckIfExistsSizeId = "CheckIfExistsSizeId";
        public static final String addSize= "addSize";
        public static final String getAllSizes="getAllSizes";
        public static final String getBySizeStock = "getBySizeStock";
        public static final String getBySizeId = "getBySizeId";
        public static final String getBySizeName = "getBySizeName";
        public static final String runTimeExceptionSize = "runTimeExceptionSize";
        public static final String SizeExistsWithSameName = "SizeExistsWithSameName";
        public static final String getByPage = "getByPage";
    }
                      //----------------Cargo---------------------
    public static class Cargo {
        public static final String CheckIfExistsCargoId = "CheckIfExistsCargoId";
        public static final String addCargo = "addCargo";
        public static final String getAllCargo= "getAllCargo";
        public static final String getByCargoPrice = "getByCargoPrice";
        public static final String getByCargoName = "getByCargoName";
        public static final String CargoExistsWithSameName = "CargoExistsWithSameName";
        public static final String getByCargoId = "getByCargoId";
        public static final String runTimeExceptionCargo = "runTimeExceptionCargo";
        public static final String getByPage = "getByPage";
    }
}
