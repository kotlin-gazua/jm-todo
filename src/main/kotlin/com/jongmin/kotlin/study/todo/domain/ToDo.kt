package com.jongmin.kotlin.study.todo.domain

import java.time.OffsetDateTime

/**
 * @author pc
 * @since  2019. 01. 18
 */
data class ToDo(val id: Long, var title: String, var completedAt: OffsetDateTime? = null)