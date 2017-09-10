package cn.xvkang.pppoeip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xvkang.pppoeip.pojo.HostIp;
import cn.xvkang.pppoeip.service.HostIpService;

@Controller
public class HostIpController {
	@Autowired
	HostIpService hostIpService;
	@RequestMapping("/list")
	@ResponseBody
	public String listIp() {
		Iterable<HostIp> hostIpIterable=hostIpService.list();
		StringBuilder sb=new StringBuilder();
		for(HostIp hostIp:hostIpIterable) {
			sb.append(hostIp.getName()+":");
			sb.append(hostIp.getIpaddr()+"<br/>");
			
		}
		return sb.toString();
	}
	@RequestMapping("/save")
	@ResponseBody
	public String save(String name,String ipaddr) {
		HostIp hostIp=new HostIp();
		hostIp.setName(name);
		hostIp.setIpaddr(ipaddr);
		HostIp tmp=hostIpService.getByName(name);
		if(tmp!=null) {
			hostIp.setId(tmp.getId());
		}
		hostIpService.saveOrUpdate(hostIp);
		return "ok";
	}
}
