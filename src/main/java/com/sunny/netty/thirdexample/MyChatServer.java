/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.netty.thirdexample;

import com.sunny.netty.firstexample.TestServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.netty.thirdexample.MyChatServer
 * @date: 2018-10-23 13:43
 * @des:
 */
public class MyChatServer {
    public static void main(String[] args) throws InterruptedException {
        //接收链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //业务处理
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyChatServerInitializer());
            //绑定端口
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            //关闭监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            //关闭事件循环组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
