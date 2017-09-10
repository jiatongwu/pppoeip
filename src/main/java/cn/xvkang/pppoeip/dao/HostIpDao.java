package cn.xvkang.pppoeip.dao;

import org.springframework.data.repository.CrudRepository;

import cn.xvkang.pppoeip.pojo.HostIp;

public interface HostIpDao extends CrudRepository<HostIp, Integer>{
	public HostIp findByName(String name);
}
