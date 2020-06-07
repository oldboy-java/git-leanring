package com.tk.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tk.entity.Dept;

import feign.hystrix.FallbackFactory;


@Component
public class DeptFeignClientServiceFallbackFactory implements FallbackFactory<DeptFeignClientService> {

	@Override
	public DeptFeignClientService create(Throwable cause) {
		return new DeptFeignClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}