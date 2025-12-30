package com.test;
 
	abstract class TemplateMethods{
public abstract void players();
public abstract void playerInfo();
 
public final void completeTeam() {
	this.players();
	this.playerInfo();
}
}
	class PlayersImpl extends TemplateMethods{
		@Override
		public void players() {
			System.out.println("PlayerInfo overriden cc 22");
		}
		@Override
		public void playerInfo() {
			System.out.println("PlayerInfo overriden cc");
		}
	}
	class PlayerInfoImpl extends TemplateMethods{
		@Override
		public void players() {
			System.out.println("PlayerInfo overriden cc dd");
		}
		@Override
		public void playerInfo() {
			System.out.println("PlayerInfo overriden");
		}
	}
	
 
public class TemplateDemo
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TemplateMethods obj1=new PlayerInfoImpl();
		TemplateMethods obj2=new PlayersImpl();
		obj1.completeTeam();
		obj2.completeTeam();
 
	}
 
}
 
 