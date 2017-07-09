package com.zjk.my_app.entity;

import java.util.List;

/**
 * Created by tarena on 2017/5/10.
 */

public class Weatherbean {

    /**
     * result : {"realtime":{"wind":{"windspeed":null,"direct":"南风","power":"2级","offset":null},"time":"18:00:00","weather":{"humidity":"58","img":"3","info":"阵雨","temperature":"33"},"dataUptime":"1499163965","date":"2017-07-04","city_code":"101200101","city_name":"武汉","week":"2","moon":"六月十一"},"life":{"date":"2017-7-4","info":{"kongtiao":["部分时间开启","天气热同时湿度大，您需要适当开启制冷空调，来降温除湿，免受闷热之苦。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":null,"wuran":null,"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"]}},"weather":[{"date":"2017-07-04","week":"二","nongli":"六月十一","info":{"dawn":null,"day":["3","阵雨","33","","微风","05:26","出门记得带伞，行走驾驶做好防滑准备"],"night":["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2017-07-05","week":"三","nongli":"六月十二","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","33","","微风","05:27","出门记得带伞，行走驾驶做好防滑准备"],"night":["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2017-07-06","week":"四","nongli":"六月十三","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","34","","微风","05:27"],"night":["2","阴","26","","微风","19:29"]}},{"date":"2017-07-07","week":"五","nongli":"六月十四","info":{"dawn":["2","阴","26","无持续风向","微风","19:29"],"day":["7","小雨","33","","微风","05:28"],"night":["1","多云","26","","微风","19:29"]}},{"date":"2017-07-08","week":"六","nongli":"六月十五","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","32","","微风","05:28"],"night":["1","多云","26","","微风","19:29"]}},{"date":"2017-07-09","week":"日","nongli":"六月十六","info":{"dawn":null,"day":["4","雷阵雨","30","西南风","4级","07:30"],"night":["4","雷阵雨","26","西南风","4级","19:30"]}},{"date":"2017-07-10","week":"一","nongli":"六月十七","info":{"dawn":null,"day":["4","雷阵雨","28","西南风","微风","07:30"],"night":["4","雷阵雨","24","西南风","微风","19:30"]}}],"pm25":{"key":"Wuhan","show_desc":"0","pm25":{"curPm":"32","pm25":"13","pm10":"25","level":"1","quality":"优","des":"空气很好，可以外出活动"},"dateTime":"2017年07月04日18时","cityName":"武汉"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":null,"direct":"南风","power":"2级","offset":null},"time":"18:00:00","weather":{"humidity":"58","img":"3","info":"阵雨","temperature":"33"},"dataUptime":"1499163965","date":"2017-07-04","city_code":"101200101","city_name":"武汉","week":"2","moon":"六月十一"}
         * life : {"date":"2017-7-4","info":{"kongtiao":["部分时间开启","天气热同时湿度大，您需要适当开启制冷空调，来降温除湿，免受闷热之苦。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":null,"wuran":null,"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"]}}
         * weather : [{"date":"2017-07-04","week":"二","nongli":"六月十一","info":{"dawn":null,"day":["3","阵雨","33","","微风","05:26","出门记得带伞，行走驾驶做好防滑准备"],"night":["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2017-07-05","week":"三","nongli":"六月十二","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","33","","微风","05:27","出门记得带伞，行走驾驶做好防滑准备"],"night":["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2017-07-06","week":"四","nongli":"六月十三","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","34","","微风","05:27"],"night":["2","阴","26","","微风","19:29"]}},{"date":"2017-07-07","week":"五","nongli":"六月十四","info":{"dawn":["2","阴","26","无持续风向","微风","19:29"],"day":["7","小雨","33","","微风","05:28"],"night":["1","多云","26","","微风","19:29"]}},{"date":"2017-07-08","week":"六","nongli":"六月十五","info":{"dawn":["1","多云","26","无持续风向","微风","19:29"],"day":["7","小雨","32","","微风","05:28"],"night":["1","多云","26","","微风","19:29"]}},{"date":"2017-07-09","week":"日","nongli":"六月十六","info":{"dawn":null,"day":["4","雷阵雨","30","西南风","4级","07:30"],"night":["4","雷阵雨","26","西南风","4级","19:30"]}},{"date":"2017-07-10","week":"一","nongli":"六月十七","info":{"dawn":null,"day":["4","雷阵雨","28","西南风","微风","07:30"],"night":["4","雷阵雨","24","西南风","微风","19:30"]}}]
         * pm25 : {"key":"Wuhan","show_desc":"0","pm25":{"curPm":"32","pm25":"13","pm10":"25","level":"1","quality":"优","des":"空气很好，可以外出活动"},"dateTime":"2017年07月04日18时","cityName":"武汉"}
         * isForeign : 0
         */

