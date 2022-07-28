package guru.springframework.msscbrewery.web.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements
    CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Leo Messi").build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    return CustomerDto.builder().id(UUID.randomUUID()).build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    //TODO implement update customer
  }

  @Override
  public void deleteCustomerById(UUID customerId) {
    log.debug("Deleting a customer...");
  }
}
