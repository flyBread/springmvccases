package org.springframework.mvc.tx.demo2;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void outMoney(String out, Double money) {
		String sql = "update \"summercamp_voteItem\" set \"end\" = \"end\"-? where \"itemId\" = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}

	@Override
	public void inMoney(String in, Double money) {
		String sql = "update \"summercamp_voteItem\" set \"end\" = \"end\"+? where \"itemId\" = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}

}
