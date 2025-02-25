package com.wanted_server.Service;

import com.wanted_server.Class.Connect;
import com.wanted_server.Class.Personal;
import com.wanted_server.Class.Posting;
import com.wanted_server.Dto.PostingUpdateDto;
import com.wanted_server.Repository.ConnectRepository;
import com.wanted_server.Repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ConnectService {

    private final ConnectRepository connectRepository;
    private final PostingRepository postingRepository;

    // 커넥트 만들기
    public Long make(Connect connect, Long postingId, Long senderId){
        Posting posting = postingRepository.findById(postingId).get();
        connect.setPosting(posting);
        connect.setSenderId(senderId);

        connectRepository.save(connect);
        return connect.getId();
    }

    // 전체 커넥트 데이터 가져오기
//    @Transactional(readOnly = true)
//    public List<Posting> findPostings() {
//        return postingRepository.findAll();
//    }

    // 포스트 삭제
    public Long delete(Long postingId) {
        connectRepository.deleteById(postingId);
        return postingId;
    }
}
