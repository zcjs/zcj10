package hap.org.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.org.dto.Lines;

public interface LinesMapper extends Mapper<Lines>{
List<Lines> selectByLines(Lines lines);
    
    int insertLines(Lines lines);
    int updateLines(Lines lines);
    void deleteLines(Lines lines);
	
}
