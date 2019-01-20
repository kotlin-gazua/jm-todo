package com.jongmin.kotlin.study.todo

import com.jongmin.kotlin.study.todo.component.CommandParser
import java.time.OffsetDateTime

fun main(args: Array<String>) {
  println("ls: list of item")
  println("mk: make todo item ex) mk [title]")
  println("rm: remove item ex) rm [id]")
  println("done: complete todo item")
  println("md: modify ex) md [new title]")
  println("exit: exit application")
  println()
  CommandParser().start()
}
