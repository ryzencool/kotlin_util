package com.zmy.springboot.kotlin_pro.netty

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelInitializer
import io.netty.channel.oio.OioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.oio.OioServerSocketChannel
import java.net.InetSocketAddress
import java.nio.charset.Charset

class OIOServer {
    fun server(port: Int) {
        val buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")))
        val group = OioEventLoopGroup()
        try {
            val b = ServerBootstrap()
            b.group(group)
                    .channel(OioServerSocketChannel::class.java)
                    .localAddress(InetSocketAddress(9999))
                    .childHandler(
                            object : ChannelInitializer<SocketChannel>() {
                                override fun initChannel(p0: SocketChannel?) {
                                    p0?.pipeline()?.addLast(
                                            object : ChannelInboundHandlerAdapter() {
                                                override fun channelActive(ctx: ChannelHandlerContext?) {
                                                    ctx?.writeAndFlush(buf.duplicate())?.addListener {
                                                        ChannelFutureListener.CLOSE
                                                    }
                                                }
                                            }
                                    )
                                }
                            })
            val future = b.bind().sync()
            future.channel().closeFuture().sync()
        } finally {
            group.shutdownGracefully().sync()
        }
    }
}