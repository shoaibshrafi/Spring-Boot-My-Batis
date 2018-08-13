package com.ashrafi.gos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Many;

import com.ashrafi.gos.model.Committee;

@Mapper
public interface CommitteeMapper {

	@Select("Select CODE, NAME, P_CODE FROM COMMITTEE WHERE P_CODE IS NULL")
	@Results({@Result(property = "pcode", column = "P_CODE")})
	List<Committee> findAllParents();

	@Select("Select CODE, NAME, P_CODE FROM COMMITTEE WHERE P_CODE = #{parentCode}")
	@Results({
			@Result(property = "pcode", column = "P_CODE"),
		    @Result(property = "code", column = "CODE"),
		    @Result(property = "children", column = "CODE", javaType = java.util.List.class, many = @Many(select="findChilds"))
		    })
	List<Committee> findChilds(Long parentCode);

	 @Select("Select CODE, NAME FROM COMMITTEE WHERE P_CODE IS NULL")
	 @Results({
	    @Result(property = "code", column = "CODE"),
	    @Result(property = "children", column = "CODE", javaType = java.util.List.class, many = @Many(select="findChilds"))
	    })
    public List<Committee> findAllParentWithChilds();

	
}
