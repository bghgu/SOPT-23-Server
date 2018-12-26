package org.sopt.seminar8.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.sopt.seminar8.domain.Item;
import org.sopt.seminar8.domain.mongo.Content;
import org.sopt.seminar8.domain.redis.Token;
import org.sopt.seminar8.mapper.ItemMapper;
import org.sopt.seminar8.repository.ItemRepository;
import org.sopt.seminar8.repository.MongoDBRepository;
import org.sopt.seminar8.repository.RedisRepository;
import org.sopt.seminar8.utils.ContextUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ds on 2018-12-24.
 */

@Slf4j
@RestController
public class TestController {

    //mybatis
    private final ItemMapper itemMapper;
    //jpa
    private final ItemRepository itemRepository;
    //mongoDB
    private final MongoDBRepository mongoDBRepository;
    //redis
    private final RedisRepository redisRepository;

    public TestController(final ItemMapper itemMapper, final ItemRepository itemRepository,
                          final MongoDBRepository mongoDBRepository, final RedisRepository redisRepository) {
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
        this.mongoDBRepository = mongoDBRepository;
        this.redisRepository = redisRepository;
    }

    @GetMapping("mybatis")
    public ResponseEntity mybatisTest() {
        try {
            log.info("----------------mybatis test start----------------");

            log.info("----------------mybatis insert data----------------");
            itemMapper.save(new Item());

            log.info("----------------mybatis findAll data----------------");
            List<Item> contentList = itemMapper.findAll();
            log.info(contentList.toString());

            log.info("----------------mybatis delete data----------------");
            itemMapper.deleteByName("test");

            log.info("----------------mybatis findAll data----------------");
            contentList = itemMapper.findAll();
            log.info(contentList.toString());

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("jpa")
    public ResponseEntity jpaTest(@Param("phone") final String phone) {
        try {
            log.info("----------------jpa test start----------------");

            log.info("----------------jpa insert data----------------");
            itemRepository.save(new Item());

            log.info("----------------jpa findAll data----------------");
            Iterable<Item> contentList = itemRepository.findAll();
            log.info(contentList.toString());

            log.info("----------------jpa delete data----------------");
            itemRepository.deleteByName("test");

            log.info("----------------jpa findAll data----------------");
            contentList = itemRepository.findAll();
            log.info(contentList.toString());

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("mongodb")
    public ResponseEntity mongoDBTest() {
        try {
            log.info("----------------mongodb test start----------------");

            log.info("----------------mongodb insert data----------------");
            mongoDBRepository.save(new Content());

            log.info("----------------mongodb findAll data----------------");
            Iterable<Content> contentList = mongoDBRepository.findAll();
            log.info(contentList.toString());

            log.info("----------------mongodb delete data----------------");
            Content content = new Content();
            content.setBody("test");
            //id로 삭제
            mongoDBRepository.delete(content);

            log.info("----------------mongodb findAll data----------------");
            contentList = mongoDBRepository.findAll();
            log.info(contentList.toString());

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("redis")
    public ResponseEntity redisRedis() {
        try {

            HttpSession httpSession = ContextUtils.getSession(true);
            log.info(httpSession.getId());

            log.info("----------------redis test start----------------");

            log.info("----------------redis insert data----------------");
            redisRepository.save(new Token());

            log.info("----------------redis findAll data----------------");
            Iterable<Token> contentList = redisRepository.findAll();
            log.info(contentList.toString());

            log.info("----------------redis delete data----------------");
            //redisRepository.deleteByName("test");
            redisRepository.delete(new Token());

            log.info("----------------redis findAll data----------------");
            contentList = redisRepository.findAll();
            log.info(contentList.toString());

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
