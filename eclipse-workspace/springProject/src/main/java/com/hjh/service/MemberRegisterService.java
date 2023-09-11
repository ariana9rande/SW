package com.hjh.service;

import java.time.LocalDateTime;

import com.hjh.model.Member;

public class MemberRegisterService
{
	private MemberDao memberDao = new MemberDao();

	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	public long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null)
		{
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName(), LocalDateTime.now());

		return newMember.getId();
	}
}
