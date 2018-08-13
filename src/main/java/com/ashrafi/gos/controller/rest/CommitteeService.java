package com.ashrafi.gos.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashrafi.gos.mapper.CommitteeMapper;
import com.ashrafi.gos.model.Committee;

@RestController
@RequestMapping(value="/committee")
public class CommitteeService {
	
	@Autowired
	private CommitteeMapper committeeMapper;
	
	public void setCommitteeMapper(CommitteeMapper committeeMapper) {
		this.committeeMapper = committeeMapper;
	}

	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Committee> getAllParentCommitteesWithChilds(){
		return this.committeeMapper.findAllParentWithChilds();
	}
}
