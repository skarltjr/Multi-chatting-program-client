import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class SenderThread(
    socket: Socket, username: String
) : Thread() {
    var socket: Socket ?= null
    var username: String ?= null
    init {
        this.socket = socket
        this.username = username
    }
    override fun run() {
        try {
            val reader = BufferedReader(InputStreamReader(System.`in`))
            val printWriter = PrintWriter(socket?.getOutputStream())
            // username을 먼저 보내서 서버에서 sendAll로 ~님이 입장하였다는걸 알린다
            printWriter.println(username)
            printWriter.flush()
            while (true) {
                var message: String = reader.readLine()
                if (message.equals("quit")) {
                    break
                }
                printWriter.println(message)
                printWriter.flush()
            }
        } catch (e: Exception) {

        }finally {
            socket?.close()
        }
    }
}