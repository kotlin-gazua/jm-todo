package com.jongmin.kotlin.study.todo.service

import com.jongmin.kotlin.study.todo.domain.ToDo
import com.jongmin.kotlin.study.todo.repository.InMemoryToDoDao
import java.time.OffsetDateTime

/**
 * @author Jongmin
 * @since  2019. 01. 19
 */
class ToDoService

val toDoDao = InMemoryToDoDao()

fun add(title: String): ToDo {
  return toDoDao.add(title)
}

fun remove(id: Long): Boolean {
  return toDoDao.remove(id)
}

fun done(id: Long): Boolean {
  return toDoDao.update(id, null, OffsetDateTime.now())
}

fun list(): MutableCollection<ToDo> {
  return toDoDao.list()
}