        private RealtimeBean realtime;
        private LifeBean life;
        private Pm25BeanX pm25;
        private int isForeign;
        private List<WeatherBeanX> weather;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25BeanX getPm25() {
            return pm25;
        }

        public void setPm25(Pm25BeanX pm25) {
            this.pm25 = pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public List<WeatherBeanX> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBeanX> weather) {
            this.weather = weather;
        }

        public static class RealtimeBean {
            /**
             * wind : {"windspeed":null,"direct":"南风","power":"2级","offset":null}
             * time : 18:00:00
             * weather : {"humidity":"58","img":"3","info":"阵雨","temperature":"33"}
             * dataUptime : 1499163965
             * date : 2017-07-04
             * city_code : 101200101
             * city_name : 武汉
             * week : 2
             * moon : 六月十一
             */

            private WindBean wind;
            private String time;
            private WeatherBean weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public static class WindBean {
                /**
                 * windspeed : null
                 * direct : 南风
                 * power : 2级
                 * offset : null
                 */

                private Object windspeed;
                private String direct;
                private String power;
                private Object offset;

                public Object getWindspeed() {
                    return windspeed;
                }

                public void setWindspeed(Object windspeed) {
                    this.windspeed = windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public Object getOffset() {
                    return offset;
                }

                public void setOffset(Object offset) {
                    this.offset = offset;
                }
            }

            public static class WeatherBean {
                /**
                 * humidity : 58
                 * img : 3
                 * info : 阵雨
                 * temperature : 33
                 */

                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class LifeBean {
            /**
             * date : 2017-7-4
             * info : {"kongtiao":["部分时间开启","天气热同时湿度大，您需要适当开启制冷空调，来降温除湿，免受闷热之苦。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":null,"wuran":null,"chuanyi":["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"]}
             */

            private String date;
            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * kongtiao : ["部分时间开启","天气热同时湿度大，您需要适当开启制冷空调，来降温除湿，免受闷热之苦。"]
                 * yundong : ["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"]
                 * ziwaixian : ["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]
                 * ganmao : ["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"]
                 * xiche : null
                 * wuran : null
                 * chuanyi : ["炎热","天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"]
                 */

                private Object xiche;
                private Object wuran;
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> chuanyi;

                public Object getXiche() {
                    return xiche;
                }

                public void setXiche(Object xiche) {
                    this.xiche = xiche;
                }

                public Object getWuran() {
                    return wuran;
                }

                public void setWuran(Object wuran) {
                    this.wuran = wuran;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }
            }
        }

        public static class Pm25BeanX {
            /**
             * key : Wuhan
             * show_desc : 0
             * pm25 : {"curPm":"32","pm25":"13","pm10":"25","level":"1","quality":"优","des":"空气很好，可以外出活动"}
             * dateTime : 2017年07月04日18时
             * cityName : 武汉
             */

            private String key;
            private String show_desc;
            private Pm25Bean pm25;
            private String dateTime;
            private String cityName;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public static class Pm25Bean {
                /**
                 * curPm : 32
                 * pm25 : 13
                 * pm10 : 25
                 * level : 1
                 * quality : 优
                 * des : 空气很好，可以外出活动
                 */

                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }

        public static class WeatherBeanX {
            /**
             * date : 2017-07-04
             * week : 二
             * nongli : 六月十一
             * info : {"dawn":null,"day":["3","阵雨","33","","微风","05:26","出门记得带伞，行走驾驶做好防滑准备"],"night":["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]}
             */

            private String date;
            private String week;
            private String nongli;
            private InfoBeanX info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            public static class InfoBeanX {
                /**
                 * dawn : null
                 * day : ["3","阵雨","33","","微风","05:26","出门记得带伞，行走驾驶做好防滑准备"]
                 * night : ["1","多云","26","","微风","19:29","出门记得带伞，行走驾驶做好防滑准备"]
                 */

                private Object dawn;
                private List<String> day;
                private List<String> night;

                public Object getDawn() {
                    return dawn;
                }

                public void setDawn(Object dawn) {
                    this.dawn = dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}

    /**
     * reason : 查询成功!
     * result : {"data":{"realtime":{"city_code":"101010100","city_name":"北京","date":"2017-05-10","time":"09:00:00","week":3,"moon":"四月十五","dataUptime":1494378601,"weather":{"temperature":"19","humidity":"60","info":"多云","img":"1"},"wind":{"direct":"东北风","power":"2级","offset":null,"windspeed":null}},"life":{"date":"2017-5-10","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，但因气温较高且风力较强，请适当降低运动强度并注意户外防风。"],"ziwaixian":["很强","紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"]}},"weather":[{"date":"2017-05-10","info":{"day":["0","晴","30","南风","3-4 级","05:05"],"night":["0","晴","15","北风","微风","19:17"]},"week":"三","nongli":"四月十五"},{"date":"2017-05-11","info":{"dawn":["0","晴","15","北风","微风","19:17"],"day":["0","晴","32","北风","4-5 级","05:04"],"night":["1","多云","13","南风","微风","19:18"]},"week":"四","nongli":"四月十六"},{"date":"2017-05-12","info":{"dawn":["1","多云","13","南风","微风","19:18"],"day":["1","多云","30","西南风","3-4 级","05:03"],"night":["0","晴","17","西北风","微风","19:18"]},"week":"五","nongli":"四月十七"},{"date":"2017-05-13","info":{"dawn":["0","晴","17","西北风","微风","19:18"],"day":["1","多云","28","北风","3-4 级","05:02"],"night":["0","晴","16","北风","微风","19:19"]},"week":"六","nongli":"四月十八"},{"date":"2017-05-14","info":{"dawn":["0","晴","16","北风","微风","19:19"],"day":["1","多云","27","北风","3-4 级","05:01"],"night":["1","多云","15","北风","3-4 级","19:20"]},"week":"日","nongli":"四月十九"},{"date":"2017-05-15","info":{"night":["0","晴","16","西北风","微风","19:30"],"day":["0","晴","31","西北风","微风","07:30"]},"week":"一","nongli":"四月二十"},{"date":"2017-05-16","info":{"night":["0","晴","17","","微风","19:30"],"day":["0","晴","33","","微风","07:30"]},"week":"二","nongli":"四月廿一"}],"f3h":{"temperature":[{"jg":"20170510080000","jb":"19"},{"jg":"20170510110000","jb":"25"},{"jg":"20170510140000","jb":"28"},{"jg":"20170510170000","jb":"29"},{"jg":"20170510200000","jb":"26"},{"jg":"20170510230000","jb":"21"},{"jg":"20170511020000","jb":"17"},{"jg":"20170511050000","jb":"15"},{"jg":"20170511080000","jb":"22"}],"precipitation":[{"jg":"20170510080000","jf":"0.1"},{"jg":"20170510110000","jf":"0"},{"jg":"20170510140000","jf":"0"},{"jg":"20170510170000","jf":"0"},{"jg":"20170510200000","jf":"0"},{"jg":"20170510230000","jf":"0"},{"jg":"20170511020000","jf":"0"},{"jg":"20170511050000","jf":"0"},{"jg":"20170511080000","jf":"0"}]},"pm25":{"key":"Beijing","show_desc":0,"pm25":{"curPm":"78","pm25":"57","pm10":"75","level":2,"quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"},"dateTime":"2017年05月10日08时","cityName":"北京"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}}
     * error_code : 0
     *//*

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        *//**
         * data : {"realtime":{"city_code":"101010100","city_name":"北京","date":"2017-05-10","time":"09:00:00","week":3,"moon":"四月十五","dataUptime":1494378601,"weather":{"temperature":"19","humidity":"60","info":"多云","img":"1"},"wind":{"direct":"东北风","power":"2级","offset":null,"windspeed":null}},"life":{"date":"2017-5-10","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，但因气温较高且风力较强，请适当降低运动强度并注意户外防风。"],"ziwaixian":["很强","紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"]}},"weather":[{"date":"2017-05-10","info":{"day":["0","晴","30","南风","3-4 级","05:05"],"night":["0","晴","15","北风","微风","19:17"]},"week":"三","nongli":"四月十五"},{"date":"2017-05-11","info":{"dawn":["0","晴","15","北风","微风","19:17"],"day":["0","晴","32","北风","4-5 级","05:04"],"night":["1","多云","13","南风","微风","19:18"]},"week":"四","nongli":"四月十六"},{"date":"2017-05-12","info":{"dawn":["1","多云","13","南风","微风","19:18"],"day":["1","多云","30","西南风","3-4 级","05:03"],"night":["0","晴","17","西北风","微风","19:18"]},"week":"五","nongli":"四月十七"},{"date":"2017-05-13","info":{"dawn":["0","晴","17","西北风","微风","19:18"],"day":["1","多云","28","北风","3-4 级","05:02"],"night":["0","晴","16","北风","微风","19:19"]},"week":"六","nongli":"四月十八"},{"date":"2017-05-14","info":{"dawn":["0","晴","16","北风","微风","19:19"],"day":["1","多云","27","北风","3-4 级","05:01"],"night":["1","多云","15","北风","3-4 级","19:20"]},"week":"日","nongli":"四月十九"},{"date":"2017-05-15","info":{"night":["0","晴","16","西北风","微风","19:30"],"day":["0","晴","31","西北风","微风","07:30"]},"week":"一","nongli":"四月二十"},{"date":"2017-05-16","info":{"night":["0","晴","17","","微风","19:30"],"day":["0","晴","33","","微风","07:30"]},"week":"二","nongli":"四月廿一"}],"f3h":{"temperature":[{"jg":"20170510080000","jb":"19"},{"jg":"20170510110000","jb":"25"},{"jg":"20170510140000","jb":"28"},{"jg":"20170510170000","jb":"29"},{"jg":"20170510200000","jb":"26"},{"jg":"20170510230000","jb":"21"},{"jg":"20170511020000","jb":"17"},{"jg":"20170511050000","jb":"15"},{"jg":"20170511080000","jb":"22"}],"precipitation":[{"jg":"20170510080000","jf":"0.1"},{"jg":"20170510110000","jf":"0"},{"jg":"20170510140000","jf":"0"},{"jg":"20170510170000","jf":"0"},{"jg":"20170510200000","jf":"0"},{"jg":"20170510230000","jf":"0"},{"jg":"20170511020000","jf":"0"},{"jg":"20170511050000","jf":"0"},{"jg":"20170511080000","jf":"0"}]},"pm25":{"key":"Beijing","show_desc":0,"pm25":{"curPm":"78","pm25":"57","pm10":"75","level":2,"quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"},"dateTime":"2017年05月10日08时","cityName":"北京"},"jingqu":"","jingqutq":"","date":"","isForeign":"0"}
         *//*

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            *//**
             * realtime : {"city_code":"101010100","city_name":"北京","date":"2017-05-10","time":"09:00:00","week":3,"moon":"四月十五","dataUptime":1494378601,"weather":{"temperature":"19","humidity":"60","info":"多云","img":"1"},"wind":{"direct":"东北风","power":"2级","offset":null,"windspeed":null}}
             * life : {"date":"2017-5-10","info":{"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，但因气温较高且风力较强，请适当降低运动强度并注意户外防风。"],"ziwaixian":["很强","紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"]}}
             * weather : [{"date":"2017-05-10","info":{"day":["0","晴","30","南风","3-4 级","05:05"],"night":["0","晴","15","北风","微风","19:17"]},"week":"三","nongli":"四月十五"},{"date":"2017-05-11","info":{"dawn":["0","晴","15","北风","微风","19:17"],"day":["0","晴","32","北风","4-5 级","05:04"],"night":["1","多云","13","南风","微风","19:18"]},"week":"四","nongli":"四月十六"},{"date":"2017-05-12","info":{"dawn":["1","多云","13","南风","微风","19:18"],"day":["1","多云","30","西南风","3-4 级","05:03"],"night":["0","晴","17","西北风","微风","19:18"]},"week":"五","nongli":"四月十七"},{"date":"2017-05-13","info":{"dawn":["0","晴","17","西北风","微风","19:18"],"day":["1","多云","28","北风","3-4 级","05:02"],"night":["0","晴","16","北风","微风","19:19"]},"week":"六","nongli":"四月十八"},{"date":"2017-05-14","info":{"dawn":["0","晴","16","北风","微风","19:19"],"day":["1","多云","27","北风","3-4 级","05:01"],"night":["1","多云","15","北风","3-4 级","19:20"]},"week":"日","nongli":"四月十九"},{"date":"2017-05-15","info":{"night":["0","晴","16","西北风","微风","19:30"],"day":["0","晴","31","西北风","微风","07:30"]},"week":"一","nongli":"四月二十"},{"date":"2017-05-16","info":{"night":["0","晴","17","","微风","19:30"],"day":["0","晴","33","","微风","07:30"]},"week":"二","nongli":"四月廿一"}]
             * f3h : {"temperature":[{"jg":"20170510080000","jb":"19"},{"jg":"20170510110000","jb":"25"},{"jg":"20170510140000","jb":"28"},{"jg":"20170510170000","jb":"29"},{"jg":"20170510200000","jb":"26"},{"jg":"20170510230000","jb":"21"},{"jg":"20170511020000","jb":"17"},{"jg":"20170511050000","jb":"15"},{"jg":"20170511080000","jb":"22"}],"precipitation":[{"jg":"20170510080000","jf":"0.1"},{"jg":"20170510110000","jf":"0"},{"jg":"20170510140000","jf":"0"},{"jg":"20170510170000","jf":"0"},{"jg":"20170510200000","jf":"0"},{"jg":"20170510230000","jf":"0"},{"jg":"20170511020000","jf":"0"},{"jg":"20170511050000","jf":"0"},{"jg":"20170511080000","jf":"0"}]}
             * pm25 : {"key":"Beijing","show_desc":0,"pm25":{"curPm":"78","pm25":"57","pm10":"75","level":2,"quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"},"dateTime":"2017年05月10日08时","cityName":"北京"}
             * jingqu :
             * jingqutq :
             * date :
             * isForeign : 0
             *//*

            private RealtimeBean realtime;
            private LifeBean life;
            private F3hBean f3h;
            private Pm25BeanX pm25;
            private String jingqu;
            private String jingqutq;
            private String date;
            private String isForeign;
            private List<WeatherBeanX> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public F3hBean getF3h() {
                return f3h;
            }

            public void setF3h(F3hBean f3h) {
                this.f3h = f3h;
            }

            public Pm25BeanX getPm25() {
                return pm25;
            }

            public void setPm25(Pm25BeanX pm25) {
                this.pm25 = pm25;
            }

            public String getJingqu() {
                return jingqu;
            }

            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }

            public String getJingqutq() {
                return jingqutq;
            }

            public void setJingqutq(String jingqutq) {
                this.jingqutq = jingqutq;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBeanX> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBeanX> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                *//**
                 * city_code : 101010100
                 * city_name : 北京
                 * date : 2017-05-10
                 * time : 09:00:00
                 * week : 3
                 * moon : 四月十五
                 * dataUptime : 1494378601
                 * weather : {"temperature":"19","humidity":"60","info":"多云","img":"1"}
                 * wind : {"direct":"东北风","power":"2级","offset":null,"windspeed":null}
                 *//*

                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private int week;
                private String moon;
                private int dataUptime;
                private WeatherBean weather;
                private WindBean wind;

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class WeatherBean {
                    *//**
                     * temperature : 19
                     * humidity : 60
                     * info : 多云
                     * img : 1
                     *//*

                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }

                public static class WindBean {
                    *//**
                     * direct : 东北风
                     * power : 2级
                     * offset : null
                     * windspeed : null
                     *//*

                    private String direct;
                    private String power;
                    private Object offset;
                    private Object windspeed;

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }

                    public Object getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(Object windspeed) {
                        this.windspeed = windspeed;
                    }
                }
            }

            public static class LifeBean {
                *//**
                 * date : 2017-5-10
                 * info : {"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"yundong":["较适宜","天气较好，但因气温较高且风力较强，请适当降低运动强度并注意户外防风。"],"ziwaixian":["很强","紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"]}
                 *//*

                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> chuanyi;
                    private List<String> ganmao;
                    private List<String> kongtiao;
                    private List<String> xiche;
                    private List<String> yundong;
                    private List<String> ziwaixian;

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }
                }
            }

            public static class F3hBean {
                private List<TemperatureBean> temperature;
                private List<PrecipitationBean> precipitation;

                public List<TemperatureBean> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBean> temperature) {
                    this.temperature = temperature;
                }

                public List<PrecipitationBean> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBean> precipitation) {
                    this.precipitation = precipitation;
                }

                public static class TemperatureBean {
                    *//**
                     * jg : 20170510080000
                     * jb : 19
                     *//*

                    private String jg;
                    private String jb;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJb() {
                        return jb;
                    }

                    public void setJb(String jb) {
                        this.jb = jb;
                    }
                }

                public static class PrecipitationBean {
                    *//**
                     * jg : 20170510080000
                     * jf : 0.1
                     *//*

                    private String jg;
                    private String jf;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJf() {
                        return jf;
                    }

                    public void setJf(String jf) {
                        this.jf = jf;
                    }
                }
            }

            public static class Pm25BeanX {
                *//**
                 * key : Beijing
                 * show_desc : 0
                 * pm25 : {"curPm":"78","pm25":"57","pm10":"75","level":2,"quality":"良","des":"可以正常在户外活动，易敏感人群应减少外出"}
                 * dateTime : 2017年05月10日08时
                 * cityName : 北京
                 *//*

                private String key;
                private int show_desc;
                private Pm25Bean pm25;
                private String dateTime;
                private String cityName;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public Pm25Bean getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25Bean pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class Pm25Bean {
                    *//**
                     * curPm : 78
                     * pm25 : 57
                     * pm10 : 75
                     * level : 2
                     * quality : 良
                     * des : 可以正常在户外活动，易敏感人群应减少外出
                     *//*

                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBeanX {
                *//**
                 * date : 2017-05-10
                 * info : {"day":["0","晴","30","南风","3-4 级","05:05"],"night":["0","晴","15","北风","微风","19:17"]}
                 * week : 三
                 * nongli : 四月十五
                 *//*

                private String date;
                private InfoBeanX info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBeanX getInfo() {
                    return info;
                }

                public void setInfo(InfoBeanX info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBeanX {
                    private String[] day;
                    private List<String> night;

                    public String[] getDay() {
                        return day;
                    }

                    public void setDay(String[] day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }
                }
            }
        }
    }
}
*/