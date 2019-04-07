package MemberDaoIbatis;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.configcontext.AppContext;
import com.sample.domain.Member;
import com.sample.member.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(classes=AppContext.class)
public class MemberDaoIbatisTest {

	@Autowired MemberDao memberDao;

	Member member1; 
	Member member2;
	Member member3;
	@Before
	public void setUp() {
		member1 = new Member(1, "김대연");
		member2 = new Member(2, "송병욱");
		member3 = new Member(3, "김보민");
	}
	
	@Test
	public void daoInject() {
		System.out.println(memberDao);
		assertThat(memberDao , is(notNullValue()));
	}
	
	@Test
	public void add() {
		memberDao.deleteAll();

		memberDao.add(member1);
		memberDao.add(member2);
		memberDao.add(member3);
		
		assertThat(memberDao.getCount(), is(3));
	}
	
	@Test
	public void deleteAll() {
		memberDao.deleteAll();

		memberDao.add(member1);
		memberDao.add(member2);
		memberDao.add(member3);
		assertThat(memberDao.getCount(), is(3));
		
		memberDao.deleteAll();
		
		assertThat(memberDao.getCount(), is(0));

	}
	
	@Test
	public void list() {
		memberDao.deleteAll();
		memberDao.add(member1);
		memberDao.add(member2);
		memberDao.add(member3);
		assertThat(memberDao.list().size(), is(3));
		System.out.println(memberDao.list().get(1).getName());
	}
	
	@Test
	public void getCount() {
		System.out.println(memberDao.getCount());
	}
	
}
