package com.lodz.android.litepaldemo.db.table

import org.litepal.annotation.Column
import org.litepal.crud.LitePalSupport

/**
 * 歌曲
 * @author zhouL
 * @date 2020/8/4
 */
class SongTable : LitePalSupport(){

    @Column(nullable = false)
    var name = ""

    var duration = 0

    var album : AlbumTable? = null

    @Column(ignore = true)
    var uselessField = ""

}