/**
 * Copyright(C) 2018 Hangzhou zhaoyunxing92 Technology Co., Ltd. All rights reserved.
 */
package com.sunny.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author zhaoyunxing92
 * @class: com.sunny.netty.TestHttpServerHandler
 * @date: 2018-10-19 19:08
 * @des:
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            ByteBuf content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            //设置头
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            //输出
            ctx.writeAndFlush(response);
        }

    }
}
