package com.xuyang.algorithm.interview;

/**
 * @Auther: allanyang
 * @Date: 2020/1/13 20:56
 * @Description:
 **/
public class 网络 {

    // 1.tcp和udp的区别
    /**
     * 1.tcp是面向连接的，udp是面向非连接的。
     * 2.tcp是可靠的，udp是最大努力交付
     * 3.tcp是面向字节流的，udp是面向报文的。
     * 4.tcp是一对一，udp是一对多。
     * 5.tco首部开销大，20字节，udp首部开销小，8字节。3050
     */

    // 2.为什么tcp是可靠的传输
    /**
     * 1.序号。
     * 2.确认。
     * 3.重传。
     */

    // 3.三次握手和四次挥手过程
    /**
     * 三次握手：
     * 1.客户端发送SYN，服务端收到后发送ACK和SYN，客户端再次受到后发送ACK。
     * 四次挥手:
     * 1.客户端发送FIN，服务端收到后发送给ACK。
     * 2.此时只可以服务端向客户端发送请求。
     * 3.服务端发送FIN，客户端收到后发送ACK。
     * 4.客户端等待2MSL时间后CLOSE。（防止服务端没有收到而关闭失败）
     */

    // 4.为什么3次握手
    /**
     * 1.为什么不用2次握手：
     *    如果采用两次握手，则会发生客户端发送SYN1到服务端，此时网络不好，而客户端因为没有收到ACK1而再次发送SYN2，此时建立了连接。
     * 之后某个时间断开连接。之后SYN1又到了服务端，此时又建立了无效的连接。
     * 2.为什么不用4次握手：
     *    因为3次可以解决，没有必要多一次多余的动作。
     */

    // 5.为什么4次挥手
    /**
     * 因为客户端发起关闭连接请求，而此时服务端还不想关闭，他仍要发送数据，如果三次挥挥手的话服务端就不能再次发送数据了。
     */

    // 5.为什么要等待2MSL
    /**
     * 若不等待2SML，则客户端已经关闭，但是因为网络原因没有发送过去，造成服务端资源浪费。（服务端关闭连接一般都比客户端早一些，因为客户端要等待2MSL时间。）
     */

    // 6.对称加密和非对称加密
    /**
     * 对称加密：
     * 加密和解密使用的是同样的密钥。
     * 对称加密的一大缺点就是密钥的管理与分配，也就是如何把密钥发送到需要解密人的手里。发送过程中可能会被拦截或篡改。因此通常需要将对称加密的密钥进行非对称加密，然后传送给需要密钥的人手中。
     *
     * 非对称加密：
     * 非对称加密使用一对密钥，公钥和私钥。私钥只能由一方保管，不能外泄，而公钥可以发送给任何请求他的人。非对称加密
     * 使用其中一个加密，另一个解密。比如你想银行请求公钥，银行给你后，你将信息加密后只有持有私钥的一方（银行）才能对你的消息解密。
     * 而银行不会将私钥通过网络发送出去，因此安全性大大提高。但是非对称加密很慢。
     *
     * 混合加密：
     * 1.小A需要在银行做一笔交易，他的浏览器首先生成了一个随机数作为对称密钥。
     * 2.小A的浏览器向银行请求公钥。
     * 3.银行将公钥发给小A。
     * 4.小A的浏览器将银行的公钥将自己的对称密钥加密。
     * 5.小A的浏览器加密后发送给银行。
     * 6.银行使用私钥解密，得到对称密钥。
     * 7.小A可以和银行来进行对称加密沟通了。
     */


    // 7.http和https的区别
    /**
     * 1.http是不安全的，用明文传输，而https是http+ssl协议，是加密安全传输,是安全的，中间会申请整数.
     * 2.http是80端口,https是443端口.
     */
}
