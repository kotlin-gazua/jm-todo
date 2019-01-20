package com.jongmin.kotlin.study.todo.component

import com.jongmin.kotlin.study.todo.repository.InMemoryToDoDao
import java.time.OffsetDateTime
import java.util.*

/**
 * @author jnote
 * @since  2019. 01. 18
 */
class CommandParser {
  val toDoDao = InMemoryToDoDao()

  var run = true

  fun start() {
    while (run) {
      parse(Scanner(System.`in`).nextLine().split(" "))
    }
  }

  private fun parse(commands: List<String>) {
    when (commands[0]) {
      "ls" -> {
        toDoDao.list().forEach { println(it) }
      }
      "mk" -> {
        println(toDoDao.add(commands[1]))
      }
      "rm" -> {
        println(toDoDao.remove(commands[1].toLong()))
      }
      "done" -> {
        toDoDao.update(commands[1].toLong(), null, OffsetDateTime.now())
      }
      "md" -> {
        toDoDao.update(commands[1].toLong(), commands[2], null)
      }
      "exit" -> {
        run = false
      }
      else -> {
        println("not supported command: ${commands[0]}")
        println("ls: list of item")
        println("mk: make todo item ex) mk [title]")
        println("rm: remove item ex) rm [id]")
        println("done: complete todo item")
        println("md: modify ex) md [new title]")
        println("exit: exit application")
      }
    }
  }
}
