package hap.org.mapper;


import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.org.dto.Companys;
import hap.org.dto.Customer;

public interface CompanysMapper extends Mapper<Companys>{
    List<Companys> selectByCompanys(Companys companys);
    
    int insertCompanys(Companys companys);
    int updateCompanys(Companys companys);
    void deleteCompanys(Companys companys);
}
