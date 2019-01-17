package com.demo.common.model;


import java.util.List;

import com.demo.common.model.base.BaseRecord;
import com.jfinal.plugin.activerecord.Page;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Record extends BaseRecord<Record> {
	public static final Record dao = new Record().dao();
	
	public Record findByOrder(String orders) {
		return Record.dao.findFirst("select * from record where orders=? order by loantimes desc", orders);
	}
	
	//查询一个人借了多少物品
	public List<Record> findByStudIdLend(String stuId) {
		return Record.dao.find("select * from record where stuIds=? order by loantimes desc", stuId);
	}
	
	//查询一个人还了多少物品
	public List<Record> findByStuIdBack(String stuId) {
		return Record.dao.find("select * from record where stuIds=? and backtimes is not null order by loantimes desc", stuId);
	}
	
	//查询一个人还有多少物品没还
	public List<Record> findByStuIdNotBack(String stuId) {
		return Record.dao.find("select * from record where stuIds=? and backtimes is null order by loantimes desc", stuId);
	}
	
	public List<Record> findByBacktimesLend() {
		return Record.dao.find("select * from record where backtimes is null");
	}
	
}