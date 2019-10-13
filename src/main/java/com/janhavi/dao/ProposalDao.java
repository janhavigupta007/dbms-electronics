package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Proposal;

public interface ProposalDao{
	public List<Proposal> getPendingproposals(int productid);
	public int updateStatus(int productid, String partnerid);
}
