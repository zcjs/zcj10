package hap.org.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.org.dto.Companys;
import hap.org.dto.Customer;

public interface CustomerMapper extends Mapper<Customer>{
List<Customer> selectByCustomer(Companys companys);
    
    int insertCustomer(Customer customer);
    int updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
