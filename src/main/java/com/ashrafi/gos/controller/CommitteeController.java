package com.ashrafi.gos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashrafi.gos.mapper.CommitteeMapper;

@Controller
public class CommitteeController {

	@Autowired
	private CommitteeMapper committeeMapper;
	
	public void setCommitteeMapper(CommitteeMapper committeeMapper) {
		this.committeeMapper = committeeMapper;
	}

	@RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("committees", this.committeeMapper.findAllParentWithChilds());
        return "home";
    }
}
