package net.sunmingchun.www.test.service;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

/**
 * net.sunmingchun.www.test.service
 * Created by smc
 * date on 2016/3/10.
 * Email:sunmch@163.com
 */
public class JedisSerice {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.20.130",6379);
//        jedis.select(1);
//        jedis.
        Long db = jedis.getDB();
        System.out.println(db);
        U u = new U();
        u.setPassword("sssss");
        u.setUsername("smc");
        String json = JSON.toJSONString(u);
        System.out.println("u: "+ json);
//        jedis.set
        String result = jedis.get("123");
        System.out.println("result: "+ result);
    }
}

class U{
        private  String username;

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
