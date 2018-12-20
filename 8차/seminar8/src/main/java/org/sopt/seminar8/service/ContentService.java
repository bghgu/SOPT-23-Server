package org.sopt.seminar8.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar8.domain.Content;
import org.sopt.seminar8.mapper.ContentMapper;
import org.sopt.seminar8.model.DefaultRes;
import org.sopt.seminar8.repository.ContentRepository;
import org.sopt.seminar8.utils.ResponseMessage;
import org.sopt.seminar8.utils.StatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by ds on 2018-12-19.
 */

@Slf4j
@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;

    public ContentService(final ContentRepository contentRepository, final ContentMapper contentMapper) {
        this.contentRepository = contentRepository;
        this.contentMapper = contentMapper;
    }

    public DefaultRes<Iterable<Content>> findAll() {
        Iterable<Content> contentList = contentRepository.findAll();
        Iterable<Content> contents = contentMapper.findAll();
        return DefaultRes.res(StatusCode.OK, "조회 성공", contents);
    }

    @Transactional
    public DefaultRes save(final Content content) {
        try {
            contentRepository.save(content);
            return DefaultRes.res(StatusCode.CREATED, "저장 성공");
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    @Transactional
    public DefaultRes deleteByContentIdx(final int contentIdx) {
        try {
            contentRepository.deleteById(contentIdx);
            return DefaultRes.res(StatusCode.NO_CONTENT, "삭제 성공");
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
