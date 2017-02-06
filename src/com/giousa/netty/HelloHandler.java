package com.giousa.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

public class HelloHandler extends SimpleChannelHandler {

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		
		System.out.println("channelClosed");
		super.channelClosed(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		
		System.out.println("channelConnected");
		super.channelConnected(ctx, e);
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		
		System.out.println("channelDisconnected");
		super.channelDisconnected(ctx, e);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		
		System.out.println("exceptionCaught");
		super.exceptionCaught(ctx, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		
//		System.out.println("messageReceived");
//		System.out.println("e="+e.getMessage());
//		ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
//		String s = new String(buffer.array());
//		System.out.println("message:"+s);
		String string = (String) e.getMessage();
		System.out.println("服务端获取数据："+string);
		
		//回写数据
//		ChannelBuffer copiedBuffer = ChannelBuffers.copiedBuffer("Server服务端数据!".getBytes());
//		ctx.getChannel().write(copiedBuffer);
		
		ctx.getChannel().write("Server发送数据："+string);
		super.messageReceived(ctx, e);
	}
	
}
