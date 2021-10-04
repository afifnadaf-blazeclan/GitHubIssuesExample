package com.android.githubissuesrepository.utils

import android.view.View

/**
 * Created by Afif Nadaf on 03/10/21.
 */

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}