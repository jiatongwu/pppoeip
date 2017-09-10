package cn.xvkang.pppoeip.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xvkang.pppoeip.dao.HostIpDao;
import cn.xvkang.pppoeip.pojo.HostIp;

@Service
public class HostIpService {
	@Autowired
	HostIpDao hostIpDao;
	public void saveOrUpdate(HostIp hostIp) {
		if(hostIp.getId()!=null) {
			hostIpDao.delete(hostIp.getId());
		}
		hostIpDao.save(hostIp);
	}
	public Iterable<HostIp> list(){
		return hostIpDao.findAll();
	}
	public HostIp getByName(String name) {
		return hostIpDao.findByName(name);
	}
}
