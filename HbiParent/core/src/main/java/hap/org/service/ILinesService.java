package hap.org.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hap.org.dto.Lines;

public interface ILinesService extends IBaseService<Lines>, ProxySelf<ILinesService>{
	 List<Lines> selectByLines(IRequest requestContext, Lines lines, int page, int pagesize);
	    
	    List<Lines> batchUpdate(IRequest requestContext, @StdWho List<Lines> lineslist);
	    
	    List<Lines> update(IRequest requestContext, List<Lines> lineslist);
}
