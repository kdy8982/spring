package MemberDaoIbatis;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.domain.Member;
import com.sample.member.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MemberDaoIbatisTest {

	@Autowired MemberDao memberDao;

	Member member1; 
	Member member2;
	Member member3;
	Member member4;
	
	@Before
	public void setUp() {
		member1 = new Member("1", "김대연");
		member2 = new Member("2", "김보민");
		member3 = new Member("3", "송병욱");
		member4 = new Member("4", "이진화");
	}
	
	@Test
	public void daoInject() {
		System.out.println(memberDao);
		assertThat(memberDao , is(notNullValue()));
	}
	
	
	@Test
	public void add() {
		memberDao.add(member1);
		memberDao.add(member2);
		memberDao.add(member3);
		memberDao.add(member4);
		
		assertThat(memberDao.getCount(), is(4));

	}
	
	@Test
	public void list() {
		
	}
	
}
