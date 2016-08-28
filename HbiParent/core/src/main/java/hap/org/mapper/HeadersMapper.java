package hap.org.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.org.dto.Headers;

public interface HeadersMapper extends Mapper<Headers>{
List<Headers> selectByHeaders(Headers headers);
    
    void insertHeaders(Headers headers);
    int updateHeaders(Headers headers);
    void deleteHeaders(Headers headers);
    int selectby(Companys company);
}
