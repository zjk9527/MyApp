package com.zjk.my_app.entity;

import java.util.List;

/**
 * Created by zjk on 2017/5/25.
 * //所有汽车品牌
 */

public class Brand {

    /**
     * status : 0
     * msg : ok
     * result : [{"id":"1","name":"奥迪","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/1.png","depth":"1"},{"id":"2","name":"阿斯顿·马丁","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/2.png","depth":"1"},{"id":"3","name":"阿尔法·罗密欧","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/3.png","depth":"1"},{"id":"4","name":"AC Schnitzer","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/4.png","depth":"1"},{"id":"5","name":"Artega","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/5.png","depth":"1"},{"id":"6","name":"奥克斯","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/6.png","depth":"1"},{"id":"7","name":"本田","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/7.png","depth":"1"},{"id":"8","name":"别克","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/8.png","depth":"1"},{"id":"9","name":"奔驰","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/9.png","depth":"1"},{"id":"10","name":"宝马","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/10.png","depth":"1"},{"id":"11","name":"比亚迪","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/11.png","depth":"1"},{"id":"12","name":"宝骏","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/12.png","depth":"1"},{"id":"13","name":"标致","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/13.png","depth":"1"},{"id":"14","name":"北汽幻速","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/14.png","depth":"1"},{"id":"15","name":"保时捷","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/15.png","depth":"1"},{"id":"16","name":"北汽绅宝","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/16.png","depth":"1"},{"id":"17","name":"奔腾","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/17.png","depth":"1"},{"id":"18","name":"北京","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/18.png","depth":"1"},{"id":"19","name":"北汽威旺","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/19.png","depth":"1"},{"id":"20","name":"北汽制造","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/20.png","depth":"1"},{"id":"21","name":"宾利","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/21.png","depth":"1"},{"id":"22","name":"布加迪","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/22.png","depth":"1"},{"id":"23","name":"巴博斯","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/23.png","depth":"1"},{"id":"24","name":"宝沃","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/24.png","depth":"1"},{"id":"25","name":"北汽新能源","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/25.png","depth":"1"},{"id":"26","name":"保斐利","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/26.png","depth":"1"},{"id":"27","name":"宝龙","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/27.png","depth":"1"},{"id":"28","name":"长安汽车","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/28.png","depth":"1"},{"id":"29","name":"长安欧尚","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/29.png","depth":"1"},{"id":"30","name":"长城","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/30.png","depth":"1"},{"id":"31","name":"昌河","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/31.png","depth":"1"},{"id":"32","name":"长安跨越","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/32.png","depth":"1"},{"id":"33","name":"长城华冠","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/33.png","depth":"1"},{"id":"34","name":"成功","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/34.png","depth":"1"},{"id":"35","name":"长久汽车","initial":"C","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/35.png","depth":"1"},{"id":"36","name":"大众","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/36.png","depth":"1"},{"id":"37","name":"东风风行","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/37.png","depth":"1"},{"id":"38","name":"东风风神","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/38.png","depth":"1"},{"id":"39","name":"东南","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/39.png","depth":"1"},{"id":"40","name":"东风风光","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/40.png","depth":"1"},{"id":"41","name":"道奇","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/41.png","depth":"1"},{"id":"42","name":"DS","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/42.png","depth":"1"},{"id":"43","name":"东风小康","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/43.png","depth":"1"},{"id":"44","name":"东风·郑州日产","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/44.png","depth":"1"},{"id":"45","name":"东风御风","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/45.png","depth":"1"},{"id":"46","name":"东风风度","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/46.png","depth":"1"},{"id":"47","name":"东风","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/47.png","depth":"1"},{"id":"48","name":"底特律电动车","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/48.png","depth":"1"},{"id":"49","name":"大宇","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/49.png","depth":"1"},{"id":"50","name":"大迪","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/50.png","depth":"1"},{"id":"51","name":"丰田","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/51.png","depth":"1"},{"id":"52","name":"福特","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/52.png","depth":"1"},{"id":"53","name":"福田","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/53.png","depth":"1"},{"id":"54","name":"法拉利","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/54.png","depth":"1"},{"id":"55","name":"菲亚特","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/55.png","depth":"1"},{"id":"56","name":"福迪","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/56.png","depth":"1"},{"id":"57","name":"福汽启腾","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/57.png","depth":"1"},{"id":"58","name":"飞驰商务车","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/58.png","depth":"1"},{"id":"59","name":"Faralli Mazzanti","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/59.png","depth":"1"},{"id":"60","name":"菲斯克","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/60.png","depth":"1"},{"id":"61","name":"富奇","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/61.png","depth":"1"},{"id":"62","name":"福达","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/62.png","depth":"1"},{"id":"63","name":"广汽传祺","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/63.png","depth":"1"},{"id":"64","name":"观致汽车","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/64.png","depth":"1"},{"id":"65","name":"广汽吉奥","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/65.png","depth":"1"},{"id":"66","name":"GMC","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/66.png","depth":"1"},{"id":"67","name":"广汽中兴","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/67.png","depth":"1"},{"id":"68","name":"光冈","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/68.png","depth":"1"},{"id":"69","name":"GTA","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/69.png","depth":"1"},{"id":"70","name":"广汽日野","initial":"G","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/70.png","depth":"1"},{"id":"71","name":"哈弗","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/71.png","depth":"1"},{"id":"72","name":"海马","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/72.png","depth":"1"},{"id":"73","name":"红旗","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/73.png","depth":"1"},{"id":"74","name":"华泰","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/74.png","depth":"1"},{"id":"75","name":"悍马","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/75.png","depth":"1"},{"id":"76","name":"黄海","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/76.png","depth":"1"},{"id":"77","name":"哈飞","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/77.png","depth":"1"},{"id":"78","name":"海马商用车","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/78.png","depth":"1"},{"id":"79","name":"华颂","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/79.png","depth":"1"},{"id":"80","name":"华泰新能源","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/80.png","depth":"1"},{"id":"81","name":"海格","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/81.png","depth":"1"},{"id":"82","name":"汇众","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/82.png","depth":"1"},{"id":"83","name":"华普","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/83.png","depth":"1"},{"id":"84","name":"恒天汽车","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/84.png","depth":"1"},{"id":"85","name":"黑豹","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/85.png","depth":"1"},{"id":"86","name":"汉江","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/86.png","depth":"1"},{"id":"87","name":"航天圆通","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/87.png","depth":"1"},{"id":"88","name":"华阳","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/88.png","depth":"1"},{"id":"89","name":"吉利汽车","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/89.png","depth":"1"},{"id":"90","name":"江淮","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/90.png","depth":"1"},{"id":"91","name":"Jeep","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/91.png","depth":"1"},{"id":"92","name":"捷豹","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/92.png","depth":"1"},{"id":"93","name":"江铃","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/93.png","depth":"1"},{"id":"94","name":"金杯","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/94.png","depth":"1"},{"id":"95","name":"金龙","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/95.png","depth":"1"},{"id":"96","name":"九龙","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/96.png","depth":"1"},{"id":"97","name":"江铃集团轻汽","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/97.png","depth":"1"},{"id":"98","name":"金旅客车","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/98.png","depth":"1"},{"id":"99","name":"江南","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/99.png","depth":"1"},{"id":"100","name":"金程","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/100.png","depth":"1"},{"id":"101","name":"吉林江北","initial":"J","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/101.png","depth":"1"},{"id":"102","name":"凯迪拉克","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/102.png","depth":"1"},{"id":"103","name":"开瑞","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/103.png","depth":"1"},{"id":"104","name":"克莱斯勒","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/104.png","depth":"1"},{"id":"105","name":"凯翼","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/105.png","depth":"1"},{"id":"106","name":"卡威","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/106.png","depth":"1"},{"id":"107","name":"科尼赛克","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/107.png","depth":"1"},{"id":"108","name":"科瑞斯的","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/108.png","depth":"1"},{"id":"109","name":"康迪全球鹰电动汽车","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/109.png","depth":"1"},{"id":"110","name":"卡尔森","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/110.png","depth":"1"},{"id":"111","name":"KTM","initial":"K","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/111.png","depth":"1"},{"id":"112","name":"陆风","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/112.png","depth":"1"},{"id":"113","name":"铃木","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/113.png","depth":"1"},{"id":"114","name":"路虎","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/114.png","depth":"1"},{"id":"115","name":"雷克萨斯","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/115.png","depth":"1"},{"id":"116","name":"猎豹汽车","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/116.png","depth":"1"},{"id":"117","name":"雷诺","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/117.png","depth":"1"},{"id":"118","name":"林肯","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/118.png","depth":"1"},{"id":"119","name":"兰博基尼","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/119.png","depth":"1"},{"id":"120","name":"力帆","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/120.png","depth":"1"},{"id":"121","name":"劳斯莱斯","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/121.png","depth":"1"},{"id":"122","name":"莲花","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/122.png","depth":"1"},{"id":"123","name":"蓝海房车","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/123.png","depth":"1"},{"id":"124","name":"路特斯","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/124.png","depth":"1"},{"id":"125","name":"理念","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/125.png","depth":"1"},{"id":"126","name":"雷丁电动","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/126.png","depth":"1"},{"id":"127","name":"陆地方舟","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/127.png","depth":"1"},{"id":"128","name":"领志","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/128.png","depth":"1"},{"id":"129","name":"朗世","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/129.png","depth":"1"},{"id":"130","name":"罗孚","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/130.png","depth":"1"},{"id":"131","name":"马自达","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/131.png","depth":"1"},{"id":"132","name":"MG","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/132.png","depth":"1"},{"id":"133","name":"玛莎拉蒂","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/133.png","depth":"1"},{"id":"134","name":"MINI","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/134.png","depth":"1"},{"id":"135","name":"迈凯伦","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/135.png","depth":"1"},{"id":"136","name":"迈巴赫","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/136.png","depth":"1"},{"id":"137","name":"摩根","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/137.png","depth":"1"},{"id":"138","name":"美亚","initial":"M","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/138.png","depth":"1"},{"id":"139","name":"纳智捷","initial":"N","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/139.png","depth":"1"},{"id":"140","name":"Noble","initial":"N","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/140.png","depth":"1"},{"id":"141","name":"讴歌","initial":"O","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/141.png","depth":"1"},{"id":"142","name":"欧朗","initial":"O","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/142.png","depth":"1"},{"id":"143","name":"欧宝","initial":"O","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/143.png","depth":"1"},{"id":"144","name":"欧联","initial":"O","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/144.png","depth":"1"},{"id":"145","name":"帕加尼","initial":"P","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/145.png","depth":"1"},{"id":"146","name":"皮特比尔特卡车","initial":"P","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/146.png","depth":"1"},{"id":"147","name":"PGO","initial":"P","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/147.png","depth":"1"},{"id":"148","name":"旁蒂克","initial":"P","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/148.png","depth":"1"},{"id":"149","name":"起亚","initial":"Q","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/149.png","depth":"1"},{"id":"150","name":"奇瑞","initial":"Q","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/150.png","depth":"1"},{"id":"151","name":"启辰","initial":"Q","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/151.png","depth":"1"},{"id":"152","name":"庆铃","initial":"Q","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/152.png","depth":"1"},{"id":"153","name":"乔治·巴顿","initial":"Q","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/153.png","depth":"1"},{"id":"154","name":"日产","initial":"R","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/154.png","depth":"1"},{"id":"155","name":"荣威","initial":"R","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/155.png","depth":"1"},{"id":"156","name":"瑞麒","initial":"R","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/156.png","depth":"1"},{"id":"157","name":"斯柯达","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/157.png","depth":"1"},{"id":"158","name":"三菱","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/158.png","depth":"1"},{"id":"159","name":"斯巴鲁","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/159.png","depth":"1"},{"id":"160","name":"上汽大通","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/160.png","depth":"1"},{"id":"161","name":"双龙","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/161.png","depth":"1"},{"id":"162","name":"smart","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/162.png","depth":"1"},{"id":"163","name":"山姆","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/163.png","depth":"1"},{"id":"164","name":"STARTECH","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/164.png","depth":"1"},{"id":"165","name":"赛麟SALEEN","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/165.png","depth":"1"},{"id":"166","name":"世爵","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/166.png","depth":"1"},{"id":"167","name":"双环","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/167.png","depth":"1"},{"id":"168","name":"萨博","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/168.png","depth":"1"},{"id":"169","name":"陕汽通家","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/169.png","depth":"1"},{"id":"170","name":"三星","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/170.png","depth":"1"},{"id":"171","name":"上喆汽车","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/171.png","depth":"1"},{"id":"172","name":"顺旅","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/172.png","depth":"1"},{"id":"173","name":"特斯拉","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/173.png","depth":"1"},{"id":"174","name":"泰卡特","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/174.png","depth":"1"},{"id":"175","name":"腾势","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/175.png","depth":"1"},{"id":"176","name":"天马","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/176.png","depth":"1"},{"id":"177","name":"通田","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/177.png","depth":"1"},{"id":"178","name":"塔菲克","initial":"T","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/178.png","depth":"1"},{"id":"179","name":"五菱","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/179.png","depth":"1"},{"id":"180","name":"沃尔沃","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/180.png","depth":"1"},{"id":"181","name":"五十铃","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/181.png","depth":"1"},{"id":"182","name":"潍柴英致","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/182.png","depth":"1"},{"id":"183","name":"威麟","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/183.png","depth":"1"},{"id":"184","name":"威兹曼","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/184.png","depth":"1"},{"id":"185","name":"潍柴欧睿","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/185.png","depth":"1"},{"id":"186","name":"万丰","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/186.png","depth":"1"},{"id":"187","name":"现代","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/187.png","depth":"1"},{"id":"188","name":"雪佛兰","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/188.png","depth":"1"},{"id":"189","name":"雪铁龙","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/189.png","depth":"1"},{"id":"190","name":"星客特","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/190.png","depth":"1"},{"id":"191","name":"新凯","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/191.png","depth":"1"},{"id":"192","name":"西雅特","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/192.png","depth":"1"},{"id":"193","name":"新雅途","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/193.png","depth":"1"},{"id":"194","name":"新大地","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/194.png","depth":"1"},{"id":"195","name":"英菲尼迪","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/195.png","depth":"1"},{"id":"196","name":"一汽","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/196.png","depth":"1"},{"id":"197","name":"野马汽车","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/197.png","depth":"1"},{"id":"198","name":"依维柯","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/198.png","depth":"1"},{"id":"199","name":"永源","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/199.png","depth":"1"},{"id":"200","name":"宇通","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/200.png","depth":"1"},{"id":"201","name":"御捷","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/201.png","depth":"1"},{"id":"202","name":"游侠汽车","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/202.png","depth":"1"},{"id":"203","name":"云豹","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/203.png","depth":"1"},{"id":"204","name":"扬州亚星客车","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/204.png","depth":"1"},{"id":"205","name":"云雀","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/205.png","depth":"1"},{"id":"206","name":"仪征","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/206.png","depth":"1"},{"id":"207","name":"友谊客车","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/207.png","depth":"1"},{"id":"208","name":"众泰","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/208.png","depth":"1"},{"id":"209","name":"中华","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/209.png","depth":"1"},{"id":"210","name":"知豆","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/210.png","depth":"1"},{"id":"211","name":"中兴","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/211.png","depth":"1"},{"id":"212","name":"中欧奔驰房车","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/212.png","depth":"1"},{"id":"213","name":"浙江卡尔森","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/213.png","depth":"1"},{"id":"214","name":"重汽王牌","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/214.png","depth":"1"},{"id":"215","name":"之诺","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/215.png","depth":"1"},{"id":"216","name":"中通客车","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/216.png","depth":"1"},{"id":"217","name":"中顺","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/217.png","depth":"1"},{"id":"218","name":"中客华北","initial":"Z","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/218.png","depth":"1"},{"id":"33690","name":"阿尔特","initial":"A","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33691","name":"比速汽车","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33692","name":"北汽瑞丽","initial":"B","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33693","name":"东风风诺","initial":"D","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33694","name":"汉腾","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33695","name":"华凯","initial":"H","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33696","name":"LeSEE","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33697","name":"SWM斯威汽车","initial":"S","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33698","name":"WEY","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33699","name":"蔚来","initial":"W","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33700","name":"小鹏汽车","initial":"X","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33701","name":"驭胜","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"33702","name":"雅宾纳","initial":"Y","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"37312","name":"Faraday Future","initial":"F","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"},{"id":"37313","name":"领克","initial":"L","parentid":"0","logo":"http://api.jisuapi.com/car/static/images/logo/300/","depth":"1"}]
     */

    private String status;
    private String msg;
    private List<ResultBean> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * name : 奥迪
         * initial : A
         * parentid : 0
         * logo : http://api.jisuapi.com/car/static/images/logo/300/1.png
         * depth : 1
         */

        private String id;
        private String name;
        private String initial;
        private String parentid;
        private String logo;
        private String depth;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInitial() {
            return initial;
        }

        public void setInitial(String initial) {
            this.initial = initial;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getDepth() {
            return depth;
        }

        public void setDepth(String depth) {
            this.depth = depth;
        }
    }
}