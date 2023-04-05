package main

import (
	"bufio"
	"fmt"
	"net"
	"strings"
)

func main() {
	ln, _ := net.Listen("tcp", ":3333")

	fmt.Println("Aguardando conexões...")

	for {
		conn, _ := ln.Accept()

		msg, _ := bufio.NewReader(conn).ReadString('\n')
		msgStr := string(msg)
		fmt.Print("Recebeu: ", msgStr)

		fmt.Fprintln(conn, strings.ToUpper(msgStr))
	}

}
