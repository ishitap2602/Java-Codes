package com.test;

import java.util.*;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args)

	{

		String str="java";

		System.out.println(Pattern .matches(str,"java"));

		System.out.println(Pattern.matches("[a-zA-Z]","a"));

		String pwdptrn="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%()_=-])(?=\\S+$).{8,20}$";

		final Pattern ptn=Pattern.compile(pwdptrn);

		String pass="Java@12345";

		Matcher mt=ptn.matcher(pass);

		System.out.println(mt.matches());

	}
 
}

 