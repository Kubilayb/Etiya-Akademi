package com.etiya.ecommerscedemopair5.business.concretes;

import com.etiya.ecommerscedemopair5.business.abstracts.AddressService;
import com.etiya.ecommerscedemopair5.business.abstracts.AddressTitleService;
import com.etiya.ecommerscedemopair5.business.abstracts.CityService;
import com.etiya.ecommerscedemopair5.business.abstracts.CustomerService;
import com.etiya.ecommerscedemopair5.business.constants.Messages;
import com.etiya.ecommerscedemopair5.business.dtos.AddressDTO;
import com.etiya.ecommerscedemopair5.business.dtos.CategoryDTO;
import com.etiya.ecommerscedemopair5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommerscedemopair5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommerscedemopair5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommerscedemopair5.core.util.exceptions.BusinessException;
import com.etiya.ecommerscedemopair5.core.util.mapping.ModelMapperService;
import com.etiya.ecommerscedemopair5.core.util.results.DataResult;
import com.etiya.ecommerscedemopair5.core.util.results.SuccessDataResult;
import com.etiya.ecommerscedemopair5.entities.concretes.*;
import com.etiya.ecommerscedemopair5.repository.abstracts.AddressRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.AddressTitleRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.CityRepository;
import com.etiya.ecommerscedemopair5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;

    private ModelMapperService modelMapperService;

   /* private AddressTitleService addressTitleService;
    private CityService cityService;
    private CustomerService customerService;*/
    private CityRepository cityRepository;
    private final AddressTitleRepository addressTitleRepository;
    private final CustomerRepository customerRepository;

    @Override
    public DataResult<List<Address>> getAll() {
        List<Address> response = this.addressRepository.findAll();
        return new SuccessDataResult<List<Address>>(response,Messages.Address.getAllAddress);
    }
    @Override
    public DataResult<Address> getById(int id) {
        Address response = this.addressRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Address>(response,Messages.Address.getByAddressId);
    }
    @Override
    public DataResult<List<Address>> getByName(String street) {
        List<Address> response = this.addressRepository.findByName(street);
        return new SuccessDataResult<List<Address>>(response,Messages.Address.getByAddressName);
    }


    @Override
    public DataResult<List<AddressDTO>> findByAddressExample(int id) {
        List<AddressDTO> response = addressRepository.findByAddressExample(id);
        return new SuccessDataResult<List<AddressDTO>>(response);
    }

 /*   @Override
    public List<Address> customAddress(int id) {
        return addressRepository.customAddress(id);
    }
*/

    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {

        checkIfExistsCityId(addAddressRequest.getCityId());
        checkIfExistsAddressTitleId(addAddressRequest.getAddressTitleId());
        checkIfExistsCustomerId(addAddressRequest.getCustomerId());
        Address address =
                modelMapperService.forRequest().map(addAddressRequest,Address.class);
        AddAddressResponse addAddressResponse =
                modelMapperService.forResponse().map(addressRepository.save(address),
                        AddAddressResponse.class);
        return new SuccessDataResult<AddAddressResponse>(addAddressResponse,Messages.Address.addAddress);

    }
    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Messages.City.runTimeExceptionCity);
        }
    }
    public void checkIfExistsAddressTitleId(int id){
        boolean isExists = addressRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Messages.AddressTitle.runTimeExceptionAddressTitle);
        }
    }
    public void checkIfExistsCustomerId(int id){
        boolean isExists = customerRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(Messages.Customer.runTimeExceptionCustomer);
        }
    }

}
/*        Address address = new Address();

        address.setStreet(addAddressRequest.getStreet());

        AddressTitle addressTitle = addressTitleService.getById(addAddressRequest.getAddresstitleId());
        address.setAddresstitle(addressTitle);

        //value ve business

        checkIfExistsCityId(addAddressRequest.getCityId());

        City city = cityService.getById(addAddressRequest.getCityId());
        address.setCity(city);

        Customer customer = customerService.getById(addAddressRequest.getCustomerId());
        address.setCustomers(customer);


        Address savedAddress=addressRepository.save(address);

        AddAddressResponse response =
                new AddAddressResponse(savedAddress.getId(),
                        savedAddress.getCity().getId(),
                        savedAddress.getAddresstitle().getId(),
                        savedAddress.getStreet(),
                        savedAddress.getCustomers().getId());

        return response;*/