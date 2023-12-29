/*
 * Copyright (C) 2020 Arseniy Graur
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.example.cloudnotes.entities

import android.graphics.Color
import android.provider.BaseColumns

/**
 * Note entity
 */
class Note {
    // Main variables
    private var title: String
    private var body: String
    private var id:String


    /**
     * @param title Note title
     * @param value Note content
     */


    /**
     * @param title Note title
     * @param value Note content
     * @param color Color in int format
     */


    /**
     * @param title Note title
     * @param value Note content
     * @param color Color in int format
     * @param time Time in Long format
     */
    constructor(title: String, body: String, id:String) {
        this.title = title
        this.body = body
        this.id = id

    }

    /**
     * Sets title and returns Note object
     * @param title
     * @return Object of Note type
     */
    fun setTitle(title: String): Note {
        this.title = title
        return this
    }

    /**
     * Sets value and returns Note object
     * @param value
     * @return Object of Note type
     */
    fun setBody(body: String): Note {
        this.body = body
        return this
    }

    /**
     * Sets color and returns Note object
     * @param color
     * @return Object of Note type
     */


    /**
     * Sets time and returns Note object
     * @param time
     * @return Object of Note type
     */

    fun setId(id: String): Note {
        this.id = id
        return this
    }

    /**
     * @return Note title
     */
    fun getTitle(): String {
        return title
    }

    /**
     * @return Note content
     */
    fun getBody(): String {
        return body
    }

    /**
     * @return Note color in int format
     */

    /**
     * @return Note creation time in Long format
     */

    fun getId(): String {
        return id
    }
}