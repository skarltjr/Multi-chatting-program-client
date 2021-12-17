import java.net.Socket
import java.util.*

class Main {
    companion object {
        const val PORT = 8080
    }
}
fun main(args: Array<String>) {
    val username: String
    println("닉네임을 입력해주세요")
    val scanner = Scanner(System.`in`)
    username = scanner.nextLine()
    try {
        //socket and connect
        val socket: Socket = Socket("localhost", Main.PORT)
        val sender: SenderThread = SenderThread(socket,username)
        val receiver: ReceiveThread = ReceiveThread(socket)

        sender.start()
        receiver.start()
    } catch (e: Exception) {

    }
}