package subway.solution1

/**
 * Created by zhangll on 2017/2/8.
 */
object StationData {
    private val line1 = linkedSetOf(
            "富锦路",
            "友谊西路",
            "宝安公路",
            "共富新村",
            "呼兰路",
            "通河新村",
            "共康路",
            "彭浦新村",
            "汶水路",
            "上海马戏城",
            "延长路",
            "中山北路",
            "上海火车站",
            "汉中路",
            "新闸路",
            "人民广场",
            "黄陂南路",
            "陕西南路",
            "常熟路",
            "衡山路",
            "徐家汇",
            "上海体育馆",
            "漕宝路",
            "上海南站",
            "锦江乐园",
            "莲花路",
            "外环路",
            "莘庄"
    )

    private val line2 = linkedSetOf(
            "徐泾东",
            "虹桥火车站",
            "虹桥2号航站楼",
            "淞虹路",
            "北新泾",
            "威宁路",
            "娄山关路",
            "中山公园",
            "江苏路",
            "静安寺",
            "南京西路",
            "人民广场",
            "南京东路",
            "陆家嘴",
            "东昌路",
            "世纪大道",
            "上海科技馆",
            "世纪公园",
            "龙阳路",
            "张江高科",
            "金科路",
            "广兰路",
            "唐镇",
            "创新中路",
            "华夏东路",
            "川沙",
            "凌空路",
            "远东大道",
            "海天三路",
            "浦东国际机场"
    )

    private val line3 = linkedSetOf(
            "江杨北路",
            "铁力路",
            "友谊路",
            "宝杨路",
            "水产路",
            "淞滨路",
            "张华浜",
            "淞发路",
            "长江南路",
            "殷高西路",
            "江湾镇",
            "大柏树",
            "赤峰路",
            "虹口足球场",
            "东宝兴路",
            "宝山路",
            "上海火车站",
            "中潭路",
            "镇坪路",
            "曹杨路",
            "金沙江路",
            "中山公园",
            "延安西路",
            "虹桥路",
            "宜山路",
            "漕溪路",
            "龙漕路",
            "石龙路",
            "上海南站"
    )

    private val line4 = linkedSetOf(
            "宜山路",
            "上海体育馆",
            "上海体育场",
            "东安路",
            "大木桥路",
            "鲁班路",
            "西藏南路",
            "南浦大桥",
            "塘桥",
            "蓝村路",
            "浦电路",
            "世纪大道",
            "浦东大道",
            "杨树浦路",
            "大连路",
            "临平路",
            "海伦路",
            "宝山路",
            "上海火车站",
            "中潭路",
            "镇坪路",
            "曹杨路",
            "金沙江路",
            "中山公园",
            "延安西路",
            "虹桥路",
            "宜山路"
    )

    private val line5 = linkedSetOf(
            "莘庄",
            "春申路",
            "银都路",
            "额桥",
            "北桥",
            "剑川路",
            "东川路",
            "金平路",
            "华宁路",
            "文井路",
            "闵行开发区"
    )

    private val line6 = linkedSetOf(
            "东方体育中心",
            "灵岩南路",
            "上南路",
            "华夏西路",
            "高青路",
            "东明路",
            "高科西路",
            "临沂新村",
            "上海儿童医学中心",
            "蓝村路",
            "浦电路",
            "世纪大道",
            "源深体育中心",
            "民生路",
            "北洋泾路",
            "德平路",
            "云山路",
            "金桥路",
            "博兴路",
            "五莲路",
            "巨峰路",
            "东靖路",
            "五洲大道",
            "洲海路",
            "外高桥保税区南",
            "航津路",
            "外高桥保税区北",
            "港城路"
    )

    private val line7 = linkedSetOf(
            "美兰湖",
            "罗南新村",
            "潘广路",
            "刘行",
            "顾村公园",
            "祁华路",
            "上海大学",
            "南陈路",
            "上大路",
            "场中路",
            "大场镇",
            "行知路",
            "大华三路",
            "新村路",
            "岚皋路",
            "镇坪路",
            "长寿路",
            "昌平路",
            "静安寺",
            "常熟路",
            "肇家浜路",
            "东安路",
            "龙华中路",
            "后滩",
            "长清路",
            "耀华路",
            "云台路",
            "高科西路",
            "杨高南路",
            "锦绣路",
            "芳华路",
            "龙阳路",
            "花木路"
    )

