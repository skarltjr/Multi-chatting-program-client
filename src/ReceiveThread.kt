import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class ReceiveThread(
    socket: Socket
) : Thread() {
    var socket: Socket? = null

    init {
        this.socket = socket
    }

    override fun run() {
        try {
            val reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
            while (true) {
                var message = reader.readLine()
                if (message == null) {
                    break
                }
                println(message)
            }
        } catch (e: Exception) {

        }

    }
}