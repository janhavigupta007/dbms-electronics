package com.janhavi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.janhavi.model.Partner;
import com.janhavi.model.Proposal;


public class ProposalDaoImpl implements ProposalDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProposalDaoImpl() {
		
	}
	public ProposalDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}
	
	@Override
	public List<Proposal> getPendingproposals(final int productid) {
		String sql = "SELECT partnerid, price from partnerproposal"
				+ " where status = ? and productid = ?";

		 return this.jdbcTemplate.query(sql, new PreparedStatementSetter() {

				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setString(1, "pending");
					preparedStatement.setInt(2, productid);
				}
			},
		         new ResultSetExtractor<List<Proposal>>() {

		            @Override
		            public List<Proposal> extractData(ResultSet rs)
		                    throws SQLException, DataAccessException {
		                List<Proposal> list = new ArrayList<Proposal>();  
		                while(rs.next()){
		                    Proposal proposal = new Proposal();
		                    Partner partner = new Partner();
		                    partner.setPid(rs.getString("partnerid"));
		                    proposal.setPartner(partner);
		                    proposal.setPrice(rs.getInt("price"));
		                    list.add(proposal);
		                }
		                return list;
		            }  
		        });
	}
	
	@Override
	public int updateStatus(int productid, String partnerid) {
			
			String sql = "update partnerproposal set status = ? where partnerid = ? and productid = ?";
			
			try {
				
				int counter = jdbcTemplate.update(sql, new Object[] { "accepted",partnerid, productid});
				return counter;

			}
			catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
	}
}
