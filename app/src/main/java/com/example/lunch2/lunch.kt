package com.example.lunch2


import com.squareup.moshi.Json

data class lunch(
    @field:Json(name = "mealServiceDietInfo")
    val mealServiceDietInfo: List<MealServiceDietInfo>?
)

data class MealServiceDietInfo(
    @field:Json(name = "head")
    val head: List<Head>?,
    @field:Json(name = "row")
    val row: List<Row>?
)

data class Head(
    @field:Json(name = "list_total_count")
    val listTotalCount: Int?,
    @field:Json(name = "RESULT")
    val rESULT: RESULT?
)

data class RESULT(
    @field:Json(name = "CODE")
    val cODE: String?,
    @field:Json(name = "MESSAGE")
    val mESSAGE: String?
)

data class Row(
    @field:Json(name = "ATPT_OFCDC_SC_CODE")
    val aTPTOFCDCSCCODE: String?, //시도교육청코드
    @field:Json(name = "ATPT_OFCDC_SC_NM")
    val aTPTOFCDCSCNM: String?, // 시도교육청명
    @field:Json(name = "CAL_INFO")
    val cALINFO: String?, //표준학교코드
    @field:Json(name = "DDISH_NM")
    val dDISHNM: String?, // 학교명
    @field:Json(name = "MLSV_FGR")
    val mLSVFGR: String?, //식사코드
    @field:Json(name = "MLSV_FROM_YMD")
    val mLSVFROMYMD: String?, //식사명
    @field:Json(name = "MLSV_TO_YMD")
    val mLSVTOYMD: String?, //급식일자
    @field:Json(name = "MLSV_YMD")
    val mLSVYMD: String?, //급식인원수
    @field:Json(name = "MMEAL_SC_CODE")
    val mMEALSCCODE: String?, //요리명
    @field:Json(name = "MMEAL_SC_NM")
    val mMEALSCNM: String?, //원산지정보
    @field:Json(name = "NTR_INFO")
    val nTRINFO: String?, //칼로리정보
    @field:Json(name = "ORPLC_INFO")
    val oRPLCINFO: String?, //영양정보
    @field:Json(name = "SCHUL_NM")
    val sCHULNM: String?, //급식시작일자
    @field:Json(name = "SD_SCHUL_CODE")
    val sDSCHULCODE: String? //급식시작일자
)

