package hfs.ass.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hand.hap.core.annotation.MultiLanguage;
import com.hand.hap.core.annotation.MultiLanguageField;
import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.system.dto.BaseDTO;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by taotao.xu on 16/6/24.
 */
@MultiLanguage
@Table(name = "fruit_b")
public class Fruit  extends BaseDTO {
    
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Long fruitId;
    
    @Column
    @NotEmpty
    @JsonInclude(Include.NON_NULL)
    private String fruitName;
    
    @Column
    @NotEmpty
    private String fruitCode;
    
    @Column
    @MultiLanguageField
    private String fruitDescription;
    
    
    @Column
    @Condition(exclude = true)
    private Date myDate;
    
	public String getFruitCode() {
		return fruitCode;
	}

	public void setFruitCode(String fruitCode) {
		this.fruitCode = fruitCode;
	}

	public Long getFruitId() {
		return fruitId;
	}

	public void setFruitId(Long fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDescription() {
		return fruitDescription;
	}

	public void setFruitDescription(String fruitDescription) {
		this.fruitDescription = fruitDescription;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	
    
}
