package com.example.flickerphotossearexample.common

class AppContextGoneException: Exception("App context is null, try calling init function of the " +
        "implementing class")