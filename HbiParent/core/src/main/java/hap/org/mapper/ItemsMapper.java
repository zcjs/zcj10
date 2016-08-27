package hap.org.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.org.dto.Items;

public interface ItemsMapper extends Mapper<Items>{
List<Items> selectByItems(Items items);
    
    int insertItems(Items items);
    int updateItems(Items items);
    void deleteItems(Items items);
}
