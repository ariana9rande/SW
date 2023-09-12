package com.hjh.assembler;

import com.hjh.service.ChangePasswordService;
import com.hjh.service.MemberDao;
import com.hjh.service.MemberRegisterService;

public class Assembler
{
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler()
	{
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService();
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao()
	{
		return memberDao;
	}

	public MemberRegisterService getRegSvc()
	{
		return regSvc;
	}

	public ChangePasswordService getPwdSvc()
	{
		return pwdSvc;
	}
}
