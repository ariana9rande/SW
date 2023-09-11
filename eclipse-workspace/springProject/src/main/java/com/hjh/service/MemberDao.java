package com.hjh.service;

import java.util.HashMap;
import java.util.Map;

import com.hjh.model.Member;

public class MemberDao {
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap();
	
	public Member selectByEmail(String email)
	{
		return map.get(email);
	}
}
