package network;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHttpServer {

	public static void main(String[] args) throws Exception {
		try (ServerSocket ss = new ServerSocket(8080)) {
			System.out.println("WebServer Ready!"); // server console 출력

			while (true) {
				try (Socket socket = ss.accept()) {

					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));

					String html = "<html><body><h1>Hello, SSAFY!</h1></body></html>";
					bw.write("HTTP/1.1 200 OK \r\n");
					bw.write("Content-Type: text/html;charset=utf-8\r\n");
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
