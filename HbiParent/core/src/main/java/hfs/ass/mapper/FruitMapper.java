package hfs.ass.mapper;

import com.hand.hap.mybatis.common.Mapper;

import hfs.ass.dto.Fruit;
import java.util.List;

/**
 * @author taotao.xu@hand-china.com
 */
public interface FruitMapper extends Mapper<Fruit> {

    List<Fruit> selectByFruit(Fruit fruit);
    
    int insertFruit(Fruit fruit);
    int updateFruit(Fruit fruit);
    void deleteFruit(Fruit fruit);
    

}
