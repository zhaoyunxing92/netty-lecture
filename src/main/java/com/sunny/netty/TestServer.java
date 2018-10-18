/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.sunny.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;

/**
 * @author zhaoyunxing
 * @class: com.sunny.netty.TestServer
 * @date: 2018-10-19 01:50
 * @des:
 */
public class TestServer {
    public static void main(String[] args) {
        //接收链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //业务处理
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioSctpServerChannel.class)
                .childHandler(null);
    }
}
