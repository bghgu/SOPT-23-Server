package org.sopt.seminar8.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.domain.Item;
import org.sopt.seminar8.domain.Token;
import org.sopt.seminar8.repository.ItemRepository;
import org.sopt.seminar8.repository.RedisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by ds on 2018-12-26.
 */

@Slf4j
@RestController
public class TestController {

    //jpa
    private final ItemRepository itemRepository;

    public TestController(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("jpa")
    public ResponseEntity jpaTest() {
        try {
            final Item item = new Item(1, "test");
            log.info("----------------jpa insert data----------------");
            itemRepository.save(item);
            log.info("----------------jpa findOne data----------------");
            Optional<Item> content = itemRepository.findById(1);
            log.info(content.toString());
            log.info("----------------jpa findAll data----------------");
            Iterable<Item> contentList = itemRepository.findAll();
            log.info(contentList.toString());
            log.info("----------------jpa delete data----------------");
            itemRepository.delete(item);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("redis")
    public ResponseEntity redisRedis() {
        try {
            Token token = new Token();

            log.info("----------------redis insert data----------------");
            //redisRepository.save(token);

            log.info("----------------redis findAll data----------------");
            //Iterable<Token> contentList = redisRepository.findAll();
            //log.info(contentList.toString());

            log.info("----------------redis delete data----------------");
            //redisRepository.delete(token);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