    private val line8 = linkedSetOf(
            "市光路",
            "嫩江路",
            "翔殷路",
            "黄兴公园",
            "延吉中路",
            "黄兴路",
            "江浦路",
            "鞍山新村",
            "四平路",
            "曲阳路",
            "虹口足球场",
            "西藏北路",
            "中兴路",
            "曲阜路",
            "人民广场",
            "大世界",
            "老西门",
            "陆家浜路",
            "西藏南路",
            "中华艺术宫",
            "耀华路",
            "成山路",
            "杨思",
            "东方体育中心",
            "凌兆新村",
            "芦恒路",
            "浦江镇",
            "江月路",
            "联航路",
            "沈杜公路"
    )

    private val line9 = linkedSetOf(
            "杨高中路",
            "世纪大道",
            "商城路",
            "小南门",
            "陆家浜路",
            "马当路",
            "打浦桥",
            "嘉善路",
            "肇家浜路",
            "徐家汇",
            "宜山路",
            "桂林路",
            "漕河泾开发区",
            "合川路",
            "星中路",
            "七宝",
            "中春路",
            "九亭",
            "泗泾",
            "佘山",
            "洞泾",
            "松江大学城",
            "松江新城",
            "松江体育中心",
            "醉白池",
            "送江南站"
    )

    private val line10 = linkedSetOf(
            "新江湾城",
            "殷高东路",
            "三门路",
            "江湾体育场",
            "五角场",
            "国权路",
            "同济大学",
            "四平路",
            "邮电新村",
            "海伦路",
            "四川北路",
            "天潼路",
            "南京东路",
            "豫园",
            "老西门",
            "新天地",
            "陕西南路",
            "上海图书馆",
            "交通大学",
            "虹桥路",
            "宋园路",
            "伊犁路",
            "水城路",
            "龙溪路",

            "上海动物园",
            "虹桥1号航站楼",
            "虹桥2号航站楼",
            "虹桥火车站"
    )

    private val line11 = linkedSetOf(
            "迪士尼",
            "康新公路",
            "秀沿路",
            "罗山路",
            "御桥",
            "浦三路",
            "三林东",
            "三林",
            "东方体育中心",
            "龙耀路",
            "云锦路",
            "龙华",
            "上海游泳馆",
            "徐家汇",
            "交通大学",
            "江苏路",
            "隆德路",
            "曹杨路",
            "枫桥路",
            "真如",
            "上海西站",
            "李子园",
            "祁连山路",
            "武威路",
            "桃浦新村",
            "南翔",
            "马陆",
            "嘉定新城",

            "上海赛车场",
            "昌吉东路",
            "上海汽车城",
            "安亭",
            "兆丰路",
            "光明路",
            "花桥"
    )

    private val line12 = linkedSetOf(
            "金海路",
            "申江路",
            "金京路",
            "杨高北路",
            "巨峰路",
            "东陆路",
            "复兴岛",
            "爱国路",
            "隆昌路",
            "宁国路",
            "江浦公园",
            "大连路",
            "提篮桥",
            "国际客运中心",
            "天潼路",
            "曲阜路",
            "汉中路",
            "南京西路",
            "陕西南路",
            "嘉善路",
            "大木桥路",
            "龙华中路",
            "龙华",
            "龙漕路",
            "漕宝路",
            "桂林公园",
            "虹漕路",
            "虹梅路",
            "东联路",
            "顾戴路",
            "虹莘路",
            "七莘路"
    )

    private val line13 = linkedSetOf(
            "世博大道",
            "世博会博物馆",
            "马当路",
            "新天地",
            "淮海中路",
            "南京西路",
            "自然博物馆",
            "汉中路",
            "江宁路",
            "长寿路",
            "武宁路",
            "隆德路",
            "金沙江路",
            "大渡河路",
            "真北路",
            "祁连山南路",
            "丰庄",
            "金沙江西路",
            "金运路"
    )

    private val line16 = linkedSetOf(
            "龙阳路",
            "华夏中路",
            "罗山路",
            "周浦东",
            "鹤沙航城",
            "航头东",
            "新场",
            "野生动物园",
            "惠南",
            "惠南东",
            "书院",
            "临港大道",
            "滴水湖"
    )

    private val lines = mutableListOf(
            "line1" to line1,
            "line2" to line2,
            "line3" to line3,
            "line4" to line4,
            "line5" to line5,
            "line6" to line6,
            "line7" to line7,
            "line8" to line8,
            "line9" to line9,
            "line10" to line10,
            "line11" to line11,
            "line12" to line12,
            "line13" to line13,
            "line16" to line16
    )

    val trainLines = mutableListOf<TrainLine>()

    init {
        for (line in lines) {
            val trainLine = TrainLine(line.first)
            for (station in line.second) {
                trainLine.putStation(station)
            }
            trainLines.add(trainLine)
        }
    }
}