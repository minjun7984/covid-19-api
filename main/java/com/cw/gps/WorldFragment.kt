package com.capstonedesign.coring

import android.graphics.Typeface
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_state2.*
import kotlinx.android.synthetic.main.fragment_state2.gyeonggi
import kotlinx.android.synthetic.main.fragment_state2.incheon
import kotlinx.android.synthetic.main.fragment_state2.seoul
import kotlinx.android.synthetic.main.fragment_world.*
import org.w3c.dom.Element
import java.lang.Exception
import java.net.URL
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.xml.parsers.DocumentBuilderFactory


class WorldFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_world, container, false)
        val korea: TextView = view.findViewById(R.id.korea)
        val koreaDC: TextView = view.findViewById(R.id.koreaDC)
        val koreaDT: TextView = view.findViewById(R.id.koreaDT)

        val china: TextView = view.findViewById(R.id.china)
        val chinaDC: TextView = view.findViewById(R.id.chinaDC)
        val chinaDT: TextView = view.findViewById(R.id.chinaDT)

        val japan: TextView = view.findViewById(R.id.japan)
        val japanDC: TextView = view.findViewById(R.id.japanDC)
        val japanDT: TextView = view.findViewById(R.id.japanDT)

        val singapol: TextView = view.findViewById(R.id.singapol)
        val singapolDC: TextView = view.findViewById(R.id.singapolDC)
        val singapolDT: TextView = view.findViewById(R.id.singapolDT)

        val usa: TextView = view.findViewById(R.id.usa)
        val usaDC: TextView = view.findViewById(R.id.usaDC)
        val usaDT: TextView = view.findViewById(R.id.usaDT)

        val brazil: TextView = view.findViewById(R.id.brazil)
        val brazilDC: TextView = view.findViewById(R.id.brazilDC)
        val brazilDT: TextView = view.findViewById(R.id.brazilDT)

        val uk: TextView = view.findViewById(R.id.uk)
        val ukDC: TextView = view.findViewById(R.id.ukDC)
        val ukDT: TextView = view.findViewById(R.id.ukDT)

        val germany: TextView = view.findViewById(R.id.germany)
        val germanyDC: TextView = view.findViewById(R.id.germanyDC)
        val germanyDT: TextView = view.findViewById(R.id.germanyDT)

        val italy: TextView = view.findViewById(R.id.italy)
        val italyDC: TextView = view.findViewById(R.id.italyDC)
        val italyDT: TextView = view.findViewById(R.id.italyDT)

        val france: TextView = view.findViewById(R.id.france)
        val franceDC: TextView = view.findViewById(R.id.franceDC)
        val franceDT: TextView = view.findViewById(R.id.franceDT)

        val canada: TextView = view.findViewById(R.id.canada)
        val canadaDC: TextView = view.findViewById(R.id.canadaDC)
        val canadaDT: TextView = view.findViewById(R.id.canadaDT)

        val hongkong: TextView = view.findViewById(R.id.hongkong)
        val hongkongDC: TextView = view.findViewById(R.id.hongkongDC)
        val hongkongDT: TextView = view.findViewById(R.id.hongkongDT)









        val LocalityCo = TTT()
        LocalityCo.start()

        return view

    }

    inner class TTT : Thread() {
        override fun run() {

            val DF = DecimalFormat("#,###")
            val TDdecide = IntArray(400)
            var decideCnt: Int =0
            val TDdeath = IntArray(400)
            val TDisoLing = IntArray(2)
            val Calc_decide = IntArray(2, { 0 })   //?????? ?????? ???????????? ?????? ?????? ?????? (?????????)


            val serviceKey =
                "AXeLGdsDBA%2FWzCVWg0HRsxVHmQmjrsV8IPtApa3FtNTjhu0BlTgAcm31LL5tjPyAX0fwrReI0HAyk%2B%2F2TJyO%2Bg%3D%3D" //?????????
            //?????????
            val GetDate: LocalDateTime =
                LocalDateTime.now()                               //?????? ??????,?????? ????????????
            val DateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")     //?????? ?????? ??????
            val EndDT = GetDate.minusHours(9).format(DateFormatter)  //?????? ???????????? 9?????? ??????, API ?????? ?????????
            val StartDT = GetDate.minusDays(1).minusHours(9).format(DateFormatter)  //?????? ??????
            println(EndDT)
            println(StartDT)
            try {
                // ????????? ???????????? ??????
                var Call =
                    "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson?serviceKey=" + serviceKey + "&startCreateDt=" + StartDT + "&endCreateDt=" + EndDT
                var url = URL(Call)
                var conn = url.openConnection()
                var input = conn.getInputStream()

                var factory = DocumentBuilderFactory.newInstance()
                var builder = factory.newDocumentBuilder()
                // doc: xml????????? ?????? ???????????? ????????? ??????
                var doc = builder.parse(input)

                // root: xml ????????? ?????? ??????????????? ?????? ?????? ??????
                var root = doc.documentElement
                val Error_Code = Integer.parseInt(
                    (root.getElementsByTagName("resultCode").item(0) as Element).textContent
                )

                if (Error_Code == 99) {
                    Log.e("Corona API", "LIMITED NUMBER OF SERVICE REQUESTS EXCEEDS ERROR")
                    Log.e("Corona API", "Call New ServiceKey")      //????????? ????????? ?????? ????????????

                    val NEWserviceKey =
                        "ZwE%2FgW3myZ8WHn%2FcIFEg7Od%2Bd7GLP3mK5pIGlbRhn%2FGJGsSb1AxPgzQpboFwHKTmvFErprAfbTRiAO9HOFKx0g%3D%3D"
                    Call =
                        "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson?serviceKey=" + NEWserviceKey + "&startCreateDt=" + StartDT + "&endCreateDt=" + EndDT
                    url = URL(Call)
                    conn = url.openConnection()
                    input = conn.getInputStream()
                    Log.d("Corona API(New Key)", "Start url openConnection")

                    factory = DocumentBuilderFactory.newInstance()
                    builder = factory.newDocumentBuilder()
                    // doc: xml????????? ?????? ???????????? ????????? ??????
                    doc = builder.parse(input)
                    Log.d("Corona API(New Key)", "XML read")

                    // root: xml ????????? ?????? ??????????????? ?????? ?????? ??????
                    root = doc.documentElement
                }
                // xml ???????????? ?????? ????????? item??? ???????????? item_node_list??? ???????????? ??????
                val item_node_list = root.getElementsByTagName("item") //19???

                // item_node_list??? ???????????? ?????? ?????? ????????? ?????????
                for (i in 0 until item_node_list.length) {
                    // i?????? ?????? ????????? item_element??? ??????
                    val item_element = item_node_list.item(i) as Element
                    // item?????? ???????????? ????????? ???????????? ??????????????? ???????????? ???????????? ?????????
                    // xml ????????? ?????? ???????????? ???????????? ???????????? ????????? ???????????? ??????


                    val incDec_list = item_element.getElementsByTagName("natDefCnt") //??????
                    val incDet_list = item_element.getElementsByTagName("natDeathCnt")
                    //val isolClearCnt_list = item_element.getElementsByTagName("isolClearCnt") //????????????
                    //val deathCnt_list = item_element.getElementsByTagName("deathCnt")
                    // val isoLingCnt_list = item_element.getElementsByTagName("isolClearCnt") //

                    val incDec_node = incDec_list.item(0) as Element
                    val incDet_node = incDet_list.item(0) as Element
                    //val isoLingCnt_node = isoLingCnt_list.item(0) as Element
                    // val isolClearCnt_node = isolClearCnt_list.item(0) as Element


                    // ?????? ????????? ?????? ???????????? ????????? ?????? ??????

                    val incDec = incDec_node.textContent
                    val incDet = incDet_node.textContent
                    //val isoLingCnt = isoLingCnt_node.textContent
                    // val isolclearCnt = isolClearCnt_node.textContent

                    //val intgubun = Integer.parseInt(gubunCnt)
                    val intincDec = Integer.parseInt(incDec)
                    val intincDet = Integer.parseInt(incDet)
                    //val intdeath = Integer.parseInt(deathCnt)//int ?????? ?????????\
                    //val intisoLing = Integer.parseInt(isoLingCnt)
                    // val intclear = Integer.parseInt(isolclearCnt)


                    TDdecide.set(i, intincDec)
                    TDdeath.set(i, intincDet)

                    //TDdeath.set(0, intdeath)
                    //TDisoLing.set(0, intisoLing)


                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            //val Today = TDexam[0]
            val koreaincDec = TDdecide[189] // ????????????
            val koreaincDet = TDdeath[189]

            var chinaincDec = TDdecide[188]
            var chinaincDet = TDdeath[188]// ??????

            var japanincDec = TDdecide[184] //??????
            var japanincDet = TDdeath[184]

            var singapolincDec = TDdecide[183] //?????????
            var singapolincDet = TDdeath[183]

            var hongkongincDec = TDdecide[187] //??????
            var hongkongincDet = TDdeath[187]

            var ukincDec = TDdecide[103] //??????
            var ukincDet = TDdeath[103]

            var germanyincDec = TDdecide[105]//??????
            var germanyincDet = TDdeath[105]

            var franceincDec = TDdecide[104]//?????????
            var franceincDet = TDdeath[104]

            var italyincDec = TDdecide[106]//????????????
            var italyincDet = TDdeath[106]

            var brazilincDec = TDdecide[118]//?????????
            var brazilincDet = TDdeath[118]

            var usaincDec = TDdecide[141]//??????
            var usaincDet = TDdeath[141]

            var canadaincDec = TDdecide[140]//?????????
            var canadaincDet = TDdeath[140]


            val TodayDecide1 = TDdecide[0]
            val TodayDecide = TDdecide[189] - TDdecide[379] //??????
            val TodayDecide2 = TDdecide[188] - TDdecide[378]//??????
            val TodayDecide3= TDdecide[187] - TDdecide[377] //??????
            val TodayDecide4= TDdecide[184] - TDdecide[374] //??????
            val TodayDecide5= TDdecide[183] - TDdecide[373] //????????????
            val TodayDecide6= TDdecide[103] - TDdecide[293] //??????
            val TodayDecide7= TDdecide[105] - TDdecide[295] //??????
            val TodayDecide8= TDdecide[104] - TDdecide[294] //?????????
            val TodayDecide9= TDdecide[106] - TDdecide[296] //????????????
            val TodayDecide10= TDdecide[118] - TDdecide[308] //?????????
            val TodayDecide11= TDdecide[141] - TDdecide[331]//??????
            val TodayDecide12= TDdecide[140] - TDdecide[330]//?????????

            val TodayDeath1 = TDdeath[141]-TDdeath[331]
            val TodayDeath2 = TDdeath[118]-TDdeath[308]
            val TodayDeath3 = TDdeath[103]-TDdeath[293]
            val TodayDeath4 = TDdeath[104]-TDdeath[294]
            val TodayDeath5 = TDdeath[105]-TDdeath[295]
            val TodayDeath6 = TDdeath[106]-TDdeath[296]
            val TodayDeath7 = TDdeath[140]-TDdeath[330]
            val TodayDeath8 = TDdeath[184]-TDdeath[374]
            val TodayDeath9 = TDdeath[189]-TDdeath[379]
            val TodayDeath10 = TDdeath[183]-TDdeath[373]
            val TodayDeath11 = TDdeath[188]-TDdeath[378]
            val TodayDeath12 = TDdeath[187]-TDdeath[377]

            runOnUiThread {
                val koreaDCView = SpannableString(DF.format(koreaincDec) + "\n" + DF.format(TodayDecide) + "???")
                val koreaDTView = SpannableString(DF.format(koreaincDet)+ "\n" + DF.format(TodayDeath9) + "???")
                val endkoreaDTCnt = 3 + DF.format(koreaincDet).length
                val endkoreaDCCnt = 3 + DF.format(koreaincDec).length
                koreaDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endkoreaDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                koreaDT.setText(koreaDTView)
                koreaDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endkoreaDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                koreaDC.setText(koreaDCView)

                val chinaDCView = SpannableString(DF.format(chinaincDec) + "\n" + DF.format(TodayDecide2) + "???")
                val chinaDTView = SpannableString(DF.format(chinaincDet)+ "\n" + DF.format(TodayDeath11) + "???")
                val endchinaDTCnt = 3 + DF.format(chinaincDet).length
                val endchinaDCCnt = 3 + DF.format(chinaincDec).length
                chinaDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endchinaDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                chinaDT.setText(chinaDTView)
                chinaDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endchinaDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                chinaDC.setText(chinaDCView)

                val japanDCView = SpannableString(DF.format(japanincDec) + "\n" + DF.format(TodayDecide4) + "???")
                val japanDTView = SpannableString(DF.format(japanincDet)+ "\n" + DF.format(TodayDeath8) + "???")
                val endjapanDTCnt = 3 + DF.format(japanincDet).length
                val endjapanDCCnt = 3 + DF.format(japanincDec).length
                japanDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endjapanDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                japanDT.setText(japanDTView)
                japanDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endjapanDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                japanDC.setText(japanDCView)

                val singapolDCView = SpannableString(DF.format(singapolincDec) + "\n" + DF.format(TodayDecide5) + "???")
                val singapolDTView = SpannableString(DF.format(singapolincDet)+ "\n" + DF.format(TodayDeath12) + "???")
                val endsingapolDTCnt = 3 + DF.format(singapolincDet).length
                val endsingapolDCCnt = 3 + DF.format(singapolincDec).length
                singapolDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endsingapolDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                singapolDT.setText(singapolDTView)
                singapolDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endsingapolDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                singapolDC.setText(singapolDCView)

                val usaDCView = SpannableString(DF.format(usaincDec) + "\n" + DF.format(TodayDecide11) + "???")
                val usaDTView = SpannableString(DF.format(usaincDet)+ "\n" + DF.format(TodayDeath1) + "???")
                val endusaDTCnt = 3 + DF.format(usaincDet).length
                val endusaDCCnt = 3 + DF.format(usaincDec).length
                usaDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endusaDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                usaDT.setText(usaDTView)
                usaDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endusaDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                usaDC.setText(usaDCView)

                val brazilDCView = SpannableString(DF.format(brazilincDec) + "\n" + DF.format(TodayDecide10) + "???")
                val brazilDTView = SpannableString(DF.format(brazilincDet)+ "\n" + DF.format(TodayDeath2) + "???")
                val endbrazilDTCnt = 3 + DF.format(brazilincDet).length
                val endbrazilDCCnt = 3 + DF.format(brazilincDec).length
                brazilDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endbrazilDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                brazilDT.setText(brazilDTView)
                brazilDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endbrazilDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                brazilDC.setText(brazilDCView)

                val ukDCView = SpannableString(DF.format(ukincDec) + "\n" + DF.format(TodayDecide6) + "???")
                val ukDTView = SpannableString(DF.format(ukincDet)+ "\n" + DF.format(TodayDeath3) + "???")
                val endukDTCnt = 3 + DF.format(ukincDet).length
                val endukDCCnt = 3 + DF.format(ukincDec).length
                ukDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endukDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                ukDT.setText(ukDTView)
                ukDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endukDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                ukDC.setText(ukDCView)

                val germanyDCView = SpannableString(DF.format(germanyincDec) + "\n" + DF.format(TodayDecide7) + "???")
                val germanyDTView = SpannableString(DF.format(germanyincDet)+ "\n" + DF.format(TodayDeath5) + "???")
                val endgermanyDTCnt = 3 + DF.format(germanyincDet).length
                val endgermanyDCCnt = 3 + DF.format(germanyincDec).length
                germanyDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endgermanyDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                germanyDT.setText(germanyDTView)
                germanyDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endgermanyDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                germanyDC.setText(germanyDCView)

                val franceDCView = SpannableString(DF.format(franceincDec) + "\n" + DF.format(TodayDecide8) + "???")
                val franceDTView = SpannableString(DF.format(franceincDet)+ "\n" + DF.format(TodayDeath4) + "???")
                val endfranceDTCnt = 3 + DF.format(franceincDet).length
                val endfranceDCCnt = 3 + DF.format(franceincDec).length
                franceDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endfranceDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                franceDT.setText(franceDTView)
                franceDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endfranceDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                franceDC.setText(franceDCView)

                val italyDCView = SpannableString(DF.format(italyincDec) + "\n" + DF.format(TodayDecide9) + "???")
                val italyDTView = SpannableString(DF.format(italyincDet)+ "\n" + DF.format(TodayDeath6) + "???")
                val enditalyDTCnt = 3 + DF.format(italyincDet).length
                val enditalyDCCnt = 3 + DF.format(italyincDec).length
                italyDTView.setSpan(StyleSpan(Typeface.BOLD), 0, enditalyDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                italyDT.setText(italyDTView)
                italyDCView.setSpan(StyleSpan(Typeface.BOLD), 0, enditalyDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                italyDC.setText(italyDCView)

                val canadaDCView = SpannableString(DF.format(canadaincDec) + "\n" + DF.format(TodayDecide12) + "???")
                val canadaDTView = SpannableString(DF.format(canadaincDet)+ "\n" + DF.format(TodayDeath7) + "???")
                val endcanadaDTCnt = 3 + DF.format(canadaincDet).length
                val endcanadaDCCnt = 3 + DF.format(canadaincDec).length
                canadaDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endcanadaDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                canadaDT.setText(canadaDTView)
                canadaDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endcanadaDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                canadaDC.setText(canadaDCView)

                val hongkongDCView = SpannableString(DF.format(hongkongincDec) + "\n" + DF.format(TodayDecide3) + "???")
                val hongkongDTView = SpannableString(DF.format(hongkongincDet)+ "\n" + DF.format(TodayDeath12) + "???")
                val endhongkongDTCnt = 3 + DF.format(hongkongincDet).length
                val endhongkongDCCnt = 3 + DF.format(hongkongincDec).length
                hongkongDTView.setSpan(StyleSpan(Typeface.BOLD), 0, endhongkongDTCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                hongkongDT.setText(hongkongDTView)
                hongkongDCView.setSpan(StyleSpan(Typeface.BOLD), 0, endhongkongDCCnt, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                hongkongDC.setText(hongkongDCView)








            }
        }
    }

    private fun runOnUiThread(action: () -> Unit) {
        this ?: return
        if (!isAdded) return // Fragment not attached to an Activity
        activity?.runOnUiThread(action)
    }
}