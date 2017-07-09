package com.zjk.my_app.entity;

/**
 * Created by zjk on 2017/5/16.
 */

public class Weather {

    /**
     * resultcode : 200
     * reason : 查询成功
     * result : {"sk":{"temp":"18","wind_direction":"南风","wind_strength":"1级","humidity":"94%","time":"22:10"},"today":{"temperature":"15℃~26℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"微风","week":"星期二","city":"武汉","date_y":"2017年05月16日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20170516":{"temperature":"15℃~26℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"微风","week":"星期二","date":"20170516"},"day_20170517":{"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期三","date":"20170517"},"day_20170518":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期四","date":"20170518"},"day_20170519":{"temperature":"19℃~29℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期五","date":"20170519"},"day_20170520":{"temperature":"19℃~30℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期六","date":"20170520"},"day_20170521":{"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期日","date":"20170521"},"day_20170522":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期一","date":"20170522"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

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
        /**
         * sk : {"temp":"18","wind_direction":"南风","wind_strength":"1级","humidity":"94%","time":"22:10"}
         * today : {"temperature":"15℃~26℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"微风","week":"星期二","city":"武汉","date_y":"2017年05月16日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"中等","comfort_index":"","wash_index":"较适宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : {"day_20170516":{"temperature":"15℃~26℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"微风","week":"星期二","date":"20170516"},"day_20170517":{"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期三","date":"20170517"},"day_20170518":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期四","date":"20170518"},"day_20170519":{"temperature":"19℃~29℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期五","date":"20170519"},"day_20170520":{"temperature":"19℃~30℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期六","date":"20170520"},"day_20170521":{"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期日","date":"20170521"},"day_20170522":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期一","date":"20170522"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 18
             * wind_direction : 南风
             * wind_strength : 1级
             * humidity : 94%
             * time : 22:10
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 15℃~26℃
             * weather : 多云转晴
             * weather_id : {"fa":"01","fb":"00"}
             * wind : 微风
             * week : 星期二
             * city : 武汉
             * date_y : 2017年05月16日
             * dressing_index : 舒适
             * dressing_advice : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
             * uv_index : 中等
             * comfort_index :
             * wash_index : 较适宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String week;
            private String city;
            private String date_y;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 01
                 * fb : 00
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20170516 : {"temperature":"15℃~26℃","weather":"多云转晴","weather_id":{"fa":"01","fb":"00"},"wind":"微风","week":"星期二","date":"20170516"}
             * day_20170517 : {"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期三","date":"20170517"}
             * day_20170518 : {"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期四","date":"20170518"}
             * day_20170519 : {"temperature":"19℃~29℃","weather":"阴转多云","weather_id":{"fa":"02","fb":"01"},"wind":"微风","week":"星期五","date":"20170519"}
             * day_20170520 : {"temperature":"19℃~30℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期六","date":"20170520"}
             * day_20170521 : {"temperature":"18℃~28℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"微风","week":"星期日","date":"20170521"}
             * day_20170522 : {"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"微风","week":"星期一","date":"20170522"}
             */

            private Day20170516Bean day_20170516;
            private Day20170517Bean day_20170517;
            private Day20170518Bean day_20170518;
            private Day20170519Bean day_20170519;
            private Day20170520Bean day_20170520;
            private Day20170521Bean day_20170521;
            private Day20170522Bean day_20170522;

            public Day20170516Bean getDay_20170516() {
                return day_20170516;
            }

            public void setDay_20170516(Day20170516Bean day_20170516) {
                this.day_20170516 = day_20170516;
            }

            public Day20170517Bean getDay_20170517() {
                return day_20170517;
            }

            public void setDay_20170517(Day20170517Bean day_20170517) {
                this.day_20170517 = day_20170517;
            }

            public Day20170518Bean getDay_20170518() {
                return day_20170518;
            }

            public void setDay_20170518(Day20170518Bean day_20170518) {
                this.day_20170518 = day_20170518;
            }

            public Day20170519Bean getDay_20170519() {
                return day_20170519;
            }

            public void setDay_20170519(Day20170519Bean day_20170519) {
                this.day_20170519 = day_20170519;
            }

            public Day20170520Bean getDay_20170520() {
                return day_20170520;
            }

            public void setDay_20170520(Day20170520Bean day_20170520) {
                this.day_20170520 = day_20170520;
            }

            public Day20170521Bean getDay_20170521() {
                return day_20170521;
            }

            public void setDay_20170521(Day20170521Bean day_20170521) {
                this.day_20170521 = day_20170521;
            }

            public Day20170522Bean getDay_20170522() {
                return day_20170522;
            }

            public void setDay_20170522(Day20170522Bean day_20170522) {
                this.day_20170522 = day_20170522;
            }

            public static class Day20170516Bean {
                /**
                 * temperature : 15℃~26℃
                 * weather : 多云转晴
                 * weather_id : {"fa":"01","fb":"00"}
                 * wind : 微风
                 * week : 星期二
                 * date : 20170516
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 01
                     * fb : 00
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170517Bean {
                /**
                 * temperature : 18℃~28℃
                 * weather : 晴
                 * weather_id : {"fa":"00","fb":"00"}
                 * wind : 微风
                 * week : 星期三
                 * date : 20170517
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXX {
                    /**
                     * fa : 00
                     * fb : 00
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170518Bean {
                /**
                 * temperature : 20℃~30℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 微风
                 * week : 星期四
                 * date : 20170518
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170519Bean {
                /**
                 * temperature : 19℃~29℃
                 * weather : 阴转多云
                 * weather_id : {"fa":"02","fb":"01"}
                 * wind : 微风
                 * week : 星期五
                 * date : 20170519
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXX {
                    /**
                     * fa : 02
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170520Bean {
                /**
                 * temperature : 19℃~30℃
                 * weather : 晴
                 * weather_id : {"fa":"00","fb":"00"}
                 * wind : 微风
                 * week : 星期六
                 * date : 20170520
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXX {
                    /**
                     * fa : 00
                     * fb : 00
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170521Bean {
                /**
                 * temperature : 18℃~28℃
                 * weather : 晴
                 * weather_id : {"fa":"00","fb":"00"}
                 * wind : 微风
                 * week : 星期日
                 * date : 20170521
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 00
                     * fb : 00
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170522Bean {
                /**
                 * temperature : 20℃~30℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 微风
                 * week : 星期一
                 * date : 20170522
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}
