package com.janine.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.janine.entity.SysUser;

@Component
public class SysUserDaoImpl extends JdbcDaoSupport implements SysUserDao {
	
	private static Logger logger = Logger.getLogger(SysUserDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	
	@Override
	public List<SysUser> findAllUser() {
		String sql = "select * from sampledb.sys_user where id=?";
		final List<SysUser> listAllUser = new ArrayList<SysUser>();
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);
		System.out.println(list.size());
		/*jdbcTemplate.query(sql, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				SysUser user = new SysUser();
				user.setUsername(rs.getString("u_name"));
				user.setPassword(rs.getString("u_password"));
				user.setTel(rs.getString("u_tel"));
				user.setId(rs.getInt("id"));
				listAllUser.add(user);
			}
		});*/
		
		
		logger.info(listAllUser.size());
		return listAllUser;
	}

}
