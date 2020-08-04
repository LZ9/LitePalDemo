package com.lodz.android.litepaldemo.db.table

import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport
import java.util.*
import kotlin.collections.ArrayList

/**
 * 专辑
 * @author zhouL
 * @date 2020/8/4
 */
class AlbumTable : LitePalSupport() {

    var id = 0

    @Column(unique = true)
    var name = ""

    var price = 0.0f

    var songs = ArrayList<SongTable>()

    var date: Date? = null
}