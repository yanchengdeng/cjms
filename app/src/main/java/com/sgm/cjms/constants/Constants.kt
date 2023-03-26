package com.sgm.cjms.constants

/**
 * @Author: yancheng
 * @Date: 2023/3/15 23:35
 * @Description:
 */

object Constants {
    // 所有debug 开关设置
    const val DEBUG = true



    //网页登录地址  测试账号 寒武蚂蚁:
    const val WEB_LOGIN_URL = "http://sgm-stg.broker.ap1.covapp.io/fed/app/idp.saml20?entityID=https://spdev.saic-gm.com/spsaml20/rfid&TARGET=https://spdev.saic-gm.com/spsaml20/rfid"

    //加载到这个关键字则可以截取 token  如： https://rfid-native-api.apps-qa.saic-gm.com/?x-mid-token=97ae097e-e1d6-4617-883f-817a5c008b32
    const val WEB_LOAD_URL_KEY = "x-mid-token="

    //加载到登录页 https://sgm-stg.login.ap1.covapp.io/login.do?host=https://sgm-stg.broker.ap1.covapp.io&ct_orig_uri=%2Ffed%2Fapp%2Fidp.saml20%3FentityID%3Dhttps%3A%2F%2Fspdev.saic-gm.com%2Fspsaml20%2Frfid%26TARGET%3Dhttps%3A%2F%2Fspdev.saic-gm.com%2Fspsaml20%2Frfid
    const val LOAD_LOGIN_UI = "login.do?host"

    //登录后验证....
    //https://sgm-stg.broker.ap1.covapp.io/fed/app/idp.saml20?entityID=https://spdev.saic-gm.com/spsaml20/rfid&TARGET=https://spdev.saic-gm.com/spsaml20/rfid
    const val LOAD_LOGIN_VALID = "sgm-stg.broker.ap1.covapp.io/fed/app"


    //传递数据

    const val PASS_JSON = "PASS_JSON"

    //分页
    const val  PAGE_SIZE = 15










}