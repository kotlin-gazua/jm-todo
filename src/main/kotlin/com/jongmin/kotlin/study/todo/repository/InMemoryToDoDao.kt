package com.jongmin.kotlin.study.todo.repository

import com.jongmin.kotlin.study.todo.domain.ToDo
import java.time.OffsetDateTime
import java.util.concurrent.atomic.AtomicLong

/**
 * @author Jongmin
 * @since  2019. 01. 19
 */
class InMemoryToDoDao(val data: MutableMap<Long, ToDo> = mutableMapOf()) {
  private val idMaker = AtomicLong()

  fun get(id: Long): ToDo? {
    return data[id]
  }

  fun add(title: String): ToDo {
    val newItem = ToDo(idMaker.incrementAndGet(), title)
    data[newItem.id] = newItem
    return newItem
  }

  fun remove(id: Long): Boolean {
    val item: ToDo? = data[id]
    val result = item?.id != null
    if (result) {
      data.remove(id)
    }
    return result
  }

  fun update(id: Long, title: String?, completedAt: OffsetDateTime?): Boolean {
    val item: ToDo? = data[id]
    if (title != null) {
      item?.title = title
    }
    if (completedAt != null) {
      item?.completedAt = completedAt
    }
    return item?.id != null
  }

  fun list(): MutableCollection<ToDo> {
    return data.values
  }
}


