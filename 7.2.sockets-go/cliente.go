package main

import (
	"bufio"
	"fmt"
	"net"
)

func main() {
	conn, _ := net.Dial("tcp", "127.0.0.1:3333")
	fmt.Fprintf(conn, "msg do cliente\n")

	msg, _ := bufio.NewReader(conn).ReadString('\n')
	fmt.Print("Servidor enviou: ", msg)
}
